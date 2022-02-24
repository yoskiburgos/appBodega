package com.centro.centroconservbeneficio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.centro.centroconservbeneficio.service.IBeneficioService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CentroConServBeneficioApplicationTests {

	@Autowired
	private IBeneficioService service;

	@Test
	void encontrarSegmentoId() {
		Integer idSegmentacion = 1;
		assertEquals(0, service.encontrarSegmentoId(idSegmentacion).getStatus());
	}

}
