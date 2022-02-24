package com.centro.centroconservsucursal.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class SucursalResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idSucursal;
    private Integer idCliente;
    private String nombre; 
    private Integer idDetalleCliente;
    private Integer idSegmentacion;
    private String codigoCliente;
    private String calle;
    private String distrito;
}
