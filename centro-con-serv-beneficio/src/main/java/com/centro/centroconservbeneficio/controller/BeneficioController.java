package com.centro.centroconservbeneficio.controller;
import com.centro.centroconservbeneficio.bean.EncontrarBeneficiosIdSegmentacionResponse;
import com.centro.centroconservbeneficio.service.IBeneficioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST  })
public class BeneficioController {
    @Autowired
	private IBeneficioService service;

    @GetMapping("/alive")
    public ResponseEntity<String> alive() {
        String alive = "it is alive";
        return ResponseEntity.ok(alive);
    }
    
    @GetMapping("/beneficios-segmentacion")
	public ResponseEntity<EncontrarBeneficiosIdSegmentacionResponse> encontrarSegmentacionId(@RequestParam Integer idSegmentacion ) {
        return ResponseEntity.ok(service.encontrarSegmentoId(idSegmentacion));
	}
}
