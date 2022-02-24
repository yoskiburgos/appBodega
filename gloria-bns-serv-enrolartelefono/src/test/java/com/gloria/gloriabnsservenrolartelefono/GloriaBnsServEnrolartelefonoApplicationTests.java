package com.gloria.gloriabnsservenrolartelefono;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.gloria.gloriabnsservenrolartelefono.bean.EnrolarTelefonoRequest;
import com.gloria.gloriabnsservenrolartelefono.bean.SucursalRequest;
import com.gloria.gloriabnsservenrolartelefono.service.IClienteService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GloriaBnsServEnrolartelefonoApplicationTests {

	@Autowired
	private IClienteService service;

	@Test
	void encontrarSucursalId() {
		Integer idSucursal = 1;
		assertEquals(0, service.encontrarSucursalId(idSucursal).getStatus());
	}

	@Test
	void encontrarSucursalIdTelefono() {
		Integer idSucursal = 1;
		String telefono = "11111111111";
		assertEquals(0, service.encontrarSucursalIdTelefono(idSucursal, telefono).getStatus());
	}

	@Test
	void encontrarDetalleClienteSucursalId() {
		Integer idSucursal = 1;
		assertEquals(0, service.encontrarDetalleClienteSucursalId(idSucursal).getStatus());
	}

	@Test
	void enrolarTelefonoCliente() {
		String telefono = "11111111111";
		EnrolarTelefonoRequest request = new EnrolarTelefonoRequest();
		request.setTelefono(telefono);
		List<SucursalRequest> sucursales = new ArrayList<SucursalRequest>();
		SucursalRequest sucursal = new SucursalRequest();
		sucursal.setIdSucursal(1);
		sucursales.add(sucursal);
		request.setSucursales(sucursales);
		assertEquals(0, service.enrolarTelefonoCliente(request).getStatus());
	}
}
