package ar.edu.unlp.pasae.pasaetrabajofinalbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.IngresoPacienteService;

@RestController
@RequestMapping("/person")
public class PersonController {
	

	@Autowired
	private
	IngresoPacienteService personService;
	
	@GetMapping(path="/list")
	public void list(){
		
		
	}

	


}
