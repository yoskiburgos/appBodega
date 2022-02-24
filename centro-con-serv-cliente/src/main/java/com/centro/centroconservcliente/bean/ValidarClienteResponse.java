package com.centro.centroconservcliente.bean;

import java.util.List;

import lombok.Data;

@Data
public class ValidarClienteResponse {
    private Integer status;
    private String message;
    private List<Cliente> data;
}
