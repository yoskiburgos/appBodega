package com.gloria.gloriabnsserviniciarconversacion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gloria.gloriabnsserviniciarconversacion.service.IClienteService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GloriaBnsServIniciarconversacionApplicationTests {

	@Autowired
	private IClienteService service;

	@Test
	void validarTelefonoCliente() {
		String telefefono = "11111111111";
		Integer idSucursal = 1;
		assertEquals(0, service.validarTelefonoCliente(telefefono, idSucursal).getStatus());
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

	@Test
	void encontrarTelefonoEnrolado() {
		String telefefono = "11111111111";
		assertEquals(0, service.encontrarTelefonoEnrolado(telefefono).getStatus());
	}

}