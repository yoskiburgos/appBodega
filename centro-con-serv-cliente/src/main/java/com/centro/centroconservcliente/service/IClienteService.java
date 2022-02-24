package com.centro.centroconservcliente.service;

import com.centro.centroconservcliente.bean.ValidarClienteResponse;

public interface IClienteService {
    public ValidarClienteResponse encontrarCliente(Integer tipoDocumento, String numeroDocumento, String codigoEmpresa);
}
