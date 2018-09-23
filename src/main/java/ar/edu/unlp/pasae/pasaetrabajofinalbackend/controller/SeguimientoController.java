package ar.edu.unlp.pasae.pasaetrabajofinalbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.SeguimientoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.SeguimientoService;

@RestController
@RequestMapping("/seguimiento")
public class SeguimientoController {
	
	@Autowired
	private SeguimientoService seguimientoService;
	
	public SeguimientoService getSeguimientoService() {
		return seguimientoService;
	}

	public void setSeguimientoService(SeguimientoService seguimientoService) {
		this.seguimientoService = seguimientoService;
	}

	// Recupero un seguimiento mediante el id
	@GetMapping(path = "/{id}", produces = "application/json")
	public SeguimientoDTO show(@PathVariable(value = "id") Long id) {
		return this.getSeguimientoService().retrive(id);
	}

}
