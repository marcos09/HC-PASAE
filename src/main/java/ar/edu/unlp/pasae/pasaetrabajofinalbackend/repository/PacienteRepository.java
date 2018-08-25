package ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository;

import java.util.Collection;
import java.util.Optional;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Paciente;

public interface PacienteRepository extends GenericRepository<Paciente> {


	Optional<Collection<Paciente>> findByApellidoContaining(String apellido);

	Paciente findByDni(int dni);
}
