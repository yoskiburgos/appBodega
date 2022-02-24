package com.centro.centroconservsegmentacion.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.centro.centroconservsegmentacion.bean.EncontrarSegmentoResponse;
import com.centro.centroconservsegmentacion.bean.SegmentacionResponse;
import com.centro.centroconservsegmentacion.constant.Constantes;
import com.centro.centroconservsegmentacion.dao.ISegmentacionDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Repository
public class SegmentacionDaoImpl implements ISegmentacionDao{

    @Autowired
    JdbcTemplate driver;

    @Override
    public EncontrarSegmentoResponse encontrarSegmentoId(Integer idSegmentacion) {
        EncontrarSegmentoResponse response =  new EncontrarSegmentoResponse();
        long tiempoInicio = System.currentTimeMillis();
        Connection conexion = null;
		PreparedStatement preparedStatement = null;
        List<SegmentacionResponse> segmentaciones = new ArrayList<>();
        try {
            log.info("[INICIO] - METODO: [encontrarSegmentoId] ");
			conexion = driver.getDataSource().getConnection();
            StringBuffer funcion = new StringBuffer();
            funcion.append(Constantes.DATABASE_SELECT_ALL);
            funcion.append(Constantes.DATABASE_SCHEMA);
            funcion.append(Constantes.SEPARADOR_PUNTO);
            funcion.append(Constantes.FN_ENCONTRAR_SEGMENTO_ID);
            log.info("[DATABASE] - FUNCTIONS ");
            log.info(funcion.toString());
            preparedStatement = conexion.prepareStatement(funcion.toString());
            preparedStatement.setInt(1, idSegmentacion);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                SegmentacionResponse segmentacion  = new SegmentacionResponse();
                segmentacion.setIdSegmentacion(rs.getInt("idsegmentacion"));
                segmentacion.setCodigo(rs.getString("codigo"));
                segmentacion.setNombre(rs.getString("nombre"));
                segmentaciones.add(segmentacion);
            }
            response.setData(segmentaciones);
            response.setStatus(0);
            response.setMessage("OK");
        } catch (Exception e) {
            response.setStatus(1);
            response.setMessage(e.getMessage());
			e.printStackTrace();
			log.error("ERROR: ", e);
        }finally {
			if(preparedStatement != null ) try {preparedStatement.close();} catch (Exception e) {}
			if(conexion != null ) try {conexion.close();} catch (Exception e) {}
			log.info("Tiempo Transacurrido (ms): [" + (System.currentTimeMillis() - tiempoInicio) + "]");
			log.info("[FIN] - METODO: [encontrarSegmentoId] ");
		}
        return response;
    }
    
}
