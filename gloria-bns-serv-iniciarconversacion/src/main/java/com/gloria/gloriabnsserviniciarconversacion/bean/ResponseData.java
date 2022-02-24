package com.gloria.gloriabnsserviniciarconversacion.bean;

import java.util.List;

import lombok.Data;

@Data
public class ResponseData {
    private Integer idCliente;
    private List<SucursalReponse> sucursales;
}
