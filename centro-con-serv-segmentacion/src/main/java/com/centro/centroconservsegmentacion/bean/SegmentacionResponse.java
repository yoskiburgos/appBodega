package com.centro.centroconservsegmentacion.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class SegmentacionResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idSegmentacion;
    private String codigo;
    private String nombre;
}