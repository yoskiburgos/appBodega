package com.centro.centroconservcliente.bean;

import lombok.Data;

@Data
public class ListarResponse {
    private ResponseStatus responseStatus;
    private ListarResponseData listarResponseData;
}
