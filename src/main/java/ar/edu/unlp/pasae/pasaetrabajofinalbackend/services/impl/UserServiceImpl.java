package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.User;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.GenericRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.UserRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.UserService;

@Service
public class UserServiceImpl extends GenericServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
		
	public GenericRepository<User,Long> getRepository() {
		return (GenericRepository<User,Long>) repository;
	}
	
	public void setRepository(UserRepository repository) {
		this.repository = repository;
	}
	
	public UserServiceImpl() {
		super();
	}

}
