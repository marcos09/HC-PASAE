package ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform;

import java.util.Iterator;
import org.springframework.stereotype.Component;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.GenericDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PatologiaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.UserDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.GenericPersistentClass;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.GenericPersistentEntity;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Patologia;
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
		return new UserDTO(user.getId(), user.getUsername(), user.getEmail(), user.getAuthorities());
	}

	@Override
	public User getUser(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getUsername(), userDTO.getEmail(), userDTO.getAuthorities());
	}

	
	//Falta convertir los hijos de la patología y agregarlos al DTO
	@Override
	public PatologiaDTO getPatologiaDTO(Patologia patologia) {
		Patologia child;
		PatologiaDTO patologiaDTO = new PatologiaDTO();
		patologiaDTO.setId(patologia.getId());
		patologiaDTO.setNombre(patologia.getNombre());
		patologiaDTO.setOtroDato(patologia.getOtroDato());
		Iterator<Patologia> it = patologia.getChilds().iterator();
		while(it.hasNext()) {
			 child = it.next();
			 patologiaDTO.addChild(this.getPatologiaDTO(child));
		}
		Patologia father = patologia.getFather();
		if(father != null)
			patologiaDTO.setFather(this.getPatologiaDTO(father));
		
		return patologiaDTO ;
	}
	
	public Patologia getPatologia(PatologiaDTO patologiaDTO) {
		Patologia patologia = new Patologia(patologiaDTO.getId(), patologiaDTO.getNombre(), patologiaDTO.getOtroDato());
		
		if(patologiaDTO.getFather() != null)
			patologia.setFather(this.getPatologia(patologiaDTO.getFather()));
		Iterator<PatologiaDTO> it = patologiaDTO.getChilds().iterator();
		PatologiaDTO child;
		while(it.hasNext()) {
			 child = it.next();
			 patologia.addChild(this.getPatologia(child));
		}
		return patologia;
		
	}

	@Override
	public GenericDTO getEntityDTO(GenericPersistentEntity genericPersistentClass) {
		switch(genericPersistentClass.getClass().getName()) {
		case "ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente":
			return this.getIngresoPacienteDTO((IngresoPaciente) genericPersistentClass);
		case "ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Patologia":
			return this.getPatologiaDTO((Patologia) genericPersistentClass);
		case "ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.User":
			return this.getUserDTO((User) genericPersistentClass);
		default:
			return null;
		}
	}
	
	public GenericPersistentClass getEntity(GenericDTO genericDTO) {
		switch(genericDTO.getClass().getName()) {
		case "ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacientDTOe":
			return this.getIngresoPaciente((IngresoPacienteDTO) genericDTO);
		case "ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PatologiaDTO":
			return this.getPatologia((PatologiaDTO) genericDTO);
		case "ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.UserDTO":
			return this.getUser ((UserDTO) genericDTO);
		default:
			return null;
		}

	}

}
