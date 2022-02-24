package com.centro.centroconservbeneficio.dao.impl;

import com.centro.centroconservbeneficio.bean.BeneficioResponse;
import com.centro.centroconservbeneficio.bean.EncontrarBeneficiosIdSegmentacionResponse;
import com.centro.centroconservbeneficio.constant.Constantes;
import com.centro.centroconservbeneficio.dao.IBeneficioDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Repository
public class BeneficioDaoImpl implements IBeneficioDao{
    @Autowired
    JdbcTemplate driver;

    @Override
    public EncontrarBeneficiosIdSegmentacionResponse encontrarBeneficiosIdSegmentacion(Integer idSegmentacion) {
        EncontrarBeneficiosIdSegmentacionResponse response =  new EncontrarBeneficiosIdSegmentacionResponse();
        long tiempoInicio = System.currentTimeMillis();
        Connection conexion = null;
		PreparedStatement preparedStatement = null;
        try {
            List<BeneficioResponse> beneficios = new ArrayList<>();
            log.info("[INICIO] - METODO: [encontrarBeneficiosIdSegmentacion] ");
			conexion = driver.getDataSource().getConnection();
            StringBuffer funcion = new StringBuffer();
            funcion.append(Constantes.DATABASE_SELECT_ALL);
            funcion.append(Constantes.DATABASE_SCHEMA);
            funcion.append(Constantes.SEPARADOR_PUNTO);
            funcion.append(Constantes.FN_ENCONTRAR_BENEFICIOS_IDSEGMENTACION);
            log.info("[DATABASE] - FUNCTIONS ");
            log.info(funcion.toString());
            preparedStatement = conexion.prepareStatement(funcion.toString());
            preparedStatement.setInt(1, idSegmentacion);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                BeneficioResponse beneficio  = new BeneficioResponse();
                beneficio.setIdBeneficio(rs.getInt("idbeneficio"));
                beneficio.setDescuento(rs.getDouble("descuento"));
                beneficio.setInformacion(rs.getString("informacion"));
                beneficios.add(beneficio);
            }
            response.setData(beneficios);
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
			log.info("[FIN] - METODO: [encontrarBeneficiosIdSegmentacion] ");
		}
        return response;
    }
    
}
