package com.centro.centroconservcliente.service.impl;

import com.centro.centroconservcliente.bean.ValidarClienteResponse;
import com.centro.centroconservcliente.dao.IClienteDao;
import com.centro.centroconservcliente.service.IClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements IClienteService {
    
    @Autowired
    private IClienteDao dao;

    @Override
    public ValidarClienteResponse encontrarCliente(Integer tipoDocumento, String numeroDocumento, String codigoEmpresa) {
        return dao.encontrarCliente(tipoDocumento, numeroDocumento, codigoEmpresa);
    }

}
