package ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository;

import java.util.List;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.HistoriaClinica;

public interface HistoriaClinicaRepository extends GenericRepository<HistoriaClinica> {

	List<HistoriaClinica> findByEgresoIsNull();

}
