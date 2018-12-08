package ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.SeguimientosPromedioInternacionDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.HistoriaClinica;

public interface chartsRepository extends GenericRepository<HistoriaClinica> {

	
	@Query(value = "SELECT " +
	           "    new ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.SeguimientosPromedioInternacionDTO(COUNT( DISTINCT hc.id), (COUNT(s) / COUNT( DISTINCT hc.id) ) )" +
	           "FROM " +
	           "    HistoriaClinica hc "
	           + "LEFT JOIN hc.seguimientos s " 
//	           +
//	           "GROUP BY " +
//	           "    hc.id"
	           )
	Set<SeguimientosPromedioInternacionDTO> avgSeguimientosInternacion();
	
}
