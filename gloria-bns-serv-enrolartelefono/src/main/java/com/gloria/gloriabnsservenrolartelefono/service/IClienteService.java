package com.gloria.gloriabnsservenrolartelefono.service;

import com.gloria.gloriabnsservenrolartelefono.bean.ApiEncontrarDetalleClienteSucursalIdResponse;
import com.gloria.gloriabnsservenrolartelefono.bean.ApiEncontrarSurucarlResponse;
import com.gloria.gloriabnsservenrolartelefono.bean.ApiEncontrarSurucarlTelefonoResponse;
import com.gloria.gloriabnsservenrolartelefono.bean.ApiEnrolarTelefonoClienteResponse;
import com.gloria.gloriabnsservenrolartelefono.bean.EnrolarTelefonoRequest;

public interface IClienteService {
    public ApiEncontrarSurucarlResponse encontrarSucursalId(Integer idSucursal);
    public ApiEncontrarDetalleClienteSucursalIdResponse encontrarDetalleClienteSucursalId(Integer idSucursal);
    public ApiEnrolarTelefonoClienteResponse enrolarTelefonoCliente(EnrolarTelefonoRequest request);
    public ApiEncontrarSurucarlTelefonoResponse encontrarSucursalIdTelefono(Integer idSucursal, String telefono);
}
