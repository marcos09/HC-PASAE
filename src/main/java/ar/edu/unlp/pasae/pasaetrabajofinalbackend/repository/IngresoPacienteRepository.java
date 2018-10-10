package ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository;

import java.util.Optional;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;


public interface IngresoPacienteRepository extends GenericRepository<IngresoPaciente>{

	Optional<IngresoPaciente> findEstudioComplementarioById(Long id);
	
}