package com.centro.centroconservsegmentacion.service.impl;

import com.centro.centroconservsegmentacion.bean.EncontrarSegmentoResponse;
import com.centro.centroconservsegmentacion.dao.ISegmentacionDao;
import com.centro.centroconservsegmentacion.service.ISegmentacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SegmentacionServiceImpl implements ISegmentacionService{

    @Autowired
    private ISegmentacionDao dao;

    @Override
    public EncontrarSegmentoResponse encontrarSegmentacionId(Integer idSegmentacion) {
        return dao.encontrarSegmentoId(idSegmentacion);
    }
    
}
