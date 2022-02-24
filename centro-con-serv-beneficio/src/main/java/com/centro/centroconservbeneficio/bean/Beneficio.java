package com.centro.centroconservbeneficio.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Beneficio implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer idBeneficio;
    private String nombre;
    private Double descuento;
    private String informacion;
    private String estado;
    private Date usuarioCreacion;
    private Date usuarioModifica;
    private Date fechaCreacion;
    private Date fechaModificacion;
}