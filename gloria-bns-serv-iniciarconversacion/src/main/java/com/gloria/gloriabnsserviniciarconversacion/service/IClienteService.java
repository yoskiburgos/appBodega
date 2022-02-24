package com.gloria.gloriabnsserviniciarconversacion.service;

import com.gloria.gloriabnsserviniciarconversacion.bean.ApiEncontrarBeneficiosIdSegmentacionResponse;
import com.gloria.gloriabnsserviniciarconversacion.bean.ApiEncontrarSegmentacionResponse;
import com.gloria.gloriabnsserviniciarconversacion.bean.ApiEncontrarTelefonoEnrolado;
import com.gloria.gloriabnsserviniciarconversacion.bean.ApiValidarTelefonoClienteResponse;

public interface IClienteService {
    public ApiValidarTelefonoClienteResponse validarTelefonoCliente(String telefono, Integer idCliente);
    public ApiEncontrarSegmentacionResponse encontrarIdSegmentacion(Integer idSegmentacion);
    public ApiEncontrarBeneficiosIdSegmentacionResponse encontrarBeneficiosIdSegmentacion(Integer idSegmentacion);
    public ApiEncontrarTelefonoEnrolado encontrarTelefonoEnrolado(String telefono);
}
