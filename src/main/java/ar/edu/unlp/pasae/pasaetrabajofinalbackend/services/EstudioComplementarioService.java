package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services;

import java.util.List;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.EstudioComplementarioDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.exception.BaseException;

public interface EstudioComplementarioService extends GenericService{
	
	void create(EstudioComplementarioDTO persistentDTO);

	void update(EstudioComplementarioDTO persistentDTO) throws BaseException;

	void delete(Long id);

	EstudioComplementarioDTO retrive(Long id) throws BaseException;

	List<EstudioComplementarioDTO> list();
	
	List<EstudioComplementarioDTO> estudiosActivos();
	
	PacienteDTO findPacienteFromEstudio(Long idEstudio) throws BaseException;

}
