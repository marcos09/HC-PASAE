package ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository;

import java.util.List;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Prescripcion;


public interface PrescripcionRepository extends GenericRepository<Prescripcion> {

	List<Prescripcion> findByFechaAdministracionIsNull();
}
