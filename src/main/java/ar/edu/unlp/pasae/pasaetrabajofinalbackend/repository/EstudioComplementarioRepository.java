package ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.EstudioComplementario;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Paciente;


public interface EstudioComplementarioRepository extends GenericRepository<EstudioComplementario> {

	List<EstudioComplementario> findByInformeResultadoIsNull();

//	  @Query(value = "select hc.paciente from Historia_Clinica hc where   "
//		+ " hc.seguimientos in "
//  		+ "(select s from Seguimiento s where :ec in (select * from Seguimiento.estudiosComplementarios)) ", nativeQuery = true)
	  @Query(value = "SELECT p FROM HistoriaClinica hc LEFT JOIN hc.paciente p "
	  		+ "LEFT JOIN hc.seguimientos s LEFT JOIN  hc.ingreso.estudiosComplementarios iec WHERE s IN "
	  		+ "(SELECT s FROM Seguimiento s INNER JOIN s.estudiosComplementarios e WHERE e IN"
	  		+ "(SELECT ec FROM EstudioComplementario ec WHERE ec.id = ?1)) "
	  		+ "OR iec IN (SELECT ec FROM EstudioComplementario ec WHERE ec.id = ?1)")
	  Paciente findPacienteFromEstudio(Long ec1);
	/*  
  		
  	*/

}
