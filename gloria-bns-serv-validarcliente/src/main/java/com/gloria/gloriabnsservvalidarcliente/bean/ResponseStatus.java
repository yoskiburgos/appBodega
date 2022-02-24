package com.gloria.gloriabnsservvalidarcliente.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseStatus {
    private Integer status;
    private String codigoRespuesta;
    private String descripcionRespuesta;
    private String idTransaccion;
    private String fechaTermino;
}
