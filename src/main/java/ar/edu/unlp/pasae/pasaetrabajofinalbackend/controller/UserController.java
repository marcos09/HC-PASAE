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
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.UserDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.exception.BaseException;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAspect.class);
	
	@Autowired
	private UserService userService;

	// Listo todos los ingresos
	@GetMapping(path = "/list")
	public List<UserDTO> list() {
		List<UserDTO> ingresos = this.getUserService().list();
		return ingresos;
	}

	// Recupero un usuario con el id
	@GetMapping(path = "/{id}", produces = "application/json")
	public UserDTO show(@PathVariable(value = "id") Long id) {
		return this.getUserService().retrive(id);
	}

	
	// Elimino un usuario con el id
	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		this.getUserService().delete(id);
	}

	
	@PutMapping(path = "/buscar", consumes = "application/json", produces = "application/json")
	public List<UserDTO> searchUsers(@RequestBody @Valid UserDTO user){
		return this.getUserService().search(user);
	}
	
	
	// Alta de un usuario
	@PutMapping(path = "/crearUsuario", consumes = "application/json", produces = "application/json")
	public void create(@RequestBody @Valid UserDTO user) throws BaseException {
		try {
			this.getUserService().create(user);
		}catch(final BaseException e) {
			logger.error("Excepción {}", e.getLocalizedMessage());
		}
		
	}

	public UserService getUserService() {
		return userService;
	}
	
	// Listo todos los ingresos
	@GetMapping(path = "/paginatedList/{pageNumber}/{pageSize}")
	public List<UserDTO> paginatedList(@PathVariable(value = "pageNumber") int pageNumber, @PathVariable(value = "pageSize") int pageSize) {
		return this.getUserService().userByPage(pageNumber, pageSize);
	}


		
}
