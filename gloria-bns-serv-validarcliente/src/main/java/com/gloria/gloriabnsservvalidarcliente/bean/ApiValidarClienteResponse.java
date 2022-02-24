package com.gloria.gloriabnsservvalidarcliente.bean;

import java.util.List;

import lombok.Data;

@Data
public class ApiValidarClienteResponse {
    private Integer status;
    private String message;
    private List<ClienteResponse> data;
}
