package ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.CantidadIngresosDiagnosticoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.CantidadPorMesDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.CantidadPrescripcionesMedicamentoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.GenericPersistentClass;

public interface ChartRepository extends GenericRepository<GenericPersistentClass> {

	
	@Query(value = "SELECT (COUNT(s) / COUNT( DISTINCT hc.id))  " +
	           "FROM " +
	           "    HistoriaClinica hc "
	           + "LEFT JOIN hc.seguimientos s " 
	           )
	Long avgSeguimientosInternacion();
	
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

	@Query(value= "SELECT COUNT( DISTINCT dni ) FROM Paciente")
	Long cantidadTotalPacientesAtendidos();

	@Query(value= "SELECT COUNT(*) FROM IngresoPaciente")
	Long cantidadInternacionesRealizadas();

	@Query(value= "SELECT COUNT(*) FROM HistoriaClinica hc WHERE egreso IS NULL")
	Long cantidadInternadosActualmente();
	
	
	@Query(value= "SELECT new ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.CantidadPorMesDTO(" 
			+ "COUNT(*), MONTH(e.fecha)) FROM Egreso e GROUP BY MONTH(e.fecha) ORDER BY MONTH(e.fecha)"
			)
	List<CantidadPorMesDTO> cantidadEgresosPorMes();

	@Query(value= "SELECT new ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.CantidadPorMesDTO(" 
			+ "COUNT(*), MONTH(s.fecha)) FROM Seguimiento s GROUP BY MONTH(s.fecha) ORDER BY MONTH(s.fecha)"
			)
	List<CantidadPorMesDTO> cantidadSeguimientosPorMes();

	
	@Query(value= "SELECT new ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.CantidadPorMesDTO(" 
			+ "COUNT(*), MONTH(i.fechaIngreso)) FROM IngresoPaciente i GROUP BY MONTH(i.fechaIngreso) ORDER BY MONTH(i.fechaIngreso)"
			)
	List<CantidadPorMesDTO> cantidadIngresosPorMes();


}

