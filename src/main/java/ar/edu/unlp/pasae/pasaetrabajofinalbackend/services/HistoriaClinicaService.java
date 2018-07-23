package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services;

import java.util.List;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.HistoriaClinicaDTO;

public interface HistoriaClinicaService {

	void create(HistoriaClinicaDTO persistentDTO);

	void update(HistoriaClinicaDTO persistentDTO);

	void delete(Long id);

	HistoriaClinicaDTO retrive(Long id);

	List<HistoriaClinicaDTO> list();

}
