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
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.EstudioComplementarioDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.exception.BaseException;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.EstudioComplementarioService;

@RestController
@CrossOrigin
@RequestMapping("/estudio")
public class EstudioComplementarioController {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAspect.class);
	
	@Autowired
	private EstudioComplementarioService estudioService;

	public EstudioComplementarioService getEstudioService() {
		return estudioService;
	}

	// Alta de estudio
	@PutMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public void create(@RequestBody @Valid EstudioComplementarioDTO estudio) {
		this.getEstudioService().create(estudio);
	}
	
	// Update de estudio
		@PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
		public void update(@RequestBody @Valid EstudioComplementarioDTO estudio) throws BaseException  {
			try {
				this.getEstudioService().update(estudio);
			} catch (final BaseException e) {
				logger.error("Excepción {}", e.getLocalizedMessage());
			}
		}

	// Listado de estudios complementarios
	@GetMapping(path = "/list")
	public List<EstudioComplementarioDTO> list() {
		List<EstudioComplementarioDTO> estudios = this.getEstudioService().list();
		return estudios;
	}

	// Recupero un estudio con el id
	@GetMapping(path = "/{id}", produces = "application/json")
	public EstudioComplementarioDTO show(@PathVariable(value = "id") Long id) {
		return this.getEstudioService().retrive(id);
	}

	// Elimino un estudio con el id
	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		this.getEstudioService().delete(id);
	}
	
	// Recupero un estudio con el id
	@GetMapping(path = "/activos", produces = "application/json")
	public List<EstudioComplementarioDTO> estudiosActivos() {
		 return this.getEstudioService().estudiosActivos();
	}

	
	

}
