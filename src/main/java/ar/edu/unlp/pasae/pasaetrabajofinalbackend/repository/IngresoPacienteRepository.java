package ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngresoPacienteRepository extends JpaRepository<IngresoPaciente,Long>{

}