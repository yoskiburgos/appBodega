package com.gloria.gloriabnsservenrolartelefono.bean;

import lombok.Data;

@Data
public class SucursalResponse {
    private Integer idSucursal;
    private Integer idDetalleCliente;
    private Integer idUbigeo;
    private Integer codigoDireccion;
    private String calle;
    private String distrito;
    private String telefono;
    private String longitud;
    private String latitud;
}
