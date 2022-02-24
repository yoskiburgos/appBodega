package com.centro.centroconservenrolamiento.dao.impl;

import com.centro.centroconservenrolamiento.bean.EncontrarTelefonoEnroladoResponse;
import com.centro.centroconservenrolamiento.bean.EnrolamientoResponse;
import com.centro.centroconservenrolamiento.bean.EnrolarTelefonoClienteResponse;
import com.centro.centroconservenrolamiento.constant.Constantes;
import com.centro.centroconservenrolamiento.dao.IEnrolamientoDao;
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
public class EnrolamientoDaoImpl implements IEnrolamientoDao{

    @Autowired
    JdbcTemplate driver;

    @Override
    public EncontrarTelefonoEnroladoResponse encontrarTelefonoEnrolado(String telefono) {
        EncontrarTelefonoEnroladoResponse response =  new EncontrarTelefonoEnroladoResponse();
        long tiempoInicio = System.currentTimeMillis();
        Connection conexion = null;
		PreparedStatement preparedStatement = null;
        List<EnrolamientoResponse> sucursales = new ArrayList<>();
        try {
            log.info("[INICIO] - METODO: [encontrarCliente] ");
			conexion = driver.getDataSource().getConnection();
            StringBuffer funcion = new StringBuffer();
            funcion.append(Constantes.DATABASE_SELECT_ALL);
            funcion.append(Constantes.DATABASE_SCHEMA);
            funcion.append(Constantes.SEPARADOR_PUNTO);
            funcion.append(Constantes.FN_ENCONTRAR_TELEFONO_ENROLADO);
            log.info("[DATABASE] - FUNCTIONS ");
            log.info(funcion.toString());
            preparedStatement = conexion.prepareStatement(funcion.toString());
            preparedStatement.setString(1, telefono);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                EnrolamientoResponse EnrolamientoResponse = new EnrolamientoResponse();
                EnrolamientoResponse.setIdEmpresaCanalSucursal(rs.getInt("idempresacanalsucursal"));;
                EnrolamientoResponse.setTelefono(rs.getString("telefono"));
                EnrolamientoResponse.setIdSucursal(rs.getInt("idsucursal"));
                EnrolamientoResponse.setIdDetalleCliente(rs.getInt("iddetallecliente"));
                EnrolamientoResponse.setIdCliente(rs.getInt("idcliente"));
                sucursales.add(EnrolamientoResponse);
            }
            response.setData(sucursales);
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
			log.info("[FIN] - METODO: [listar] ");
		}
        return response;
    }

    @Override
    public EnrolarTelefonoClienteResponse enrolarTelefonoCliente(String telefono, Integer idSucursal) {
        EnrolarTelefonoClienteResponse response =  new EnrolarTelefonoClienteResponse();
        long tiempoInicio = System.currentTimeMillis();
        Connection conexion = null;
		PreparedStatement preparedStatement = null;
        try {
            log.info("[INICIO] - METODO: [enrolarTelefonoCliente] ");
			conexion = driver.getDataSource().getConnection();
            StringBuffer funcion = new StringBuffer();
            funcion.append(Constantes.DATABASE_SELECT_ALL);
            funcion.append(Constantes.DATABASE_SCHEMA);
            funcion.append(Constantes.SEPARADOR_PUNTO);
            funcion.append(Constantes.FN_ENROLAR_TELEFONO_CLIENTE);
            log.info("[DATABASE] - FUNCTIONS ");
            log.info(funcion.toString());
            preparedStatement = conexion.prepareStatement(funcion.toString());
            preparedStatement.setString(1, telefono);
            preparedStatement.setInt(2, idSucursal);
            ResultSet rs = preparedStatement.executeQuery();
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
			log.info("[FIN] - METODO: [enrolarTelefonoCliente] ");
		}
        return response;
    }
    
}
