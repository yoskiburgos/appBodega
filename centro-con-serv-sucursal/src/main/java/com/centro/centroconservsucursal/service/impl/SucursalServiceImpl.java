package com.centro.centroconservsucursal.service.impl;

import com.centro.centroconservsucursal.bean.ActualizarTelefonoSucursalIdRequest;
import com.centro.centroconservsucursal.bean.ActualizarTelefonoSucursalIdResponse;
import com.centro.centroconservsucursal.bean.EncontrarDetalleClienteSucursalIdResponse;
import com.centro.centroconservsucursal.bean.EncontrarSucursalIdTelefonoResponse;
import com.centro.centroconservsucursal.bean.EncontrarSucursalResponse;
import com.centro.centroconservsucursal.bean.ValidarClienteIdResponse;
import com.centro.centroconservsucursal.bean.ValidarTelefonoClienteResponse;
import com.centro.centroconservsucursal.dao.ISucursalDao;
import com.centro.centroconservsucursal.service.ISucursalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SucursalServiceImpl implements ISucursalService {

    @Autowired
    private ISucursalDao dao;

    @Override
    public ValidarTelefonoClienteResponse encontrarTelefonoCliente(String telefono, Integer idCliente) {
        return dao.encontrarTelefonoCliente(telefono, idCliente);
    }

    @Override
    public EncontrarSucursalResponse encontrarSucursalId(Integer idSucursal) {
        return dao.encontrarSucursalId(idSucursal);
    }

    @Override
    public EncontrarDetalleClienteSucursalIdResponse encontrarDetalleClienteSucursalId(Integer idSucursal) {
        return dao.encontrarDetalleClienteSucursalId(idSucursal);
    }

    @Override
    public EncontrarSucursalIdTelefonoResponse encontrarSucursalIdTelefono(Integer idSucursal, String telefono) {
        return dao.encontrarSucursalIdTelefono(idSucursal, telefono);
    }

    @Override
    public ActualizarTelefonoSucursalIdResponse actualizarTelefonoSucursalId(ActualizarTelefonoSucursalIdRequest request) {
        return dao.actualizarTelefonoSucursalId(request);
    }

    @Override
    public ValidarClienteIdResponse encontrarSucursalClienteId(Integer idCliente) {
        return dao.encontrarSucursalClienteId(idCliente);
    }
    
}
