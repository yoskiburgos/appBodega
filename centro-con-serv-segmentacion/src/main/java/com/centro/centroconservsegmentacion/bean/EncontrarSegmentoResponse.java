package com.centro.centroconservsegmentacion.bean;

import java.util.List;
import lombok.Data;

@Data
public class EncontrarSegmentoResponse {
    private Integer status;
    private String message;
    private List<SegmentacionResponse> data;
}
