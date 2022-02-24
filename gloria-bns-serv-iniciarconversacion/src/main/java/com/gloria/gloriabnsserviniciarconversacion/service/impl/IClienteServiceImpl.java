package com.gloria.gloriabnsserviniciarconversacion.service.impl;

import com.gloria.gloriabnsserviniciarconversacion.bean.ApiEncontrarBeneficiosIdSegmentacionResponse;
import com.gloria.gloriabnsserviniciarconversacion.bean.ApiEncontrarSegmentacionResponse;
import com.gloria.gloriabnsserviniciarconversacion.bean.ApiEncontrarTelefonoEnrolado;
import com.gloria.gloriabnsserviniciarconversacion.bean.ApiValidarTelefonoClienteResponse;
import com.gloria.gloriabnsserviniciarconversacion.constant.Constantes;
import com.gloria.gloriabnsserviniciarconversacion.service.IClienteService;

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
    public ApiEncontrarTelefonoEnrolado encontrarTelefonoEnrolado(String telefono) {
        String url = Constantes.CENTRO_CON_SERV_ENROLAMIENTO + "/encontrar-telefono-enrolado?telefono=" +telefono;
        log.info("[INICIO] - METODO: [encontrar-telefono-enrolado]");
        log.info("[URL] - METODO: [GET] = "+ url);
        long tiempoInicio = System.currentTimeMillis();
        ApiEncontrarTelefonoEnrolado response = clienteRest.getForObject(url, ApiEncontrarTelefonoEnrolado.class);
        log.info("Tiempo Transacurrido (ms): [" + (System.currentTimeMillis() - tiempoInicio) + "]");
		log.info("[FIN] - METODO: [encontrar-telefono-enrolado] ");
        return response;
    }
    
}
