package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services;

import java.util.List;
import java.util.Set;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.CantidadIngresosDiagnosticoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.CantidadPrescripcionesMedicamentoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PrescripcionDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.SeguimientosPromedioInternacionDTO;

public interface ChartService extends GenericService {

	Set<SeguimientosPromedioInternacionDTO> avgSeguimientos();
	
	Set<CantidadIngresosDiagnosticoDTO> getCountDiagnosticoSintomatico();
	
	Set<CantidadIngresosDiagnosticoDTO> getCountDiagnosticoPresuntivo();

	List<PrescripcionDTO> listEndPrescriptionForHistory(Long id);
	
	Set<CantidadPrescripcionesMedicamentoDTO> cantidadPrescripcionesMedicamento();
	
	Long cantidadTotalPacientesAtendidos();
	
	Long cantidadInternacionesRealizadas();
	
	Long cantidadInternadosActualmente();

}
