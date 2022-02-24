package com.gloria.gloriabnsservenrolartelefono.bean;

import java.util.List;

import lombok.Data;

@Data
public class ApiEncontrarSurucarlTelefonoResponse {
    private Integer status;
    private String message;
    private List<SucursalResponse> data;
}
