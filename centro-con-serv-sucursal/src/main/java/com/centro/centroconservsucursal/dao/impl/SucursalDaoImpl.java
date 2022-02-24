package com.centro.centroconservsucursal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.centro.centroconservsucursal.bean.ActualizarTelefonoSucursalIdRequest;
import com.centro.centroconservsucursal.bean.ActualizarTelefonoSucursalIdResponse;
import com.centro.centroconservsucursal.bean.DetalleClienteResponse;
import com.centro.centroconservsucursal.bean.EncontrarDetalleClienteSucursalIdResponse;
import com.centro.centroconservsucursal.bean.EncontrarSucursalIdTelefonoResponse;
import com.centro.centroconservsucursal.bean.EncontrarSucursalResponse;
import com.centro.centroconservsucursal.bean.Sucursal;
import com.centro.centroconservsucursal.bean.SucursalResponse;
import com.centro.centroconservsucursal.bean.ValidarClienteIdResponse;
import com.centro.centroconservsucursal.bean.ValidarTelefonoClienteResponse;
import com.centro.centroconservsucursal.constant.Constantes;
import com.centro.centroconservsucursal.dao.ISucursalDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Repository
public class SucursalDaoImpl implements ISucursalDao{

    @Autowired
    JdbcTemplate driver;

    @Override
    public ValidarTelefonoClienteResponse encontrarTelefonoCliente(String telefono, Integer idCliente) {
        ValidarTelefonoClienteResponse response = new ValidarTelefonoClienteResponse();
        long tiempoInicio = System.currentTimeMillis();
        Connection conexion = null;
		PreparedStatement preparedStatement = null;
        List<SucursalResponse> sucursales = new ArrayList<>();
        try {
            log.info("[INICIO] - METODO: [encontrarTelefonoCliente] ");
			conexion = driver.getDataSource().getConnection();
            StringBuffer funcion = new StringBuffer();
            funcion.append(Constantes.DATABASE_SELECT_ALL);
            funcion.append(Constantes.DATABASE_SCHEMA);
            funcion.append(Constantes.SEPARADOR_PUNTO);
            funcion.append(Constantes.FN_ENCONTRAR_CLIENTE_TELEFONO);
            log.info("[DATABASE] - FUNCTIONS ");
            log.info(funcion.toString());
            preparedStatement = conexion.prepareStatement(funcion.toString());
            preparedStatement.setString(1, telefono);
            preparedStatement.setInt(2, idCliente);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                SucursalResponse sucursal = new SucursalResponse();
                sucursal.setIdSucursal(rs.getInt("idsucursal"));
                sucursal.setIdCliente(rs.getInt("idcliente"));
                sucursal.setIdDetalleCliente(rs.getInt("iddetallecliente"));
                sucursal.setIdSegmentacion(rs.getInt("idsegmentacion"));
                sucursal.setCodigoCliente(rs.getString("codigocliente"));
                sucursal.setCalle(rs.getString("calle"));
                sucursal.setDistrito(rs.getString("distrito"));
                sucursal.setNombre(rs.getString("nombre"));
                sucursales.add(sucursal);
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
			log.info("[FIN] - METODO: [encontrarTelefonoCliente] ");
		}
        return response;
    }

    @Override
    public EncontrarSucursalResponse encontrarSucursalId(Integer idSucursal) {
        EncontrarSucursalResponse response = new EncontrarSucursalResponse();
        long tiempoInicio = System.currentTimeMillis();
        Connection conexion = null;
		PreparedStatement preparedStatement = null;
        List<Sucursal> sucursales = new ArrayList<>();
        try {
            log.info("[INICIO] - METODO: [encontrarSucursalId] ");
            conexion = driver.getDataSource().getConnection();
            StringBuffer funcion = new StringBuffer();
            funcion.append(Constantes.DATABASE_SELECT_ALL);
            funcion.append(Constantes.DATABASE_SCHEMA);
            funcion.append(Constantes.SEPARADOR_PUNTO);
            funcion.append(Constantes.FN_ENCONTRAR_SUCURSAL_ID);
            log.info("[DATABASE] - FUNCTIONS ");
            log.info(funcion.toString());
            preparedStatement = conexion.prepareStatement(funcion.toString());
            preparedStatement.setInt(1, idSucursal);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Sucursal sucursal = new Sucursal();
                sucursal.setIdSucursal(rs.getInt("idsucursal"));
                sucursal.setIdDetalleCliente(rs.getInt("iddetallecliente"));
                sucursal.setIdUbigeo(rs.getInt("idubigeo"));
                sucursal.setCodigoDireccion(rs.getInt("codigodireccion"));
                sucursal.setCalle(rs.getString("calle"));
                sucursal.setDistrito(rs.getString("distrito"));
                sucursal.setTelefono(rs.getString("telefono"));
                sucursal.setLongitud(rs.getString("longitud"));
                sucursal.setLatitud(rs.getString("latitud"));
                sucursal.setUsuarioCreacion(rs.getString("usuariocreacion"));
                sucursal.setUsuarioModifica(rs.getString("usuariomodifica"));
                sucursal.setFechaCreacion(rs.getDate("fechacreacion"));
                sucursal.setFechaModificacion(rs.getDate("fechamodificacion"));
                sucursales.add(sucursal);
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
			log.info("[FIN] - METODO: [encontrarSucursalId] ");
		}
        return response;
    }

    @Override
    public EncontrarDetalleClienteSucursalIdResponse encontrarDetalleClienteSucursalId(Integer idSucursal) {
        EncontrarDetalleClienteSucursalIdResponse response = new EncontrarDetalleClienteSucursalIdResponse();
        long tiempoInicio = System.currentTimeMillis();
        Connection conexion = null;
		PreparedStatement preparedStatement = null;
        List<DetalleClienteResponse> clientes = new ArrayList<>();
        try {
            log.info("[INICIO] - METODO: [encontrarDetalleClienteSucursalId] ");
			conexion = driver.getDataSource().getConnection();
            //st = conexion.createStatement();
            StringBuffer funcion = new StringBuffer();
            funcion.append(Constantes.DATABASE_SELECT_ALL);
            funcion.append(Constantes.DATABASE_SCHEMA);
            funcion.append(Constantes.SEPARADOR_PUNTO);
            funcion.append(Constantes.FN_ENCONTRAR_DETALLECLIENTE_SUCURSAL_ID);
            log.info("[DATABASE] - FUNCTIONS ");
            log.info(funcion.toString());
            preparedStatement = conexion.prepareStatement(funcion.toString());
            preparedStatement.setInt(1, idSucursal);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                DetalleClienteResponse cliente = new DetalleClienteResponse();
                cliente.setIdDetalleCliente(rs.getInt("iddetallecliente"));
                cliente.setCodigoCliente(rs.getString("codigocliente"));
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
			log.info("[FIN] - METODO: [encontrarDetalleClienteSucursalId] ");
		}
        return response;
    }

    @Override
    public EncontrarSucursalIdTelefonoResponse encontrarSucursalIdTelefono(Integer idSucursal, String telefono) {
        EncontrarSucursalIdTelefonoResponse response = new EncontrarSucursalIdTelefonoResponse();
        long tiempoInicio = System.currentTimeMillis();
        Connection conexion = null;
		PreparedStatement preparedStatement = null;
        List<Sucursal> sucursales = new ArrayList<>();
        try {
            log.info("[INICIO] - METODO: [encontrarSucursalIdTelefono] ");
            conexion = driver.getDataSource().getConnection();
            StringBuffer funcion = new StringBuffer();
            funcion.append(Constantes.DATABASE_SELECT_ALL);
            funcion.append(Constantes.DATABASE_SCHEMA);
            funcion.append(Constantes.SEPARADOR_PUNTO);
            funcion.append(Constantes.FN_ENCONTRAR_SUCURSAL_ID_TELEFONO);
            log.info("[DATABASE] - FUNCTIONS ");
            log.info(funcion.toString());
            preparedStatement = conexion.prepareStatement(funcion.toString());
            preparedStatement.setInt(1, idSucursal);
            preparedStatement.setString(2, telefono);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Sucursal sucursal = new Sucursal();
                sucursal.setIdSucursal(rs.getInt("idsucursal"));
                sucursal.setIdDetalleCliente(rs.getInt("iddetallecliente"));
                sucursal.setIdUbigeo(rs.getInt("idubigeo"));
                sucursal.setCodigoDireccion(rs.getInt("codigodireccion"));
                sucursal.setCalle(rs.getString("calle"));
                sucursal.setDistrito(rs.getString("distrito"));
                sucursal.setTelefono(rs.getString("telefono"));
                sucursal.setLongitud(rs.getString("longitud"));
                sucursal.setLatitud(rs.getString("latitud"));
                sucursal.setUsuarioCreacion(rs.getString("usuariocreacion"));
                sucursal.setUsuarioModifica(rs.getString("usuariomodifica"));
                sucursal.setFechaCreacion(rs.getDate("fechacreacion"));
                sucursal.setFechaModificacion(rs.getDate("fechamodificacion"));
                sucursales.add(sucursal);
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
			log.info("[FIN] - METODO: [encontrarSucursalIdTelefono] ");
		}
        return response;
    }

    @Override
    public ActualizarTelefonoSucursalIdResponse actualizarTelefonoSucursalId(ActualizarTelefonoSucursalIdRequest request ) {
        ActualizarTelefonoSucursalIdResponse response =  new ActualizarTelefonoSucursalIdResponse();
        long tiempoInicio = System.currentTimeMillis();
        Connection conexion = null;
		PreparedStatement preparedStatement = null;
        try {
            log.info("[INICIO] - METODO: [actualizarTelefonoSucursalId] ");
			conexion = driver.getDataSource().getConnection();
            StringBuffer funcion = new StringBuffer();
            funcion.append(Constantes.DATABASE_SELECT_ALL);
            funcion.append(Constantes.DATABASE_SCHEMA);
            funcion.append(Constantes.SEPARADOR_PUNTO);
            funcion.append(Constantes.FN_ACTUALIZAR_TELEFONO_SUCURSAL_ID);
            log.info("[DATABASE] - FUNCTIONS ");
            log.info(funcion.toString());
            preparedStatement = conexion.prepareStatement(funcion.toString());
            preparedStatement.setString(1, request.getTelefono());
            preparedStatement.setInt(2, request.getIdSucursal());
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
			log.info("[FIN] - METODO: [actualizarTelefonoSucursalId] ");
		}
        return response;
    }

    @Override
    public ValidarClienteIdResponse encontrarSucursalClienteId(Integer idCliente) {
        ValidarClienteIdResponse response = new ValidarClienteIdResponse();
        long tiempoInicio = System.currentTimeMillis();
        Connection conexion = null;
		PreparedStatement preparedStatement = null;
        List<SucursalResponse> sucursales = new ArrayList<>();
        try {
            log.info("[INICIO] - METODO: [encontrarTelefonoCliente] ");
			conexion = driver.getDataSource().getConnection();
            StringBuffer funcion = new StringBuffer();
            funcion.append(Constantes.DATABASE_SELECT_ALL);
            funcion.append(Constantes.DATABASE_SCHEMA);
            funcion.append(Constantes.SEPARADOR_PUNTO);
            funcion.append(Constantes.FN_ENCONTRAR_SUCURSAL_CLIENTE_ID);
            log.info("[DATABASE] - FUNCTIONS ");
            log.info(funcion.toString());
            preparedStatement = conexion.prepareStatement(funcion.toString());
            preparedStatement.setInt(1, idCliente);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                SucursalResponse sucursal = new SucursalResponse();
                sucursal.setIdSucursal(rs.getInt("idsucursal"));
                sucursal.setIdCliente(rs.getInt("idcliente"));
                sucursal.setIdDetalleCliente(rs.getInt("iddetallecliente"));
                sucursal.setIdSegmentacion(rs.getInt("idsegmentacion"));
                sucursal.setCodigoCliente(rs.getString("codigocliente"));
                sucursal.setCalle(rs.getString("calle"));
                sucursal.setDistrito(rs.getString("distrito"));
                sucursal.setNombre(rs.getString("nombre"));
                sucursales.add(sucursal);
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
			log.info("[FIN] - METODO: [encontrarTelefonoCliente] ");
		}
        return response;
    }
    
}
