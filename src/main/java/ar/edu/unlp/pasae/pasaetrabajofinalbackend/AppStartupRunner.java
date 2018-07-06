package ar.edu.unlp.pasae.pasaetrabajofinalbackend;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.List;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Patologia;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.User;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.IngresoPacienteRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.PatologiasRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.UserRepository;

@Component
public class AppStartupRunner implements ApplicationRunner {

	@Autowired
	private IngresoPacienteRepository ingresoRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PatologiasRepository patologiasRepository;

	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.getIngresoRepository().save(new IngresoPaciente(1L, "motivo1", "enfermedad 1", "diagostico sintomático1", "diagnostico presuntivo 1"));
		this.getIngresoRepository().save(new IngresoPaciente(2L, "motivo2", "enfermedad 2", "diagostico sintomático2", "diagnostico presuntivo 2"));
		this.getIngresoRepository().save(new IngresoPaciente(3L, "motivo3", "enfermedad 3", "diagostico sintomático3", "diagnostico presuntivo 3"));
		
		
		this.getUserRepository().save(new User(4L, "gmastro", "password", "mastronardi.gonzalo@gmail.com", "ROLE_STUDENT"));
		this.getUserRepository().save(new User(5L, "marcosmat", "password", "iriarte.marcos@gmail.com", "ROLE_STUDENT"));
		
		
		Patologia patologia1 = new Patologia(1L, null, null, "patologia padre", "padre de hija1,2");
		Patologia patologia2 = new Patologia(2L, patologia1, null, "patologia hija 1", "padre de subhija 1");
		Patologia patologia3 = new Patologia(3L, patologia1, null, "patologia hija 2", "SIN HIJOS");
		Patologia patologia4 = new Patologia(4L, patologia2, null, "patologia SUBhija 1", "padre de subhija 1");
		patologia2.addChild(patologia4);
		patologia1.addChild(patologia2);
		patologia1.addChild(patologia3);		
		
		this.getPatologiasRepository().save(patologia1);
		this.getPatologiasRepository().save(patologia2);
		this.getPatologiasRepository().save(patologia3);
		this.getPatologiasRepository().save(patologia4);
		
		List<Patologia> patologias = this.getPatologiasRepository().findAll();
		//public Patologia(Long id, Patologia father, Set<Patologia> childs, String nombre, String otroDato) {

	}

	public IngresoPacienteRepository getIngresoRepository() {
		return ingresoRepository;
	}

	public void setIngresoRepository(IngresoPacienteRepository ingresoRepository) {
		this.ingresoRepository = ingresoRepository;
	}
	
	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public PatologiasRepository getPatologiasRepository() {
		return patologiasRepository;
	}

	public void setPatologiasRepository(PatologiasRepository patologiasRepository) {
		this.patologiasRepository = patologiasRepository;
	}
	
	
	
}
