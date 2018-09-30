package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.UserDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.User;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.exception.BaseException;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.UserRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.UserService;

@Service
@Transactional
public class UserServiceImpl extends GenericServiceImpl<UserRepository, User, UserDTO> implements UserService {

	@Autowired
	private Validator validator;


	public UserServiceImpl() {
		super();
	}

	@Override
	public void create(UserDTO persistentDTO) throws BaseException {

		String mail = persistentDTO.getEmail();
		if (this.getRepository().findByEmail(mail) != null) {
			if (mail.equals(this.getRepository().findByEmail(mail).getEmail())) {
				throw new RuntimeException("El usuario con el mail que intenta agregar ya existe");
			}
		}

		String username = persistentDTO.getUsername();
		if (this.getRepository().findByUsername(username) != null) {
			if (username.equals(this.getRepository().findByUsername(username).getUsername())) {
				throw new RuntimeException("El nombre de usuario que intenta agregar ya existe");
			}
		}

		String role = "ROLE_" + persistentDTO.getAuthorities().toUpperCase();
		persistentDTO.setAuthorities(role);
		Set<ConstraintViolation<UserDTO>> validations = validator.validate(persistentDTO);// si esta vacio no hubieron
																							// errores de validacion
		if (validations.isEmpty()) {
			this.getRepository().save(this.getTransformer().toEntity(persistentDTO));
		}

	}

	@Override
	public void update(UserDTO dto) {
		Optional<User> op = this.getRepository().findById(dto.getId());
		User u = op.get();
		u.setAuthorities(dto.getAuthorities());
		u.setEmail(dto.getEmail());
		u.setUsername(dto.getUsername());
		this.getRepository().save(u);

	}

	@Override
	public void delete(Long id) {
		this.getRepository().deleteById(id);

	}

	@Override
	public UserDTO retrive(Long id) {
		User u = this.getRepository().findById(id).get();
		return this.getTransformer().toDTO(u);
	}

	@Override
	public List<UserDTO> list() {
		List<User> userList = this.getRepository().findAll();
		return this.getTransformer().toListDTO(userList);
	}

	public Validator getValidator() {
		return validator;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@Override
	public List<UserDTO> search(UserDTO userDTO) {
		return this.getTransformer().toListDTO(
			this.getRepository().findByUsernameContainingAndEmailContaining(userDTO.getUsername(), userDTO.getEmail()));
	}
	
	
	public List<UserDTO> userByPage(int pageNumber, int pageSize){
			PageRequest.of(pageNumber, pageSize);
	      PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
	      Iterable<User> res = this.getRepository().findAll(pageRequest);
	      List<UserDTO> users = new ArrayList<UserDTO>();
	      for(User u: res){
	    	  users.add(this.getTransformer().toDTO(u));
	    	  }
	      return  users;
	   }

}