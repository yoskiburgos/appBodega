package com.gloria.gloriabnsserviniciarconversacion.bean;

import java.util.List;
import lombok.Data;

@Data
public class ApiEncontrarSegmentacionResponse {
    private Integer status;
    private String message;
    private List<SegmentacionResponse> data;
}
