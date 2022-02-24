package com.centro.centroconservbeneficio.service.impl;

import com.centro.centroconservbeneficio.bean.EncontrarBeneficiosIdSegmentacionResponse;
import com.centro.centroconservbeneficio.dao.IBeneficioDao;
import com.centro.centroconservbeneficio.service.IBeneficioService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeneficioServiceImpl implements IBeneficioService {

    @Autowired
    private IBeneficioDao dao;

    @Override
    public EncontrarBeneficiosIdSegmentacionResponse encontrarSegmentoId(Integer idSegmentacion) {
        return dao.encontrarBeneficiosIdSegmentacion(idSegmentacion);
    }
    
}
