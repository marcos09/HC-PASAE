package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services;

import java.util.List;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PrescripcionDTO;

public interface PrescripcionService extends GenericService {
	void create(PrescripcionDTO persistentDTO);

	void update(PrescripcionDTO persistentDTO);

	void delete(Long id);
	
	void aplicar(Long id);

	PrescripcionDTO retrive(Long id);

	List<PrescripcionDTO> list();
	
	List<PrescripcionDTO> listActivePrescriptions();
	
}
