package com.gloria.gloriabnsservvalidarcliente.bean;
import java.io.Serializable;

import lombok.Data;

@Data
public class ClienteResponse implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer idCliente;
    private String nombre;
    private String codigoTipoDocumento;
    private String numeroDocumento;
    private Integer habilitar;
}
