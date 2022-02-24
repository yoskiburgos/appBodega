package com.centro.centroconservenrolamiento.bean;

import java.util.List;

import lombok.Data;

@Data
public class EncontrarTelefonoEnroladoResponse {
    private Integer status;
    private String message;
    private List<EnrolamientoResponse> data;
}
