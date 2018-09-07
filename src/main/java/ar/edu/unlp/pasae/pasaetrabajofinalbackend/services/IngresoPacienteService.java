package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services;

import java.util.List;

import javax.validation.Valid;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.HistoriaClinicaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacienteDTO;

public interface IngresoPacienteService {

	HistoriaClinicaDTO create(IngresoPacienteDTO persistentDTO, Long idPaciente);

	void update(IngresoPacienteDTO persistentDTO);

	void delete(Long id);

	IngresoPacienteDTO retrive(Long id);

	List<IngresoPacienteDTO> list();

}