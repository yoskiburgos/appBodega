package com.centro.centroconservbeneficio.bean;

import java.util.List;
import lombok.Data;

@Data
public class EncontrarBeneficiosIdSegmentacionResponse {
    private Integer status;
    private String message;
    private List<BeneficioResponse> data;
}
