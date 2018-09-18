package ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository;

import java.util.List;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Patologia;

public interface PatologiasRepository extends GenericRepository<Patologia>{
	List<Patologia> findByDisponibleIsTrue();
}
