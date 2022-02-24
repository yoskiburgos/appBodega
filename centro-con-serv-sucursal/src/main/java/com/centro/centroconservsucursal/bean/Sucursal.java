package com.centro.centroconservsucursal.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Sucursal implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer idSucursal;
    private Integer idDetalleCliente;
    private Integer idUbigeo;
    private Integer codigoDireccion;
    private String calle;
    private String distrito;
    private String telefono;
    private String longitud;
    private String latitud;
    private String usuarioCreacion;
    private String usuarioModifica;
    private Date fechaCreacion;
    private Date fechaModificacion;
}