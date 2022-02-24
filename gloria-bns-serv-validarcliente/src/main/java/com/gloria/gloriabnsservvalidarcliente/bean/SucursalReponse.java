package com.gloria.gloriabnsservvalidarcliente.bean;

import java.util.List;

import lombok.Data;

@Data
public class SucursalReponse {
    private Integer idSucursal;
    private String codigoCliente;
    private String calle;
    private String distrito;
    private List<SegmentacionResponse> segmentaciones;
}
