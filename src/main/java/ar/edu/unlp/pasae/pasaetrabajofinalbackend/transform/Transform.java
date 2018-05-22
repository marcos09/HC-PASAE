package ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;

public interface Transform {
	public IngresoPacienteDTO getIngresoPacienteDTO(IngresoPaciente ingreso);
	public IngresoPaciente getIngresoPaciente(IngresoPacienteDTO ingreso);
}
