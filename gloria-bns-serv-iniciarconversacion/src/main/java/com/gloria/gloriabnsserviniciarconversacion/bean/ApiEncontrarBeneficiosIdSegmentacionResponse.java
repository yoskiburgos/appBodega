package com.gloria.gloriabnsserviniciarconversacion.bean;

import java.util.List;

import lombok.Data;

@Data
public class ApiEncontrarBeneficiosIdSegmentacionResponse {
    private Integer status;
    private String message;
    private List<BeneficioResponse> data;
}
