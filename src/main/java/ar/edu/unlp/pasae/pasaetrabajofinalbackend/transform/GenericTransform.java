package ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform;

import org.springframework.stereotype.Component;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;

@Component
public class GenericTransform implements Transform{

	@Override
	public IngresoPacienteDTO getIngresoPacienteDTO(IngresoPaciente ingreso) {
		return new IngresoPacienteDTO(ingreso.getId(), ingreso.getMotivoConsulta(), ingreso.getEnfermedadActual(), ingreso.getDiagnosticoSintomatico(), ingreso.getDiagnosticoPresuntivo());
	
	}

	@Override
	public IngresoPaciente getIngresoPaciente(IngresoPacienteDTO ingreso) {
		return new IngresoPaciente(ingreso.getId(), ingreso.getMotivoConsulta(), ingreso.getEnfermedadActual(), ingreso.getDiagnosticoSintomatico(), ingreso.getDiagnosticoPresuntivo());
	}

}
