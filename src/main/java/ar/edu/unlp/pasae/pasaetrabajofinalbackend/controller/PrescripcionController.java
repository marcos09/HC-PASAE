package ar.edu.unlp.pasae.pasaetrabajofinalbackend.controller;

import java.util.List;

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

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PrescripcionDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.PrescripcionService;

@RestController
@CrossOrigin
@RequestMapping("/prescripcion")
public class PrescripcionController {

	@Autowired
	private PrescripcionService prescripcionService;

	public PrescripcionService getPrescripcionService() {
		return prescripcionService;
	}

	// Alta de prescripcion
	@PutMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public void create(@RequestBody @Valid PrescripcionDTO prescripcion) {
		this.getPrescripcionService().create(prescripcion);
	}

	// Listo todas las prescripciones

	@GetMapping(path = "/list")
	public List<PrescripcionDTO> list() {
		List<PrescripcionDTO> prescripciones = this.getPrescripcionService().list();
		return prescripciones;
	}

	// Recupero una prescripcion con el id
	@GetMapping(path = "/{id}", produces = "application/json")
	public PrescripcionDTO show(@PathVariable(value = "id") Long id) {
		return this.getPrescripcionService().retrive(id);
	}

	// Elimino prescripcion con el id
	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		this.getPrescripcionService().delete(id);
	}

}
