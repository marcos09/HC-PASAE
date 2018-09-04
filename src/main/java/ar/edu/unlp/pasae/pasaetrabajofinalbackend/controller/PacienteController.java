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
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.exception.BaseException;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.PacienteService;

@RestController
@CrossOrigin
@RequestMapping("/pacientes")
public class PacienteController {
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAspect.class);

	@Autowired
	private PacienteService pacienteService;

	@PutMapping(path = "/createPaciente", consumes = "application/json", produces = "application/json")
	public void create(@RequestBody @Valid PacienteDTO pacienteDTO) throws BaseException {
		try {
			this.getPacienteService().create(pacienteDTO);
		} catch (final BaseException e) {
			logger.error("Excepción {}", e.getLocalizedMessage());
		}
	}
	
	@PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
	public void update(@RequestBody @Valid PacienteDTO pacienteDTO) throws BaseException {
		try {
			this.getPacienteService().update(pacienteDTO);
		} catch (final BaseException e) {
			logger.error("Excepción {}", e.getLocalizedMessage());
		}
	}

	@GetMapping(path = "/list")
	public List<PacienteDTO> list() {
		List<PacienteDTO> pacientes = this.getPacienteService().list();
		return pacientes;
	}

	@GetMapping(path = "/buscarApellido/{apellido}", produces = "application/json")
	public List<PacienteDTO> findByDni(@PathVariable(value = "apellido") String apellido) {
		List<PacienteDTO> pacientes = this.getPacienteService().findByApellidoContaining(apellido);
		return pacientes;
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public PacienteDTO show(@PathVariable(value = "id") Long id) throws BaseException {
		try {
			return this.getPacienteService().retrive(id);
		} catch (final BaseException e) {
			logger.error("Excepción {}", e.getLocalizedMessage());
		}
		return null;
	}

	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		this.getPacienteService().delete(id);
	}

	public PacienteService getPacienteService() {
		return pacienteService;
	}

	public void setPacienteService(PacienteService pacienteService) {
		this.pacienteService = pacienteService;
	}

}
