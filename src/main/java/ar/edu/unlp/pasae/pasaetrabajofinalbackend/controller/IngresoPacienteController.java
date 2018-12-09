package ar.edu.unlp.pasae.pasaetrabajofinalbackend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.aspect.ExceptionHandlerAspect;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.CantidadIngresosDiagnosticoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.CantidadPrescripcionesMedicamentoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.exception.BaseException;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.IngresoPacienteService;

@RestController
@CrossOrigin
@RequestMapping("/ingreso")
public class IngresoPacienteController {

	@Autowired
	private IngresoPacienteService ingresoService;
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAspect.class);
	

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
	@PutMapping(path = "/createIngreso/{idPaciente}", consumes = "application/json", produces = "application/json")
	public Object create(@RequestBody @Valid IngresoPacienteDTO ingresoPaciente, @PathVariable(value = "idPaciente") Long idPaciente) throws BaseException {
		try {
			return this.getIngresoService().create(ingresoPaciente, idPaciente);
		} catch (final BaseException e) {
			logger.error("Excepción {}", e.getLocalizedMessage());
			Map<String, Object> response = new HashMap<String, Object>();
			response.put("errors", e.getLocalizedMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}	
	
	private IngresoPacienteService getIngresoService() {
		return ingresoService;
	}
	
	
	@GetMapping(path = "/cantidadPacientesDiagnosticoPresuntivo", produces = "application/json")
	public Set<CantidadIngresosDiagnosticoDTO> cantidadPacientesDiagnosticoPresuntivo() {
		return this.getIngresoService().getCountDiagnosticoPresuntivo();
	}

	@GetMapping(path = "/cantidadPacientesDiagnosticoSintomatico", produces = "application/json")
	public Set<CantidadIngresosDiagnosticoDTO> cantidadPacientesDiagnosticoSintomatico() {
		return this.getIngresoService().getCountDiagnosticoSintomatico();
	}

	

}