package com.centro.centroconservsegmentacion.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Segmentacion implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idSegmentacion;
    private String codigo;
    private String nombre;
    private Date usuarioCreacion;
    private Date usuarioModifica;
    private Date fechaCreacion;
    private Date fechaModificacion;
}