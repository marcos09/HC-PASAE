package ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;


public interface IngresoPacienteRepository extends GenericRepository<IngresoPaciente>{

	Optional<IngresoPaciente> findEstudioComplementarioById(Long id);
	
	@Query(value = "select new map(count(p) as cantidad, p.medicamento) from Prescripcion p group by p.medicamento")
	public List<?> reporteDiagnoticoAgrupados();

}