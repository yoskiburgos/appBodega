package com.centro.centroconservcliente.dao;

import com.centro.centroconservcliente.bean.ValidarClienteResponse;

public interface IClienteDao {
    public ValidarClienteResponse encontrarCliente(Integer tipoDocumento, String numeroDocumento, String codigoEmpresa);
}
