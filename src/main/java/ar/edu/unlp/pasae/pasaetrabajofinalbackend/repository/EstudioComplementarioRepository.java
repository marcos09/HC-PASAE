package ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.EstudioComplementario;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Paciente;


public interface EstudioComplementarioRepository extends GenericRepository<EstudioComplementario> {

	List<EstudioComplementario> findByInformeResultadoIsNull();

	  @Query("select hc.paciente from HistoriaClinica hc where   "
		+ " hc.seguimientos in "
  		+ "(select s from Seguimiento s where ?1 in s.estudiosComplementarios) ")
	  Paciente findPacienteFromEstudio(EstudioComplementario e);
	/*  
  		
  	*/

}
