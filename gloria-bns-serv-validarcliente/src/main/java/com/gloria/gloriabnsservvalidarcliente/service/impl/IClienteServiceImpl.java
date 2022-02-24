package com.gloria.gloriabnsservvalidarcliente.service.impl;

import com.gloria.gloriabnsservvalidarcliente.bean.ApiValidarClienteResponse;
import com.gloria.gloriabnsservvalidarcliente.bean.ApiValidarTelefonoClienteResponse;
import com.gloria.gloriabnsservvalidarcliente.bean.ApiEncontrarBeneficiosIdSegmentacionResponse;
import com.gloria.gloriabnsservvalidarcliente.bean.ApiEncontrarSegmentacionResponse;
import com.gloria.gloriabnsservvalidarcliente.bean.ApiEncontrarSucursalClienteIdResponse;
import com.gloria.gloriabnsservvalidarcliente.constant.Constantes;
import com.gloria.gloriabnsservvalidarcliente.service.IClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class IClienteServiceImpl implements IClienteService{

    @Autowired
    private RestTemplate clienteRest;

    @Override
    public ApiValidarClienteResponse validarCliente(String tipoDocumento, String numeroDocumento, String codigoEmpresa) {
        String url = Constantes.CENTRO_CON_SERV_CLIENTE + "/encontrar-cliente?tipo=" +tipoDocumento+ "&numero=" +numeroDocumento+"&empresa=" +codigoEmpresa;
        log.info("[INICIO] - METODO: [encontrar-cliente]");
        log.info("[URL] - METODO: [GET] = "+ url);
        long tiempoInicio = System.currentTimeMillis();
        ApiValidarClienteResponse response = clienteRest.getForObject(url, ApiValidarClienteResponse.class);
        log.info("Tiempo Transacurrido (ms): [" + (System.currentTimeMillis() - tiempoInicio) + "]");
		log.info("[FIN] - METODO: [encontrar-cliente] ");
        return response;
    }

    @Override
    public ApiValidarTelefonoClienteResponse validarTelefonoCliente(String telefono, Integer idCliente) {
        String url = Constantes.CENTRO_CON_SERV_SUCURSAL + "/encontrar-telefono-cliente?telefono=" +telefono+ "&idCliente=" +idCliente;
        log.info("[INICIO] - METODO: [encontrar-telefono-cliente]");
        log.info("[URL] - METODO: [GET] = "+ url);
        long tiempoInicio = System.currentTimeMillis();
        ApiValidarTelefonoClienteResponse response = clienteRest.getForObject(url, ApiValidarTelefonoClienteResponse.class);
        log.info("Tiempo Transacurrido (ms): [" + (System.currentTimeMillis() - tiempoInicio) + "]");
		log.info("[FIN] - METODO: [encontrar-telefono-cliente] ");
        return response;
    }

    @Override
    public ApiEncontrarSegmentacionResponse encontrarIdSegmentacion(Integer idSegmentacion) {
        String url = Constantes.CENTRO_CON_SERV_SEGMENTACION + "/encontrar?idSegmentacion=" +idSegmentacion;
        log.info("[INICIO] - METODO: [encontrar-segmentacion]");
        log.info("[URL] - METODO: [GET] = "+ url);
        long tiempoInicio = System.currentTimeMillis();
        ApiEncontrarSegmentacionResponse response = clienteRest.getForObject(url, ApiEncontrarSegmentacionResponse.class);
        log.info("Tiempo Transacurrido (ms): [" + (System.currentTimeMillis() - tiempoInicio) + "]");
		log.info("[FIN] - METODO: [encontrar-segmentacion] ");
        return response;
    }

    @Override
    public ApiEncontrarBeneficiosIdSegmentacionResponse encontrarBeneficiosIdSegmentacion(Integer idSegmentacion) {
        String url = Constantes.CENTRO_CON_SERV_BENEFICIO + "/beneficios-segmentacion?idSegmentacion=" +idSegmentacion;
        log.info("[INICIO] - METODO: [encontrar-segmentacion]");
        log.info("[URL] - METODO: [GET] = "+ url);
        long tiempoInicio = System.currentTimeMillis();
        ApiEncontrarBeneficiosIdSegmentacionResponse response = clienteRest.getForObject(url, ApiEncontrarBeneficiosIdSegmentacionResponse.class);
        log.info("Tiempo Transacurrido (ms): [" + (System.currentTimeMillis() - tiempoInicio) + "]");
		log.info("[FIN] - METODO: [encontrar-segmentacion] ");
        return response;
    }

    @Override
    public ApiEncontrarSucursalClienteIdResponse encontrarSucursalClienteId(Integer idCliente) {
        String url = Constantes.CENTRO_CON_SERV_SUCURSAL + "/encontrar-cliente?idCliente=" +idCliente;
        log.info("[INICIO] - METODO: [encontrar-sucursal-cliente-id]");
        log.info("[URL] - METODO: [GET] = "+ url);
        long tiempoInicio = System.currentTimeMillis();
        ApiEncontrarSucursalClienteIdResponse response = clienteRest.getForObject(url, ApiEncontrarSucursalClienteIdResponse.class);
        log.info("Tiempo Transacurrido (ms): [" + (System.currentTimeMillis() - tiempoInicio) + "]");
		log.info("[FIN] - METODO: [encontrar-sucursal-cliente-id] ");
        return response;
    }

}
