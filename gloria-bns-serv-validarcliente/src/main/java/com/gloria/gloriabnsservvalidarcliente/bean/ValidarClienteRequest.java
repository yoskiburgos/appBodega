package com.gloria.gloriabnsservvalidarcliente.bean;

import lombok.Data;

@Data
public class ValidarClienteRequest {
    private Integer tipo;
    private String documento;
    private String telefono;
}
