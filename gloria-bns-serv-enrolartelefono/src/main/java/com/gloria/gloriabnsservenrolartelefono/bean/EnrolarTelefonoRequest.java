package com.gloria.gloriabnsservenrolartelefono.bean;

import java.util.List;
import lombok.Data;

@Data
public class EnrolarTelefonoRequest {
    private String telefono;
    private List<SucursalRequest> sucursales;
}
