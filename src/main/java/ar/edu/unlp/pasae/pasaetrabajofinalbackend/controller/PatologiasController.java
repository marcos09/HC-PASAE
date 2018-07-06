package ar.edu.unlp.pasae.pasaetrabajofinalbackend.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.GenericDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PatologiaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.UserDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.PatologiasService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.UserService;

@RestController
@RequestMapping("/patologias")

public class PatologiasController {
	
	@Autowired
	private PatologiasService patologiasService;

	//Listo todas las patologias
	@GetMapping(path = "/list")
	public Collection<GenericDTO> list(){
		List<GenericDTO> patologias = this.getPatologiasService().list();
		return patologias;
	}
	
	//Recupero una patologia con el id
	 @GetMapping(path = "/{id}", produces = "application/json")
	   public GenericDTO show(@PathVariable(value = "id") Long id) {
	    return this.getPatologiasService().retrive(id);
	   }
	 
	 //Elimino una patologia con el id
	 @DeleteMapping(path = "/{id}")
	   public void delete(@PathVariable(value = "id") Long id) {
	     this.getPatologiasService().delete(id);
	   }
	 
	 //Alta de una patologia
	 @PutMapping(path = "/crearPatologia", consumes = "application/json", produces = "application/json")
	   public  void create(@RequestBody PatologiaDTO patologia) {
	        this.getPatologiasService().create(patologia);
	   }

	public PatologiasService getPatologiasService() {
		return patologiasService;
	}

	public void setPatologiasService(PatologiasService patologiasService) {
		this.patologiasService = patologiasService;
	}


}


