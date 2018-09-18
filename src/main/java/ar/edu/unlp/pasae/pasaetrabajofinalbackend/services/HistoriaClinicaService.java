package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services;

import java.util.List;

import javax.validation.Valid;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.EgresoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.HistoriaClinicaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.HistoriaCompactaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.HistoriaOrdenadaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.SeguimientoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Paciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.exception.BaseException;

public interface HistoriaClinicaService {

	HistoriaClinicaDTO addIngreso(IngresoPaciente ip, Paciente paciente);

	void update(HistoriaClinicaDTO persistentDTO);

	void delete(Long id);

	HistoriaClinicaDTO retrive(Long id);

	List<HistoriaClinicaDTO> list();

	Object agregarSeguimiento(Long id, @Valid SeguimientoDTO seguimiento) throws BaseException;

	HistoriaOrdenadaDTO getHistoriaOrdenada(Long idHistoria);

	PacienteDTO getPaciente(Long id);
	List<HistoriaCompactaDTO> historiasActivas();

	void egresar(Long id,@Valid EgresoDTO egreso);

}
