package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services;

import java.util.List;

import javax.validation.Valid;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.EgresoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.ElementoHistoriaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.HistoriaClinicaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.HistoriaCompactaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.HistoriaOrdenadaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.SeguimientoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Paciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.exception.BaseException;

public interface HistoriaClinicaService extends GenericService {

	HistoriaClinicaDTO addIngreso(IngresoPaciente ip, Paciente paciente) throws BaseException;

	void update(HistoriaClinicaDTO persistentDTO);

	void delete(Long id);

	HistoriaClinicaDTO retrive(Long id);

	List<HistoriaClinicaDTO> list();

	Object agregarSeguimiento(Long id, @Valid SeguimientoDTO seguimiento) throws BaseException;

	List<ElementoHistoriaDTO> getHistoriaOrdenada(Long idHistoria);

	PacienteDTO getPaciente(Long id) throws BaseException;
	List<HistoriaCompactaDTO> historiasActivas();

	void egresar(Long id,@Valid EgresoDTO egreso);

	HistoriaOrdenadaDTO getHistoriaCompletaOrdenada(Long idHistoria);

	Object getPacienteEgreso(Long id) throws BaseException;
	
	IngresoPacienteDTO getIngreso(Long id) throws BaseException;

	Boolean isHospitalized(int dni);
}
