package ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PatologiaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.UserDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Patologia;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.User;

public interface Transform {
	public IngresoPacienteDTO getIngresoPacienteDTO(IngresoPaciente ingreso);
	public IngresoPaciente getIngresoPaciente(IngresoPacienteDTO ingreso);
	public UserDTO getUserDTO(User user);
	public User getUser(UserDTO userDTO);
	public PatologiaDTO getPatologiaDTO(Patologia patologia);
	public Patologia getPatologia(PatologiaDTO patologiaDTO);
}
