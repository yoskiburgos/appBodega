package com.centro.centroconservcliente.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.centro.centroconservcliente.bean.Cliente;
import com.centro.centroconservcliente.bean.ValidarClienteResponse;
import com.centro.centroconservcliente.constant.Constantes;
import com.centro.centroconservcliente.dao.IClienteDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Repository
public class ClienteDaoImpl implements IClienteDao{

    @Autowired
    JdbcTemplate driver;

    @Override
    public ValidarClienteResponse encontrarCliente(Integer tipoDocumento, String numeroDocumento, String codigoEmpresa) {
        ValidarClienteResponse response =  new ValidarClienteResponse();
        long tiempoInicio = System.currentTimeMillis();
        Connection conexion = null;
		PreparedStatement preparedStatement = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            log.info("[INICIO] - METODO: [encontrarCliente] ");
			conexion = driver.getDataSource().getConnection();
            StringBuffer funcion = new StringBuffer();
            funcion.append(Constantes.DATABASE_SELECT_ALL);
            funcion.append(Constantes.DATABASE_SCHEMA);
            funcion.append(Constantes.SEPARADOR_PUNTO);
            funcion.append(Constantes.FN_ENCONTRAR_CLIENTE);
            log.info("[DATABASE] - FUNCTIONS ");
            log.info(funcion.toString());
            preparedStatement = conexion.prepareStatement(funcion.toString());
            preparedStatement.setString(1, Integer.toString(tipoDocumento));
            preparedStatement.setString(2, numeroDocumento);
            preparedStatement.setString(3, codigoEmpresa);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idcliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setCodigoTipoDocumento(rs.getString("codigotipodocumento"));
                cliente.setNumeroDocumento(rs.getString("numerodocumento"));
                cliente.setHabilitar(rs.getInt("habilitar"));
                clientes.add(cliente);
            }
            response.setData(clientes);
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
    
}
