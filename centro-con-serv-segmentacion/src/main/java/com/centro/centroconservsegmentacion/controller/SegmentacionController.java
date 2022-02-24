package com.centro.centroconservsegmentacion.controller;

import com.centro.centroconservsegmentacion.bean.EncontrarSegmentoResponse;
import com.centro.centroconservsegmentacion.service.ISegmentacionService;

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
public class SegmentacionController {
    @Autowired
	private ISegmentacionService service;

    @GetMapping("/alive")
    public ResponseEntity<String> alive() {
        String alive = "it is alive";
        return ResponseEntity.ok(alive);
    }
    
    @GetMapping("/encontrar")
	public ResponseEntity<EncontrarSegmentoResponse> encontrarSegmentacionId(@RequestParam Integer idSegmentacion ) {
        return ResponseEntity.ok(service.encontrarSegmentacionId(idSegmentacion));
	}
}
