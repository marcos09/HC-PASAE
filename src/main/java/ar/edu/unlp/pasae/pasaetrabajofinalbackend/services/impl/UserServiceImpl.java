package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.GenericDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.UserDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.User;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.UserRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.UserService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.Transform;

@Service
public class UserServiceImpl extends GenericServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Transform genericTransform;
	
	public Transform getGenericTransform() {
		return genericTransform;
	}

	public void setGenericTransform(Transform genericTransform) {
		this.genericTransform = genericTransform;
	}
	
	public UserRepository getRepository() {
		return userRepository;
	}
	
	public void setRepository(UserRepository repository) {
		this.userRepository = repository;
	}
	
	public UserServiceImpl() {
		super();
	}

	@Override
	public void create(GenericDTO persistentDTO) {
		this.getRepository().save(this.getGenericTransform().getUser((UserDTO)persistentDTO));

	}

	@Override
	public void update(GenericDTO persistentDTO) {
		this.getRepository().save(this.getGenericTransform().getUser((UserDTO) persistentDTO));
	}

	@Override
	public void delete(Long id) {
		this.getRepository().deleteById(id);
	}

	@Override
	public GenericDTO retrive(Long id) {
		Optional<User> user = this.getRepository().findById(id);
		if(user.isPresent()) {
			return this.getGenericTransform().getUserDTO(user.get());
		}
		return null;
	}

	@Override
	public List<GenericDTO> list() {
			
		 List<User> users = this.getRepository().findAll();
		 
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
