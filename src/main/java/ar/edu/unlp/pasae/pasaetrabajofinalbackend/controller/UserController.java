package ar.edu.unlp.pasae.pasaetrabajofinalbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private UserService userService;

}
