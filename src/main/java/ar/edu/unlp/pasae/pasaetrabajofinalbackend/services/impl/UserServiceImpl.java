package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.UserDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.User;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.UserRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.UserService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.Transformer;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	@Autowired
	private Transformer<User, UserDTO> transformer;
	
	@Autowired
	private Validator validator;
	
	private Transformer<User, UserDTO> getTransformer() {
		return transformer;
	}

	@SuppressWarnings("unused")
	private void setTransformer(Transformer<User, UserDTO> transformer) {
		this.transformer = transformer;
	}
		
	public UserRepository getRepository() {
		return repository;
	}
	
	public void setRepository(UserRepository repository) {
		this.repository = repository;
	}
	
	public UserServiceImpl() {
		super();
	}

	@Override
	public void create(UserDTO persistentDTO) {
		// TODO Auto-generated method stub
		//User u = new User();
		/*
		Set<ConstraintViolation<User>> validations = validator.validate(u);//si esta vacio no hubieron errores de validacion
		if (validations.isEmpty()) {
			this.getRepository().save(u);
		}
		*/
		this.getRepository().save(transformer.toEntity(persistentDTO));
		
	}

	@Override
	public void update(UserDTO dto) {
		// TODO Auto-generated method stub
		Optional<User> op = this.getRepository().findById(dto.getId());
		User u = op.get();
		u.setAuthorities(dto.getAuthorities());
		u.setEmail(dto.getEmail());
		u.setUsername(dto.getUsername());
		this.getRepository().save(u);
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		this.getRepository().deleteById(id);
		
	}

	@Override
	public UserDTO retrive(Long id) {
		// TODO Auto-generated method stub
		User u = this.getRepository().findById(id).get();
		return this.getTransformer().toDTO(u);
	}

	@Override
	public List<UserDTO> list() {
		// TODO Auto-generated method stub
		 List<User> userList = this.getRepository().findAll();
		 return this.getTransformer().toListDTO(userList);
	}
}