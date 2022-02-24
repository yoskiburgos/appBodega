package com.gloria.gloriabnsserviniciarconversacion.bean;

import lombok.Data;

@Data
public class TelefonoEnroladoResponse {
    private Integer  idEmpresaCanalSucursal;
    private String  telefono;
    private Integer  idSucursal;
    private Integer  idDetalleCliente;
    private Integer  idCliente;
}
