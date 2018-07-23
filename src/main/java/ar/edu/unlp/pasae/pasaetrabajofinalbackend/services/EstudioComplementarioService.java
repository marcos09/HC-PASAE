package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services;

import java.util.List;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.EstudioComplementarioDTO;

public interface EstudioComplementarioService {
	
	void create(EstudioComplementarioDTO persistentDTO);

	void update(EstudioComplementarioDTO persistentDTO);

	void delete(Long id);

	EstudioComplementarioDTO retrive(Long id);

	List<EstudioComplementarioDTO> list();

}
