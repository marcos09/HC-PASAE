package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.HistoriaClinicaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.exception.BaseException;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.CantidadIngresosDiagnosticoDTO;

public interface IngresoPacienteService extends GenericService {

	HistoriaClinicaDTO create(IngresoPacienteDTO persistentDTO, Long idPaciente) throws BaseException;

	void update(IngresoPacienteDTO persistentDTO);

	void delete(Long id);

	IngresoPacienteDTO retrive(Long id);

	List<IngresoPacienteDTO> list();

	Set<CantidadIngresosDiagnosticoDTO> getCountDiagnosticoSintomatico();
	Set<CantidadIngresosDiagnosticoDTO> getCountDiagnosticoPresuntivo();
	
}