package com.centro.centroconservenrolamiento.dao;

import com.centro.centroconservenrolamiento.bean.EncontrarTelefonoEnroladoResponse;
import com.centro.centroconservenrolamiento.bean.EnrolarTelefonoClienteResponse;

public interface IEnrolamientoDao {
    public EncontrarTelefonoEnroladoResponse encontrarTelefonoEnrolado(String telefono);
    public EnrolarTelefonoClienteResponse enrolarTelefonoCliente(String telefono,Integer idSucursal);
}
