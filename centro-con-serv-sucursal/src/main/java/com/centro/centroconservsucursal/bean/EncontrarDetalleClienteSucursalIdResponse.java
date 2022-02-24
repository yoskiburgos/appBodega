package com.centro.centroconservsucursal.bean;

import java.util.List;
import lombok.Data;

@Data
public class EncontrarDetalleClienteSucursalIdResponse {
    private Integer status;
    private String message;
    private List<DetalleClienteResponse> data;
}
