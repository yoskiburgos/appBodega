package com.gloria.gloriabnsserviniciarconversacion.bean;

import java.util.List;

import lombok.Data;

@Data
public class ApiEncontrarTelefonoEnrolado {
    private Integer status;
    private String message;
    private List<TelefonoEnroladoResponse> data;
}
