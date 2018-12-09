package ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.CantidadIngresosDiagnosticoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.CantidadPrescripcionesMedicamentoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.SeguimientosPromedioInternacionDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.GenericPersistentClass;

public interface ChartsRepository extends GenericRepository<GenericPersistentClass> {

	
	@Query(value = "SELECT " +
	           "    new ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.SeguimientosPromedioInternacionDTO("
	           + "COUNT( DISTINCT hc.id), (COUNT(s) / COUNT( DISTINCT hc.id) ) )" +
	           "FROM " +
	           "    HistoriaClinica hc "
	           + "LEFT JOIN hc.seguimientos s " 
	           )
	Set<SeguimientosPromedioInternacionDTO> avgSeguimientosInternacion();
	
	@Query(value= "SELECT "
			+ "new ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.CantidadPrescripcionesMedicamentoDTO("
			+ "p.medicamento.nombre, COUNT(*))"
			+ "FROM Prescripcion p "
			+ "GROUP BY medicamento")
	Set<CantidadPrescripcionesMedicamentoDTO> cantidadPrescripcionesPorMedicamento();

	@Query(value= "SELECT "
			+ "new ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.CantidadIngresosDiagnosticoDTO("
			+ "i.diagnosticoPresuntivo.nombre, COUNT(*))"
			+ "FROM IngresoPaciente i "
			+ "GROUP BY diagnosticoPresuntivo")
	Set<CantidadIngresosDiagnosticoDTO> cantidadIngresosPorDiagnosticoPresuntivo();

	@Query(value= "SELECT "
			+ "new ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.CantidadIngresosDiagnosticoDTO("
			+ "i.diagnosticoSintomatico.nombre, COUNT(*))"
			+ "FROM IngresoPaciente i "
			+ "GROUP BY diagnosticoSintomatico")
	Set<CantidadIngresosDiagnosticoDTO> cantidadIngresosPorDiagnosticoSintomatico();
	
}
