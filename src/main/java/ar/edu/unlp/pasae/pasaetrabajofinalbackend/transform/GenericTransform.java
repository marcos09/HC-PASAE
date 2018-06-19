package ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform;

import org.springframework.stereotype.Component;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.UserDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.User;

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

	@Override
	public UserDTO getUserDTO(User user) {
		// TODO Auto-generated method stub
		return new UserDTO(user.getId(), user.getUsername(), user.getPassword(), user.getEmail());
	}

	@Override
	public User getUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return new User(userDTO.getId(), userDTO.getUsername(), userDTO.getPassword(), userDTO.getEmail());
	}


}
