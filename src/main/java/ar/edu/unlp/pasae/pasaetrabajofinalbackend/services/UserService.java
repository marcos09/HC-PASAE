package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services;

import java.util.List;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.UserDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.exception.BaseException;

public interface UserService  {

	void create(UserDTO persistentDTO) throws BaseException; 
	void update(UserDTO persistentDTO);
	void delete(Long id); 
	UserDTO retrive(Long id);
	List<UserDTO> list();
	
}
