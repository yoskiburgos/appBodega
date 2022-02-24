package com.centro.centroconservenrolamiento.controller;


import com.centro.centroconservenrolamiento.bean.EncontrarTelefonoEnroladoResponse;
import com.centro.centroconservenrolamiento.bean.EnrolarTelefonoClienteRequest;
import com.centro.centroconservenrolamiento.bean.EnrolarTelefonoClienteResponse;
import com.centro.centroconservenrolamiento.service.IEnrolamientoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST  })
public class EnrolamientoController {
    @Autowired
	private IEnrolamientoService service;
    
    @GetMapping("/encontrar-telefono-enrolado")
	public ResponseEntity<EncontrarTelefonoEnroladoResponse> encontrarTelefonoEnrolado(@RequestParam String telefono ) {
		return ResponseEntity.ok(service.encontrarTelefonoEnrolado(telefono));
	}

	@PostMapping("/enrolar-telefono-cliente")
	public ResponseEntity<EnrolarTelefonoClienteResponse> enrolarTelefonoCliente(@RequestBody EnrolarTelefonoClienteRequest request ) {
		return ResponseEntity.ok(service.enrolarTelefonoCliente(request));
	}
}
