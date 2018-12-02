package ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Prescripcion;


public interface PrescripcionRepository extends GenericRepository<Prescripcion> {

	List<Prescripcion> findByFechaAdministracionIsNull();
	
	@Query("select u from User u")
	List<Prescripcion> findPrescripctions();
}
