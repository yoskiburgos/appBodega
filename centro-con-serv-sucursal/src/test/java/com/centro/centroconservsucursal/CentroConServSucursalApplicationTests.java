package com.centro.centroconservsucursal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.centro.centroconservsucursal.service.ISucursalService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CentroConServSucursalApplicationTests {

	@Autowired
	private ISucursalService service;

	@Test
	void encontrarSucursalId() {
		Integer idSucursal = 1;
		assertEquals(0, service.encontrarSucursalId(idSucursal).getStatus());
	}

	@Test
	void encontrarTelefonoCliente() {
		String telefono = "11111111111";
		Integer idSucursal = 1;
		assertEquals(0, service.encontrarTelefonoCliente(telefono, idSucursal).getStatus());
	}

	@Test
	void encontrarDetalleClienteSucursalId() {
		Integer idSucursal = 1;
		assertEquals(0, service.encontrarDetalleClienteSucursalId(idSucursal).getStatus());
	}

}
