package com.gloria.gloriabnsservvalidarcliente.bean;

import java.util.List;

import lombok.Data;

@Data
public class ResponseData {
    private Integer idCliente;
    private String nombre;
    private List<SucursalReponse> sucursales;
}
