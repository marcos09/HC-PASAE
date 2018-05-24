package ar.edu.unlp.pasae.pasaetrabajofinalbackend.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.GenericDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.IngresoPacienteService;

@RestController
@RequestMapping("/ingreso")
public class IngresoPacienteController {

	@Autowired
	private IngresoPacienteService ingresoService;
	
	@GetMapping(path = "/list")
	public Collection<GenericDTO> list(){
		List<GenericDTO> ingresos = this.getIngresoService().list();
		return ingresos;
	}
	@GetMapping(path = "/test")
	public String testRest(){
		return "Test correct";
	}

	private IngresoPacienteService getIngresoService() {
		return ingresoService;
	}
}