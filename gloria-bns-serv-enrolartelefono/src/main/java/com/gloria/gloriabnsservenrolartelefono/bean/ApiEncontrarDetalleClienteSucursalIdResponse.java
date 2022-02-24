package com.gloria.gloriabnsservenrolartelefono.bean;

import java.util.List;

import lombok.Data;

@Data
public class ApiEncontrarDetalleClienteSucursalIdResponse {
    private Integer status;
    private String message;
    private List<DetalleClienteResponse> data;
}
