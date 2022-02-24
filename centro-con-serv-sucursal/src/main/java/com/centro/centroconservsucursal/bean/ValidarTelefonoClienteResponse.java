package com.centro.centroconservsucursal.bean;

import java.util.List;

import lombok.Data;

@Data
public class ValidarTelefonoClienteResponse {
    private Integer status;
    private String message;
    private List<SucursalResponse> data;
}
