package com.centro.centroconservenrolamiento.bean;

import java.util.List;

import lombok.Data;


@Data
public class EnrolarTelefonoClienteRequest {
    private String telefono;
    private List<SucursalRequest> sucursales;
}
