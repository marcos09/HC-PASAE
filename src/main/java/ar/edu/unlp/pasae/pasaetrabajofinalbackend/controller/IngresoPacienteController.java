package ar.edu.unlp.pasae.pasaetrabajofinalbackend.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.IngresoPacienteService;

@RestController
@CrossOrigin
@RequestMapping("/ingreso")
public class IngresoPacienteController {

	/*
	 * import org.slf4j.Logger;
	 * import org.slf4j.LoggerFactory;
	 * import ar.edu.unlp.pasae.pasaetrabajofinalbackend.aspect.ExceptionHandlerAspect;
	 * 	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAspect.class);
	 * 
	 */

	@Autowired
	private IngresoPacienteService ingresoService;

	// Listo todos los ingresos

	@GetMapping(path = "/list")
	public List<IngresoPacienteDTO> list() {
		List<IngresoPacienteDTO> ingresos = this.getIngresoService().list();
		return ingresos;
	}

	@GetMapping(path = "/test")
	public String testRest() {
		return "Test correct";
	}

	@RolesAllowed("ROLE_STUDENT")
	@GetMapping(path = "/testStudent")
	public String testStudent() {
		return "Test student correct";
	}

	@RolesAllowed("ROLE_ADMIN")
	@GetMapping(path = "/testAdmin")
	public String testAdmin() {
		return "Test admin correct";
	}

	// Recupero un ingreso con el id
	@GetMapping(path = "/{id}", produces = "application/json")
	public IngresoPacienteDTO show(@PathVariable(value = "id") Long id) {
		return this.getIngresoService().retrive(id);
	}

	// Elimino ingreso con el id
	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		this.getIngresoService().delete(id);
	}

	// Alta de ingreso
	@PutMapping(path = "/createIngreso", consumes = "application/json", produces = "application/json")
	public void create(@RequestBody @Valid IngresoPacienteDTO ingresoPaciente) {
		this.getIngresoService().create(ingresoPaciente);
	}

	private IngresoPacienteService getIngresoService() {
		return ingresoService;
	}

	// Prueba para ver si funciona el aspecto que convierte las excepciones no
	// manejadas
	// @GetMapping(path = "/exception")
	// public void exception() {
	// try {
	// getIngresoService().thowException();
	// } catch (final BaseException e) {
	// logger.error("Excepción {}", e.getLocalizedMessage());
	// }
	// }

}