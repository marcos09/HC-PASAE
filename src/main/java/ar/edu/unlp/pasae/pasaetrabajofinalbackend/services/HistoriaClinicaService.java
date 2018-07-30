package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services;

import java.util.List;

import javax.validation.Valid;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.HistoriaClinicaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.SeguimientoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;

public interface HistoriaClinicaService {

	void addIngreso(IngresoPaciente ip);

	void update(HistoriaClinicaDTO persistentDTO);

	void delete(Long id);

	HistoriaClinicaDTO retrive(Long id);

	List<HistoriaClinicaDTO> list();

	void agregarSeguimiento(Long id, @Valid SeguimientoDTO seguimiento);

}
