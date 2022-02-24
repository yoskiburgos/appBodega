package com.gloria.gloriabnsserviniciarconversacion.bean;

import lombok.Data;

@Data
public class ApiSucursalResponse {
    private Integer idSucursal;
    private String codigoCliente;
    private String nombre;
    private String calle;
    private String distrito;
    private Integer idSegmentacion;
}
