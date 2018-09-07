package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services;

import java.util.List;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.exception.BaseException;

public interface PacienteService {
	PacienteDTO create(PacienteDTO persistentDTO) throws BaseException;

	PacienteDTO update(PacienteDTO persistentDTO) throws BaseException;

	void delete(Long id);

	PacienteDTO retrive(Long id)  throws BaseException;
	
	PacienteDTO findByDni(int dni);

	List<PacienteDTO> list();

	List<PacienteDTO> findByApellidoContaining(String apellido);

}
