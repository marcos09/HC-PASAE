package ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.HistoriaClinica;

public interface HistoriaClinicaRepository extends GenericRepository<HistoriaClinica> {

	List<HistoriaClinica> findByEgresoIsNull();
	
	  @Query("select hc from HistoriaClinica hc where hc.paciente.dni = ?1 and hc.egreso is null")
	  Optional<HistoriaClinica> findByDniAndEgresoIsNull(int dni);

}
