package com.gloria.gloriabnsservvalidarcliente.bean;

import lombok.Data;

@Data
public class ApiSucursalResponse {
    private Integer idSucursal;
    private String codigoCliente;
    private String calle;
    private String distrito;
    private Integer idSegmentacion;
}
