package com.centro.centroconservenrolamiento.bean;

import lombok.Data;

@Data
public class EnrolamientoResponse {
    private Integer idEmpresaCanalSucursal;
    private String telefono;
    private Integer idSucursal;
    private Integer idDetalleCliente;
    private Integer idCliente;
}
