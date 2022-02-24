package com.gloria.gloriabnsservvalidarcliente.controller;

import com.gloria.gloriabnsservvalidarcliente.bean.ApiEncontrarBeneficiosIdSegmentacionResponse;
import com.gloria.gloriabnsservvalidarcliente.bean.ApiEncontrarSegmentacionResponse;
import com.gloria.gloriabnsservvalidarcliente.bean.ApiEncontrarSucursalClienteIdResponse;
import com.gloria.gloriabnsservvalidarcliente.bean.ApiValidarClienteResponse;
import com.gloria.gloriabnsservvalidarcliente.bean.ApiValidarTelefonoClienteResponse;
import com.gloria.gloriabnsservvalidarcliente.bean.BeneficioResponse;
import com.gloria.gloriabnsservvalidarcliente.bean.ClienteResponse;
import com.gloria.gloriabnsservvalidarcliente.bean.ResponseData;
import com.gloria.gloriabnsservvalidarcliente.bean.ResponseStatus;
import com.gloria.gloriabnsservvalidarcliente.bean.SegmentacionResponse;
import com.gloria.gloriabnsservvalidarcliente.bean.SucursalReponse;
import com.gloria.gloriabnsservvalidarcliente.bean.ValidarClienteRequest;
import com.gloria.gloriabnsservvalidarcliente.bean.ValidarClienteResponse;
import com.gloria.gloriabnsservvalidarcliente.service.IClienteService;
import com.gloria.gloriabnsservvalidarcliente.utils.Validar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST  })
public class Api {
    
    @Autowired
	private IClienteService service;
    
    @PostMapping("/validar-cliente")
	public ResponseEntity<ValidarClienteResponse> buscarClientePorTipoDocumentoNumeroDocumento(
		@RequestHeader("idTransaccion") String idTransaccion,
		@RequestHeader("empresa") String empresa,
		@RequestBody ValidarClienteRequest request, ClienteResponse clienteResponse2, ClienteResponse clienteResponse3) {
		ValidarClienteResponse validarClienteResponse = new ValidarClienteResponse();
		if(request.getTipo() > 2 || request.getTipo() < 0 || request.getTipo() == null){
			ResponseStatus responseStatus =  ResponseStatus.builder().codigoRespuesta("IDF001").descripcionRespuesta("Tipo de documento inválido.").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
            validarClienteResponse.setResponseStatus(responseStatus);
			return new ResponseEntity<ValidarClienteResponse>(validarClienteResponse, HttpStatus.OK);
		}

		if(request.getDocumento().length() > 11 || request.getDocumento().length() < 8 || request.getDocumento() == null || !Validar.onlyDigits(request.getDocumento())){
			ResponseStatus responseStatus =  ResponseStatus.builder().codigoRespuesta("IDF002").descripcionRespuesta("Número de Documento inválido").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
            validarClienteResponse.setResponseStatus(responseStatus);
			return new ResponseEntity<ValidarClienteResponse>(validarClienteResponse, HttpStatus.OK);
		}

		if(request.getTelefono().length() != 11 || !Validar.onlyDigits(request.getTelefono())){
			ResponseStatus responseStatus =  ResponseStatus.builder().codigoRespuesta("IDF003").descripcionRespuesta("Número de teléfono inválido").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
            validarClienteResponse.setResponseStatus(responseStatus);
			return new ResponseEntity<ValidarClienteResponse>(validarClienteResponse, HttpStatus.OK);
		}

		ApiValidarClienteResponse apiValidarClienteResponse = service.validarCliente(Integer.toString(request.getTipo()), request.getDocumento(), empresa);
		log.info(apiValidarClienteResponse.toString());
		if(apiValidarClienteResponse.getData().size() == 0){
			ResponseStatus responseStatus =  ResponseStatus.builder().codigoRespuesta("IDF004").descripcionRespuesta("Número de Documento no existe.").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
            validarClienteResponse.setResponseStatus(responseStatus);
			return new ResponseEntity<ValidarClienteResponse>(validarClienteResponse, HttpStatus.OK);
		}

		ClienteResponse clienteResponse = apiValidarClienteResponse.getData().get(0);
		
		ApiEncontrarSucursalClienteIdResponse apiEncontrarSucursalClienteIdResponse = service.encontrarSucursalClienteId(clienteResponse.getIdCliente());
		List<SucursalReponse> sucursales = new ArrayList<>();
		apiEncontrarSucursalClienteIdResponse.getData().forEach(value -> {
			SucursalReponse sucursalReponse = new SucursalReponse();
			sucursalReponse.setIdSucursal(value.getIdSucursal());
			sucursalReponse.setCodigoCliente(value.getCodigoCliente());
			sucursalReponse.setCalle(value.getCalle());
			sucursalReponse.setDistrito(value.getDistrito());
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

		
		ApiValidarTelefonoClienteResponse apiValidarTelefonoClienteResponse = service.validarTelefonoCliente(request.getTelefono(), clienteResponse.getIdCliente());
		log.info(apiValidarTelefonoClienteResponse.toString());
		if(apiValidarTelefonoClienteResponse.getData().size() == 0){
			ResponseData responseData = new ResponseData();
			responseData.setIdCliente(apiValidarClienteResponse.getData().get(0).getIdCliente());
			responseData.setNombre(apiValidarClienteResponse.getData().get(0).getNombre());
			responseData.setSucursales(sucursales);
			validarClienteResponse.setResponseData(responseData);
			ResponseStatus responseStatus =  ResponseStatus.builder().codigoRespuesta("IDF005").descripcionRespuesta("Número de teléfono no corresponde al cliente.").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
            validarClienteResponse.setResponseStatus(responseStatus);
			return new ResponseEntity<ValidarClienteResponse>(validarClienteResponse, HttpStatus.OK);
		}

		ResponseData responseData = new ResponseData();
		responseData.setIdCliente(apiValidarClienteResponse.getData().get(0).getIdCliente());
		responseData.setNombre(apiValidarClienteResponse.getData().get(0).getNombre());
		responseData.setSucursales(sucursales);
		validarClienteResponse.setResponseData(responseData);

		if(sucursales.size()>1){
			ResponseStatus responseStatus =  ResponseStatus.builder().codigoRespuesta("IDF007").descripcionRespuesta("Cliente existente con más de 1 sucursal").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
			validarClienteResponse.setResponseStatus(responseStatus);
			return new ResponseEntity<ValidarClienteResponse>(validarClienteResponse, HttpStatus.OK);
		}else{
			ResponseStatus responseStatus =  ResponseStatus.builder().codigoRespuesta("IDF006").descripcionRespuesta("Cliente existente con 1 sucursal").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
			validarClienteResponse.setResponseStatus(responseStatus);
			return new ResponseEntity<ValidarClienteResponse>(validarClienteResponse, HttpStatus.OK);
		}
	}

}
