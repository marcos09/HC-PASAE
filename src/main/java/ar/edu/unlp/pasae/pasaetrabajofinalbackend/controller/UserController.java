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

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.UserDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

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

	// Alta de un usuario
	@PutMapping(path = "/crearUsuario", consumes = "application/json", produces = "application/json")
	public void create(@RequestBody @Valid UserDTO user) {
		this.getUserService().create(user);
	}

	public UserService getUserService() {
		return userService;
	}

}
