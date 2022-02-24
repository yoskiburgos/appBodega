package com.centro.centroconservenrolamiento;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.centro.centroconservenrolamiento.bean.EnrolarTelefonoClienteRequest;
import com.centro.centroconservenrolamiento.bean.SucursalRequest;
import com.centro.centroconservenrolamiento.service.IEnrolamientoService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CentroConServEnrolamientoApplicationTests {

	@Autowired
	private IEnrolamientoService service;
	
	@Test
	void encontrarTelefonoEnrolado() {
		String telefono = "11111111111";
		//Test encontrar telefono enrolado cliente
		assertEquals(0, service.encontrarTelefonoEnrolado(telefono).getStatus());
	}

	@Test
	void enrolarTelefonoCliente() {
		String telefono = "11111111111";
		//Test enrolar telefono clienet
		EnrolarTelefonoClienteRequest request = new EnrolarTelefonoClienteRequest();
		request.setTelefono(telefono);
		List<SucursalRequest> sucursales = new ArrayList<SucursalRequest>();
		SucursalRequest sucursal = new SucursalRequest();
		sucursal.setIdSucursal(1);
		sucursales.add(sucursal);
		request.setSucursales(sucursales);
		assertEquals(0,service.enrolarTelefonoCliente(request).getStatus());
	}

}
