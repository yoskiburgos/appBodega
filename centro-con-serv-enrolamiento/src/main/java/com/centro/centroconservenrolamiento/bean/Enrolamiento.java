package com.centro.centroconservenrolamiento.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Enrolamiento implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer idEmpresaCanalSucursal;
    private Integer idEmpresaCanal;
    private Integer idSucursal;
    private String estado;
    private Date usuarioCreacion;
    private Date usuarioModifica;
    private Date fechaCreacion;
    private Date fechaModificacion;
}
