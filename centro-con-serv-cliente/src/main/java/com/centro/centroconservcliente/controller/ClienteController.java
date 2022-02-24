package com.centro.centroconservcliente.controller;


import com.centro.centroconservcliente.bean.ValidarClienteResponse;
import com.centro.centroconservcliente.service.IClienteService;

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
public class ClienteController {
    
    @Autowired
	private IClienteService service;

	@GetMapping("/alive")
    public ResponseEntity<String> alive() {
        String alive = "it is alive";
        return ResponseEntity.ok(alive);
    }
    
    @GetMapping("/encontrar-cliente")
	public ResponseEntity<ValidarClienteResponse> encontrarCliente(@RequestParam Integer tipo, @RequestParam String numero, @RequestParam String empresa ) {
		return ResponseEntity.ok(service.encontrarCliente(tipo, numero, empresa));
	}
}
