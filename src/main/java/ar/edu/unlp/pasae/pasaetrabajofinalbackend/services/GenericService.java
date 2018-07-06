package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services;

import java.util.List;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.GenericDTO;

public interface GenericService {
	
	
	void create(GenericDTO persistentDTO); 
	void update(GenericDTO persistentDTO);
	void delete(Long id); 
	GenericDTO retrive(Long id);
	List<GenericDTO> list();
	/*
	void thowException() throws BaseException;
	void thowBaseException() throws BaseException;
	*/

}
