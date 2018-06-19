package ar.edu.unlp.pasae.pasaetrabajofinalbackend.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.aspect.ExceptionHandlerAspect;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.GenericDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.exception.BaseException;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.IngresoPacienteService;

@RestController
@RequestMapping("/ingreso")
public class IngresoPacienteController {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAspect.class);
	
	@Autowired
	private IngresoPacienteService ingresoService;
	
	
	//Listo todos los ingresos
	@GetMapping(path = "/list")
	public Collection<GenericDTO> list(){
		List<GenericDTO> ingresos = this.getIngresoService().list();
		return ingresos;
	}
	
	@GetMapping(path = "/test")
	public String testRest(){
		return "Test correct";
	}
	//Recupero un ingreso con el id
	 @GetMapping(path = "/{id}", produces = "application/json")
	   public GenericDTO show(@PathVariable(value = "id") Long id) {
	    return this.getIngresoService().retrive(id);
	   }
	 
	 //Elimino ingreso con el id
	 @DeleteMapping(path = "/{id}")
	   public void delete(@PathVariable(value = "id") Long id) {
	     this.getIngresoService().delete(id);
	   }
	 
	 //Alta de ingreso
	 @PutMapping(path = "/createIngreso", consumes = "application/json", produces = "application/json")
	   public  void create(@RequestBody @Valid IngresoPacienteDTO ingresoPaciente) {
	        this.getIngresoService().create(ingresoPaciente);
	   }

	private IngresoPacienteService getIngresoService() {
		return ingresoService;
	}

	//Prueba para ver si funciona el aspecto que convierte las excepciones no manejadas
//	@GetMapping(path = "/exception")
//	public void exception() {
//		try {
//			getIngresoService().thowException();
//		} catch (final BaseException e) {
//			logger.error("Excepción {}", e.getLocalizedMessage());
//		}
//	}

}