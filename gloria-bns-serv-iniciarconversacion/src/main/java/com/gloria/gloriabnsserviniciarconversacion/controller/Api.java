package com.gloria.gloriabnsserviniciarconversacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.gloria.gloriabnsserviniciarconversacion.bean.ApiEncontrarBeneficiosIdSegmentacionResponse;
import com.gloria.gloriabnsserviniciarconversacion.bean.ApiEncontrarSegmentacionResponse;
import com.gloria.gloriabnsserviniciarconversacion.bean.ApiEncontrarTelefonoEnrolado;
import com.gloria.gloriabnsserviniciarconversacion.bean.ApiValidarTelefonoClienteResponse;
import com.gloria.gloriabnsserviniciarconversacion.bean.BeneficioResponse;
import com.gloria.gloriabnsserviniciarconversacion.bean.IniciarConversacionRequest;
import com.gloria.gloriabnsserviniciarconversacion.bean.IniciarConversacionResponse;
import com.gloria.gloriabnsserviniciarconversacion.bean.ResponseData;
import com.gloria.gloriabnsserviniciarconversacion.bean.ResponseStatus;
import com.gloria.gloriabnsserviniciarconversacion.bean.SegmentacionResponse;
import com.gloria.gloriabnsserviniciarconversacion.bean.SucursalReponse;
import com.gloria.gloriabnsserviniciarconversacion.bean.TelefonoEnroladoResponse;
import com.gloria.gloriabnsserviniciarconversacion.service.IClienteService;
import com.gloria.gloriabnsserviniciarconversacion.utils.Validar;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST  })
public class Api {
    
    @Autowired
	private IClienteService service;

    @GetMapping("/alive")
    public ResponseEntity<String> alive() {
        String alive = "it is alive";
        return ResponseEntity.ok(alive);
    }

    @PostMapping("/nueva-conversacion")
	public ResponseEntity<IniciarConversacionResponse> buscarClientePorTipoDocumentoNumeroDocumento(
		@RequestHeader("idTransaccion") String idTransaccion,
		@RequestHeader("empresa") String empresa,
		@RequestBody IniciarConversacionRequest request) {

            IniciarConversacionResponse nuevaConversacionResponse = new IniciarConversacionResponse();

            if(request.getTelefono().length() != 11 || !Validar.onlyDigits(request.getTelefono())){
                ResponseStatus responseStatus =  ResponseStatus.builder().codigoRespuesta("IDF001").descripcionRespuesta("Número de teléfono inválido").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
                nuevaConversacionResponse.setResponseStatus(responseStatus);
                return new ResponseEntity<IniciarConversacionResponse>(nuevaConversacionResponse, HttpStatus.OK);
            }

            ApiEncontrarTelefonoEnrolado apiEncontrarTelefonoEnrolado = service.encontrarTelefonoEnrolado(request.getTelefono());
            log.info(apiEncontrarTelefonoEnrolado.toString());
            if(apiEncontrarTelefonoEnrolado.getData().size() == 0){
                ResponseStatus responseStatus =  ResponseStatus.builder().codigoRespuesta("IDF002").descripcionRespuesta("Número de teléfono no esta enrolado.").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
                nuevaConversacionResponse.setResponseStatus(responseStatus);
                return new ResponseEntity<IniciarConversacionResponse>(nuevaConversacionResponse, HttpStatus.OK);
            }

            TelefonoEnroladoResponse telefonoEnroladoResponse = new TelefonoEnroladoResponse();
            telefonoEnroladoResponse = apiEncontrarTelefonoEnrolado.getData().get(0);

            ApiValidarTelefonoClienteResponse apiValidarTelefonoClienteResponse = service.validarTelefonoCliente(request.getTelefono(), telefonoEnroladoResponse.getIdCliente());
            log.info(apiValidarTelefonoClienteResponse.toString());

            List<SucursalReponse> sucursales = new ArrayList<>();
            apiValidarTelefonoClienteResponse.getData().forEach(value -> {
                SucursalReponse sucursalReponse = new SucursalReponse();
                sucursalReponse.setIdSucursal(value.getIdSucursal());
                sucursalReponse.setCodigoCliente(value.getCodigoCliente());
                sucursalReponse.setCalle(value.getCalle());
                sucursalReponse.setDistrito(value.getDistrito());
                sucursalReponse.setNombre(value.getNombre());
                ApiEncontrarSegmentacionResponse segmentacion = service.encontrarIdSegmentacion(value.getIdSegmentacion());
                List<SegmentacionResponse> segmentaciones = new ArrayList<>();
                segmentacion.getData().forEach(segmento -> {
                    SegmentacionResponse segmentacionResponse = new SegmentacionResponse();
                    segmentacionResponse.setIdSegmentacion(segmento.getIdSegmentacion());
                    segmentacionResponse.setCodigo(segmento.getCodigo());
                    segmentacionResponse.setNombre(segmento.getNombre());
                    ApiEncontrarBeneficiosIdSegmentacionResponse beneficio = service.encontrarBeneficiosIdSegmentacion(value.getIdSegmentacion());
                    List<BeneficioResponse> beneficios = new ArrayList<>();
                    beneficio.getData().forEach(data -> {
                        BeneficioResponse beneficioResponse = new BeneficioResponse();
                        beneficioResponse.setIdBeneficio(data.getIdBeneficio());
                        beneficioResponse.setDescuento(data.getDescuento());
                        beneficioResponse.setInformacion(data.getInformacion());
                        beneficios.add(beneficioResponse);
                    });
                    segmentacionResponse.setBeneficios(beneficios);
                    segmentaciones.add(segmentacionResponse);
                });
                sucursalReponse.setSegmentaciones(segmentaciones);
                sucursales.add(sucursalReponse);
                log.info(segmentacion.toString());
            });

            ResponseData responseData = new ResponseData();
            responseData.setIdCliente(apiEncontrarTelefonoEnrolado.getData().get(0).getIdCliente());
            responseData.setSucursales(sucursales);
            nuevaConversacionResponse.setResponseData(responseData);
            ResponseStatus responseStatus =  ResponseStatus.builder().codigoRespuesta("IDF003").descripcionRespuesta("Nueva conversación realizada con éxito.").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
            nuevaConversacionResponse.setResponseStatus(responseStatus);
            return new ResponseEntity<IniciarConversacionResponse>(nuevaConversacionResponse, HttpStatus.OK);

        } 
    
}
