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

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.HistoriaClinicaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.HistoriaOrdenadaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.SeguimientoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.HistoriaClinicaService;

@RestController
@CrossOrigin
@RequestMapping("/historia")
public class HistoriaClinicaController {

	public HistoriaClinicaController() {
	}

	@Autowired
	private HistoriaClinicaService historiaService;

	private HistoriaClinicaService getHistoriaService() {
		return historiaService;
	}

	//Listado de historias clinicas
	@GetMapping(path = "/list")
	public List<HistoriaClinicaDTO> list() {
		List<HistoriaClinicaDTO> historias = this.getHistoriaService().list();
		return historias;
	}

	// Recupero una historia clinica mediante el id
	@GetMapping(path = "/ordenada/{id}", produces = "application/json")
	public HistoriaOrdenadaDTO showSorted(@PathVariable(value = "id") Long id) {
		return this.getHistoriaService().getHistoriaOrdenada(id);
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

	// Alta de historia clinica
	@PutMapping(path = "/actualizarHistoria", consumes = "application/json", produces = "application/json")
	public void update(@RequestBody @Valid HistoriaClinicaDTO historiaDTO) {
		this.getHistoriaService().update(historiaDTO);
	}
	
	//Agregar seguimiento a una historia
	@PutMapping(path = "/agregarSeguimiento/{id}", consumes = "application/json", produces = "application/json")
	public void agregarSeguimiento(@PathVariable(value = "id") Long id, @RequestBody SeguimientoDTO seguimiento) {
		
		this.getHistoriaService().agregarSeguimiento(id, seguimiento);
	}
	
	@GetMapping(path="/{id}/paciente", produces = "application/json")
	public PacienteDTO getPaciente(@PathVariable(value = "id") Long id) {
		return this.getHistoriaService().getPaciente(id);
	}
	//Listado de historias clinicas de pacientes internados actualmente (No egresados)
		@GetMapping(path = "/activas")
		public List<HistoriaClinicaDTO> historiasActivas() {
			List<HistoriaClinicaDTO> historias = this.getHistoriaService().historiasActivas();
			return historias;
		}
	
	
}
