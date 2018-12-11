package ar.edu.unlp.pasae.pasaetrabajofinalbackend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PatologiaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.exception.BaseException;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.PatologiasService;

@RestController
@CrossOrigin
@RequestMapping("/patologias")

public class PatologiasController {

	@Autowired
	private PatologiasService patologiasService;
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAspect.class);
	
	@CrossOrigin

	@GetMapping(path = "/list")
	public List<PatologiaDTO> list() {
		List<PatologiaDTO> patologias = this.getPatologiasService().list();
		return patologias;
	}

	// Recupero una patologia con el id
	@GetMapping(path = "/{id}", produces = "application/json")
	public PatologiaDTO show(@PathVariable(value = "id") Long id) {
		return this.getPatologiasService().retrive(id);
	}

	// Elimino una patologia con el id
	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		this.getPatologiasService().delete(id);
	}

	// Alta de una patologia
	@PutMapping(path = "/crearPatologia", consumes = "application/json", produces = "application/json")
	public Object create(@RequestBody PatologiaDTO patologia) throws BaseException {
		try {
			return this.getPatologiasService().create(patologia);	
		}catch (final BaseException e) {
			logger.error("Excepción {}", e.getLocalizedMessage());
			Map<String, Object> response = new HashMap<String, Object>();
			response.put("errors", e.getLocalizedMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
	}

	// Modificacion de una patologia
	@PutMapping(path = "/updatePatologia", consumes = "application/json", produces = "application/json")
	public void update(@RequestBody PatologiaDTO patologia) {
		this.getPatologiasService().update(patologia);
	}

	public PatologiasService getPatologiasService() {
		return patologiasService;
	}

}
