package com.gloria.gloriabnsserviniciarconversacion.bean;

import java.util.List;

import lombok.Data;

@Data
public class SegmentacionResponse {
    private Integer idSegmentacion;
    private String codigo;
    private String nombre;
    private List<BeneficioResponse> beneficios;
}
