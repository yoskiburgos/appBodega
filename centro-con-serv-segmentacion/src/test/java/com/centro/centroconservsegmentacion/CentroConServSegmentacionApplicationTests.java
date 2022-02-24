package com.centro.centroconservsegmentacion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.centro.centroconservsegmentacion.service.ISegmentacionService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CentroConServSegmentacionApplicationTests {

	@Autowired
	private ISegmentacionService service;
	
	@Test
	void encontrarSegmentacionId() {
		Integer idSegmentacion = 1;
		assertEquals(0, service.encontrarSegmentacionId(idSegmentacion).getStatus());
	}

}
