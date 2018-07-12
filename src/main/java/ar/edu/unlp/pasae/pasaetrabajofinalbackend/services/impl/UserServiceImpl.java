package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.GenericDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.UserDTO;
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
	
	public UserRepository getParticularRepository() {
		return repository;
	}
	
	public UserServiceImpl() {
		super();
	}


	@Override
	public void update(GenericDTO persistentDTO) {
		this.getParticularRepository().save(this.getGenericTransform().getUser((UserDTO) persistentDTO));
	}

	@Override
	public List<GenericDTO> list() {
			
		 List<User> users = this.getParticularRepository().findAll();
		 
		 List<GenericDTO> list = new ArrayList<GenericDTO>();
		 Iterator<User> it = users.iterator();
		 while(it.hasNext()) {
			 User user = (User) it.next();
			 UserDTO userDTO = this.getGenericTransform().getUserDTO(user);
			 list.add(userDTO);
		 }
		 return list;
		 
	}

}
