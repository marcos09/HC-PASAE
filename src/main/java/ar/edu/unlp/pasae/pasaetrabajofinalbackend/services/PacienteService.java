package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services;

import java.util.List;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PacienteDTO;

public interface PacienteService {
	void create(PacienteDTO persistentDTO);

	void update(PacienteDTO persistentDTO);

	void delete(Long id);

	PacienteDTO retrive(Long id);

	List<PacienteDTO> list();

	List<PacienteDTO> findByApellidoContaining(String apellido);

}
