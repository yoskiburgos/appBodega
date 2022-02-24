package com.centro.centroconservsucursal.controller;

import com.centro.centroconservsucursal.bean.ActualizarTelefonoSucursalIdRequest;
import com.centro.centroconservsucursal.bean.ActualizarTelefonoSucursalIdResponse;
import com.centro.centroconservsucursal.bean.EncontrarDetalleClienteSucursalIdResponse;
import com.centro.centroconservsucursal.bean.EncontrarSucursalIdTelefonoResponse;
import com.centro.centroconservsucursal.bean.EncontrarSucursalResponse;
import com.centro.centroconservsucursal.bean.ValidarClienteIdResponse;
import com.centro.centroconservsucursal.bean.ValidarTelefonoClienteResponse;
import com.centro.centroconservsucursal.service.ISucursalService;

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
public class SucursalController {
	
    @Autowired
	private ISucursalService service;

	@GetMapping("/alive")
    public ResponseEntity<String> alive() {
        String alive = "it is alive";
        return ResponseEntity.ok(alive);
    }

    @GetMapping("/encontrar-telefono-cliente")
	public ResponseEntity<ValidarTelefonoClienteResponse> encontrarTelefonoCliente(@RequestParam String telefono, @RequestParam Integer idCliente ) {
		return ResponseEntity.ok(service.encontrarTelefonoCliente(telefono, idCliente));
	}

	@GetMapping("/encontrar")
	public ResponseEntity<EncontrarSucursalResponse> encontrarSucursalId(@RequestParam Integer idSucursal) {
		return ResponseEntity.ok(service.encontrarSucursalId(idSucursal));
	}

	@GetMapping("/encontrar-detalle-cliente")
	public ResponseEntity<EncontrarDetalleClienteSucursalIdResponse> encontrarDetalleClienteSucursalId(@RequestParam Integer idSucursal) {
		return ResponseEntity.ok(service.encontrarDetalleClienteSucursalId(idSucursal));
	}

	@GetMapping("/encontrar-telefono")
	public ResponseEntity<EncontrarSucursalIdTelefonoResponse> encontrarSucursalIdTelefono(@RequestParam Integer idSucursal, @RequestParam String telefono) {
		return ResponseEntity.ok(service.encontrarSucursalIdTelefono(idSucursal, telefono));
	}

	@PostMapping("/actualizar-telefono")
	public ResponseEntity<ActualizarTelefonoSucursalIdResponse> actualizarTelefonoSucursalId(@RequestBody ActualizarTelefonoSucursalIdRequest request) {
		return ResponseEntity.ok(service.actualizarTelefonoSucursalId(request));
	}

	@GetMapping("/encontrar-cliente")
	public ResponseEntity<ValidarClienteIdResponse> encontrarSucursalClienteId( @RequestParam Integer idCliente ) {
		return ResponseEntity.ok(service.encontrarSucursalClienteId(idCliente));
	}
}
