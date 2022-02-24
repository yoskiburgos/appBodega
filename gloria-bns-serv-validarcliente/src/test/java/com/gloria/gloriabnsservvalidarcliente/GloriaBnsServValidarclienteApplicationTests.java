package com.gloria.gloriabnsservvalidarcliente;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gloria.gloriabnsservvalidarcliente.service.IClienteService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GloriaBnsServValidarclienteApplicationTests {

	@Autowired
	private IClienteService service;

	@Test
	void validarCliente() {
		String tipoDocumento = "1";
		String numeroDocumento= "11111111";
		String codigoEmpresa =  "DE";
		assertEquals(0, service.validarCliente(tipoDocumento, numeroDocumento, codigoEmpresa).getStatus());
	}

	@Test
	void validarTelefonoCliente() {
		String telefono= "11111111111";
		Integer idCliente = 1;
		assertEquals(0, service.validarTelefonoCliente(telefono, idCliente).getStatus());
	}

	@Test
	void encontrarIdSegmentacion() {
		Integer idSegmentacion = 1;
		assertEquals(0, service.encontrarIdSegmentacion(idSegmentacion).getStatus());
	}

	@Test
	void encontrarBeneficiosIdSegmentacion() {
		Integer idSegmentacion = 1;
		assertEquals(0, service.encontrarBeneficiosIdSegmentacion(idSegmentacion).getStatus());
	}

}


