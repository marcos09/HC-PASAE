package ar.edu.unlp.pasae.pasaetrabajofinalbackend.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.aspect.ExceptionHandlerAspect;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.EgresoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.ElementoHistoriaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.HistoriaClinicaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.HistoriaCompactaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.HistoriaOrdenadaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.SeguimientoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.exception.BaseException;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.HistoriaClinicaService;

@RestController
@CrossOrigin
@RequestMapping("/historia")
public class HistoriaClinicaController {

	public HistoriaClinicaController() {
	}

	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAspect.class);
	
	@Autowired
	private HistoriaClinicaService historiaService;

	private HistoriaClinicaService getHistoriaService() {
		return historiaService;
	}

	// Listado de historias clinicas
	@GetMapping(path = "/list")
	public List<HistoriaClinicaDTO> list() {
		List<HistoriaClinicaDTO> historias = this.getHistoriaService().list();
		return historias;
	}

	// Recupero una historia clinica mediante el id
	@GetMapping(path = "/ordenada/{id}", produces = "application/json")
	public List<ElementoHistoriaDTO> showSorted(@PathVariable(value = "id") Long id) {
		return this.getHistoriaService().getHistoriaOrdenada(id);
	}
	
	@GetMapping(path = "/completaOrdenada/{id}", produces = "application/json")
	public HistoriaOrdenadaDTO showCompleteSorted(@PathVariable(value = "id") Long id) {
		return this.getHistoriaService().getHistoriaCompletaOrdenada(id);
	}

	// Recupero una historia clinica mediante el id
	@GetMapping(path = "/{id}", produces = "application/json")
	public HistoriaClinicaDTO show(@PathVariable(value = "id") Long id) {
		return this.getHistoriaService().retrive(id);
	}

	// Elimino historia clinica con el id
	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		this.getHistoriaService().delete(id);
	}

	// Verifico si la historia existe. Devuelve true si existe false en caso contrario.
	@GetMapping(path = "/existe/{id}", produces = "application/json")
	public Boolean exists(@PathVariable(value = "id") Long id) {
		return this.getHistoriaService().existsById(id);
	}

	// Alta de historia clinica
	@PutMapping(path = "/actualizarHistoria", consumes = "application/json", produces = "application/json")
	public void update(@RequestBody @Valid HistoriaClinicaDTO historiaDTO) {
		this.getHistoriaService().update(historiaDTO);
	}

	// Agregar seguimiento a una historia
	@PutMapping(path = "/agregarSeguimiento/{id}", consumes = "application/json", produces = "application/json")
	public Object agregarSeguimiento(@PathVariable(value = "id") Long id, @RequestBody SeguimientoDTO seguimiento)
			throws BaseException {
		try {
			return this.getHistoriaService().agregarSeguimiento(id, seguimiento);
		} catch (final BaseException e) {
			logger.error("Excepción {}", e.getLocalizedMessage());
			return e;
		}
	}

	// Egresar paciente
	@PutMapping(path = "/egresar/{id}", consumes = "application/json", produces = "application/json")
	public void egresar(@PathVariable(value = "id") Long id, @RequestBody EgresoDTO egreso) {
		this.getHistoriaService().egresar(id, egreso);
	}

	@GetMapping(path = "/{id}/paciente", produces = "application/json")
	public PacienteDTO getPaciente(@PathVariable(value = "id") Long id) {
		return this.getHistoriaService().getPaciente(id);
	}

	// Listado de historias clinicas de pacientes internados actualmente (No egresados)
	@GetMapping(path = "/activas")
	public List<HistoriaCompactaDTO> historiasActivas() {
		return this.getHistoriaService().historiasActivas();

	}
	
}
