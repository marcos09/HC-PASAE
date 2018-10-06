package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services;

import java.util.List;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PatologiaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.exception.BaseException;

public interface PatologiasService extends GenericService {
	
	PatologiaDTO create(PatologiaDTO persistentDTO) throws BaseException; 
	void update(PatologiaDTO persistentDTO);
	void delete(Long id); 
	PatologiaDTO retrive(Long id);
	List<PatologiaDTO> list();

}
