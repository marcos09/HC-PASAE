package ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;

public interface GenericRepository extends JpaRepository<IngresoPaciente,Long> {
	
}
