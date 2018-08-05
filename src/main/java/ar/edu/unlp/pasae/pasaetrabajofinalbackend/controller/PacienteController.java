package ar.edu.unlp.pasae.pasaetrabajofinalbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.PacienteService;

@RestController
@CrossOrigin
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	private PacienteService pacienteService;
	
	@PutMapping(path = "/createPaciente", consumes = "application/json", produces = "application/json")
	public void create(@RequestBody PacienteDTO pacienteDTO) {
		this.getPacienteService().create(pacienteDTO);
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
	public PacienteDTO show(@PathVariable(value = "id") Long id) {
		return this.getPacienteService().retrive(id);
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
