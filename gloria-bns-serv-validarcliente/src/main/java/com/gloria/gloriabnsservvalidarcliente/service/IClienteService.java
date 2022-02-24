package com.gloria.gloriabnsservvalidarcliente.service;

import com.gloria.gloriabnsservvalidarcliente.bean.ApiValidarClienteResponse;
import com.gloria.gloriabnsservvalidarcliente.bean.ApiValidarTelefonoClienteResponse;
import com.gloria.gloriabnsservvalidarcliente.bean.ApiEncontrarBeneficiosIdSegmentacionResponse;
import com.gloria.gloriabnsservvalidarcliente.bean.ApiEncontrarSegmentacionResponse;
import com.gloria.gloriabnsservvalidarcliente.bean.ApiEncontrarSucursalClienteIdResponse;

public interface IClienteService {
    public ApiValidarClienteResponse validarCliente(String tipoDocumento, String numeroDocumento, String codigoEmpresa);
    public ApiValidarTelefonoClienteResponse validarTelefonoCliente(String telefono, Integer idCliente);
    public ApiEncontrarSegmentacionResponse encontrarIdSegmentacion(Integer idSegmentacion);
    public ApiEncontrarBeneficiosIdSegmentacionResponse encontrarBeneficiosIdSegmentacion(Integer idSegmentacion);
    public ApiEncontrarSucursalClienteIdResponse encontrarSucursalClienteId(Integer idCliente);
}
