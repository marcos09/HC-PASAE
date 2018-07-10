package ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;

@Repository
public interface IngresoPacienteRepository extends GenericRepository<IngresoPaciente,Long>{
	
}