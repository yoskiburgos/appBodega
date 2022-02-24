package com.centro.centroconservenrolamiento.service;

import com.centro.centroconservenrolamiento.bean.EncontrarTelefonoEnroladoResponse;
import com.centro.centroconservenrolamiento.bean.EnrolarTelefonoClienteRequest;
import com.centro.centroconservenrolamiento.bean.EnrolarTelefonoClienteResponse;

public interface IEnrolamientoService {
    public EncontrarTelefonoEnroladoResponse encontrarTelefonoEnrolado(String telefono);
    public EnrolarTelefonoClienteResponse enrolarTelefonoCliente(EnrolarTelefonoClienteRequest request);
}
