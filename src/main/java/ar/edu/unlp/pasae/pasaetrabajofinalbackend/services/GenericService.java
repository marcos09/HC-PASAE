package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services;

import java.util.List;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.GenericDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.GenericRepository;

public interface GenericService {
	
	
	void create(GenericDTO persistentDTO); 
	void update(GenericDTO persistentDTO);
	void delete(Long id); 
	GenericDTO retrive(Long id);
	List<GenericDTO> list();
	GenericRepository getRepository();
	/*
	void thowException() throws BaseException;
	void thowBaseException() throws BaseException;
	*/

}
