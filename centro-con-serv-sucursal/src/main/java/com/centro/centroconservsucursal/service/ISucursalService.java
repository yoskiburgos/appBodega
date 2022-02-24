package com.centro.centroconservsucursal.service;

import com.centro.centroconservsucursal.bean.ActualizarTelefonoSucursalIdRequest;
import com.centro.centroconservsucursal.bean.ActualizarTelefonoSucursalIdResponse;
import com.centro.centroconservsucursal.bean.EncontrarDetalleClienteSucursalIdResponse;
import com.centro.centroconservsucursal.bean.EncontrarSucursalIdTelefonoResponse;
import com.centro.centroconservsucursal.bean.EncontrarSucursalResponse;
import com.centro.centroconservsucursal.bean.ValidarClienteIdResponse;
import com.centro.centroconservsucursal.bean.ValidarTelefonoClienteResponse;

public interface ISucursalService {
    public ValidarTelefonoClienteResponse encontrarTelefonoCliente(String telefono, Integer idCliente);
    public EncontrarSucursalResponse encontrarSucursalId(Integer idSucursal);
    public EncontrarDetalleClienteSucursalIdResponse encontrarDetalleClienteSucursalId(Integer idSucursal);
    public EncontrarSucursalIdTelefonoResponse encontrarSucursalIdTelefono(Integer idSucursal, String telefono);
    public ActualizarTelefonoSucursalIdResponse actualizarTelefonoSucursalId(ActualizarTelefonoSucursalIdRequest request);
    public ValidarClienteIdResponse encontrarSucursalClienteId(Integer idCliente);
}
