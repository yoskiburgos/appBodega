package com.gloria.gloriabnsservenrolartelefono.controller;


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


import com.gloria.gloriabnsservenrolartelefono.bean.ApiEncontrarDetalleClienteSucursalIdResponse;
import com.gloria.gloriabnsservenrolartelefono.bean.ApiEncontrarSurucarlResponse;
import com.gloria.gloriabnsservenrolartelefono.bean.ApiEncontrarSurucarlTelefonoResponse;
import com.gloria.gloriabnsservenrolartelefono.bean.ApiEnrolarTelefonoClienteResponse;
import com.gloria.gloriabnsservenrolartelefono.bean.EnrolarTelefonoRequest;
import com.gloria.gloriabnsservenrolartelefono.bean.EnrolarTelefonoResponse;
import com.gloria.gloriabnsservenrolartelefono.bean.ExisteSucursal;
import com.gloria.gloriabnsservenrolartelefono.bean.MensajeEnrolarTelefono;
import com.gloria.gloriabnsservenrolartelefono.bean.ResponseStatus;
import com.gloria.gloriabnsservenrolartelefono.service.IClienteService;
import com.gloria.gloriabnsservenrolartelefono.service.kafka.Producer;
import com.gloria.gloriabnsservenrolartelefono.utils.Validar;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST  })
public class Api {
    
    @Autowired
	private IClienteService service;

    

    @PostMapping("/enrolar-telefono")
	public ResponseEntity<EnrolarTelefonoResponse> enrolarTelefonoSucursal(@RequestHeader("idTransaccion") String idTransaccion, @RequestHeader("empresa") String empresa, @RequestBody EnrolarTelefonoRequest request) {
        EnrolarTelefonoResponse enrolarTelefonoResponse = new EnrolarTelefonoResponse();
        if(request.getTelefono().length() != 11 || !Validar.onlyDigits(request.getTelefono())){
            ResponseStatus responseStatus =  ResponseStatus.builder().codigoRespuesta("IDF001").descripcionRespuesta("Número de teléfono inválido.").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
            enrolarTelefonoResponse.setResponseStatus(responseStatus);
            return new ResponseEntity<EnrolarTelefonoResponse>(enrolarTelefonoResponse, HttpStatus.OK);
        }

        ExisteSucursal existeSucursal = new ExisteSucursal();
        existeSucursal.setExisteSucursal(true);
        request.getSucursales().forEach(value -> {
            if(existeSucursal.getExisteSucursal()){
                ApiEncontrarSurucarlResponse sucursal = service.encontrarSucursalId(value.getIdSucursal());
                if(sucursal.getData().size() == 0){
                    existeSucursal.setExisteSucursal(false);
                }
            }
        });

        if(!existeSucursal.getExisteSucursal()){
            ResponseStatus responseStatus =  ResponseStatus.builder().codigoRespuesta("IDF002").descripcionRespuesta("Listado de sucursales inválido.").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
            enrolarTelefonoResponse.setResponseStatus(responseStatus);
            return new ResponseEntity<EnrolarTelefonoResponse>(enrolarTelefonoResponse, HttpStatus.OK);
        }

        //Insertamos los datos en la tabla empresaCanalSucursal
        ApiEnrolarTelefonoClienteResponse enrolar = service.enrolarTelefonoCliente(request);
        if(enrolar.getStatus() != 0){
            ResponseStatus responseStatus =  ResponseStatus.builder().codigoRespuesta("IDF004").descripcionRespuesta("Sucursales no fueron enroladas").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
            enrolarTelefonoResponse.setResponseStatus(responseStatus);
            return new ResponseEntity<EnrolarTelefonoResponse>(enrolarTelefonoResponse, HttpStatus.OK);
        }

        /*
        //Validamos si el número de telefono existe en la sucursal
        request.getSucursales().forEach(value -> {
            ApiEncontrarSurucarlTelefonoResponse apiEncontrarSurucarlTelefonoResponse =  service.encontrarSucursalIdTelefono(value.getIdSucursal(), request.getTelefono());
            //Validamos si no existe el numero se actualizara en sucursal y en SAP
            if(apiEncontrarSurucarlTelefonoResponse.getData().size() == 0){
                ApiEncontrarDetalleClienteSucursalIdResponse detalleCliente =  service.encontrarDetalleClienteSucursalId(value.getIdSucursal());
                if(detalleCliente.getData().size()>0){
                    MensajeEnrolarTelefono mensaje = new MensajeEnrolarTelefono();
                    mensaje.setCodigoCliente(detalleCliente.getData().get(0).getCodigoCliente());
                    mensaje.setTelefono(request.getTelefono());
                    producer.publicarMensaje(mensaje.toString());
                }
            }
        });
        */
        
        ResponseStatus responseStatus =  ResponseStatus.builder().codigoRespuesta("IDF003").descripcionRespuesta("Sucursales enroladas correctamente.").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
        enrolarTelefonoResponse.setResponseStatus(responseStatus);
        return new ResponseEntity<EnrolarTelefonoResponse>(enrolarTelefonoResponse, HttpStatus.OK);
    }
}
