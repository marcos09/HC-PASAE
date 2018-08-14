package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.UserDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.User;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.exception.BaseException;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.UserRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.UserService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.Transformer;

@Service
@Transactional
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

}