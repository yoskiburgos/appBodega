package com.centro.centroconservenrolamiento.service.impl;

import com.centro.centroconservenrolamiento.bean.EncontrarTelefonoEnroladoResponse;
import com.centro.centroconservenrolamiento.bean.EnrolarTelefonoClienteRequest;
import com.centro.centroconservenrolamiento.bean.EnrolarTelefonoClienteResponse;
import com.centro.centroconservenrolamiento.dao.IEnrolamientoDao;
import com.centro.centroconservenrolamiento.service.IEnrolamientoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EnrolamientoServiceImpl implements IEnrolamientoService{

    @Autowired
    private IEnrolamientoDao dao;

    @Override
    public EncontrarTelefonoEnroladoResponse encontrarTelefonoEnrolado(String telefono) {
        return dao.encontrarTelefonoEnrolado(telefono);
    }

    @Override
    public EnrolarTelefonoClienteResponse enrolarTelefonoCliente(EnrolarTelefonoClienteRequest request) {
        EnrolarTelefonoClienteResponse response =new EnrolarTelefonoClienteResponse();
        try {
            for(int i = 0; i < request.getSucursales().size() ; i++){
                log.info("DATAS -----------------------------------------------");
                dao.enrolarTelefonoCliente(request.getTelefono(), request.getSucursales().get(i).getIdSucursal());
            }
            response.setStatus(0);
            response.setMessage("Sucursales enroladas correctamente");
        } catch (Exception e) {
            e.printStackTrace();
			response.setStatus(1);
            response.setMessage("Sucursales no fueron enroladas");
        }
        return response;
    }

}
