package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services;

import java.util.List;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PatologiaDTO;

public interface PatologiasService extends GenericService {
	
	void create(PatologiaDTO persistentDTO); 
	void update(PatologiaDTO persistentDTO);
	void delete(Long id); 
	PatologiaDTO retrive(Long id);
	List<PatologiaDTO> list();

}
