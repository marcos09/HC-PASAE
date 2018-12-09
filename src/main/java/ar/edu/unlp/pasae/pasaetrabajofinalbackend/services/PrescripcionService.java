package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services;

import java.util.List;
import java.util.Set;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.CantidadPrescripcionesMedicamentoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PrescripcionDTO;

public interface PrescripcionService extends GenericService {
	void create(PrescripcionDTO persistentDTO);

	void update(PrescripcionDTO persistentDTO);

	void delete(Long id);
	
	void aplicar(Long id);

	PrescripcionDTO retrive(Long id);

	List<PrescripcionDTO> list();
	
	List<PrescripcionDTO> listActivePrescriptions();
	
	List<PrescripcionDTO> listEndPrescriptionForHistory(Long id);
	
	Set<CantidadPrescripcionesMedicamentoDTO> cantidadPrescripcionesMedicamento();
}
