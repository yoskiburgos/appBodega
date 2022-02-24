package com.centro.centroconservcliente;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.centro.centroconservcliente.service.IClienteService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CentroConServClienteApplicationTests {

	@Autowired
	private IClienteService service;

	@Test
	void encontrarCliente() {
		Integer tipo = 1;
		String documento = "46473154";
		String empresa = "DE";
		assertEquals(0, service.encontrarCliente(tipo, documento, empresa).getStatus());
	}

}
