package com.centro.centroconservcliente.bean;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idCliente;
    private String nombre;
    private String codigoTipoDocumento;
    private String numeroDocumento;
    private Integer habilitar;
    private String usuarioCreacion;
    private String usuarioModifica;
    private Date fechaCreacion;
    private Date fechaModificacion;
}