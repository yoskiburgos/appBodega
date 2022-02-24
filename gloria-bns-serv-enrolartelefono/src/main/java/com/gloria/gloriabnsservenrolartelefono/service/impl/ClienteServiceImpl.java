package com.gloria.gloriabnsservenrolartelefono.service.impl;

import java.net.http.HttpHeaders;

import com.gloria.gloriabnsservenrolartelefono.bean.ApiEncontrarDetalleClienteSucursalIdResponse;
import com.gloria.gloriabnsservenrolartelefono.bean.ApiEncontrarSurucarlResponse;
import com.gloria.gloriabnsservenrolartelefono.bean.ApiEncontrarSurucarlTelefonoResponse;
import com.gloria.gloriabnsservenrolartelefono.bean.ApiEnrolarTelefonoClienteResponse;
import com.gloria.gloriabnsservenrolartelefono.bean.EnrolarTelefonoRequest;
import com.gloria.gloriabnsservenrolartelefono.constant.Constantes;
import com.gloria.gloriabnsservenrolartelefono.service.IClienteService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private RestTemplate clienteRest;


    @Override
    public ApiEncontrarSurucarlResponse encontrarSucursalId(Integer idSucursal) {
        String url = Constantes.CENTRO_CON_SERV_SUCURSAL + "/encontrar?idSucursal=" +idSucursal;
        log.info("[INICIO] - METODO: [encontrar-sucursal-id]");
        log.info("[URL] - METODO: [GET] = "+ url);
        long tiempoInicio = System.currentTimeMillis();
        ApiEncontrarSurucarlResponse response = clienteRest.getForObject(url, ApiEncontrarSurucarlResponse.class);
        log.info("Tiempo Transacurrido (ms): [" + (System.currentTimeMillis() - tiempoInicio) + "]");
		log.info("[FIN] - METODO: [encontrar-sucursal-id] ");
        return response;
    }


    @Override
    public ApiEncontrarDetalleClienteSucursalIdResponse encontrarDetalleClienteSucursalId(Integer idSucursal) {
        String url = Constantes.CENTRO_CON_SERV_SUCURSAL + "/encontrar-detalle-cliente?idSucursal=" +idSucursal;
        log.info("[INICIO] - METODO: [encontrar-detallecliente-sucursal-id]");
        log.info("[URL] - METODO: [GET] = "+ url);
        long tiempoInicio = System.currentTimeMillis();
        ApiEncontrarDetalleClienteSucursalIdResponse response = clienteRest.getForObject(url, ApiEncontrarDetalleClienteSucursalIdResponse.class);
        log.info("Tiempo Transacurrido (ms): [" + (System.currentTimeMillis() - tiempoInicio) + "]");
		log.info("[FIN] - METODO: [encontrar-detallecliente-sucursal-id] ");
        return response;
    }


    @Override
    public ApiEnrolarTelefonoClienteResponse enrolarTelefonoCliente(EnrolarTelefonoRequest request) {
        String url = Constantes.CENTRO_CON_SERV_ENROLAMIENTO + "/enrolar-telefono-cliente";
        log.info("[INICIO] - METODO: [encontrar-enrolar-telefono-cliente]");
        log.info("[URL] - METODO: [POST] = "+ url);
        long tiempoInicio = System.currentTimeMillis();
        ApiEnrolarTelefonoClienteResponse response = clienteRest.postForObject(url, request, ApiEnrolarTelefonoClienteResponse.class);
        log.info("Tiempo Transacurrido (ms): [" + (System.currentTimeMillis() - tiempoInicio) + "]");
		log.info("[FIN] - METODO: [encontrar-enrolar-telefono-cliente] ");
        return response;
    }


    @Override
    public ApiEncontrarSurucarlTelefonoResponse encontrarSucursalIdTelefono(Integer idSucursal, String telefono) {
        String url = Constantes.CENTRO_CON_SERV_SUCURSAL + "/encontrar-telefono?idSucursal=" +idSucursal +"&telefono="+telefono;
        log.info("[INICIO] - METODO: [encontrar-sucursal-sucursal-id-telefono]");
        log.info("[URL] - METODO: [GET] = "+ url);
        long tiempoInicio = System.currentTimeMillis();
        ApiEncontrarSurucarlTelefonoResponse response = clienteRest.getForObject(url, ApiEncontrarSurucarlTelefonoResponse.class);
        log.info("Tiempo Transacurrido (ms): [" + (System.currentTimeMillis() - tiempoInicio) + "]");
		log.info("[FIN] - METODO: [encontrar-sucursal-sucursal-id-telefono] ");
        return response;
    }
    
}
