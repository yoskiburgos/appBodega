package com.centro.centroconservbeneficio.bean;

import java.io.Serializable;
import lombok.Data;

@Data
public class BeneficioResponse implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer idBeneficio;
    private Double descuento;
    private String informacion;
}