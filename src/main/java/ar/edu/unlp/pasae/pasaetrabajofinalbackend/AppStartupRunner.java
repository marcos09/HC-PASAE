package ar.edu.unlp.pasae.pasaetrabajofinalbackend;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.EstudioComplementario;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Patologia;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Prescripcion;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.EstudioComplementarioRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.IngresoPacienteRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.PatologiasRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.PrescripcionRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.UserRepository;

@Component
public class AppStartupRunner implements ApplicationRunner {

	@Autowired
	private IngresoPacienteRepository ingresoRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PatologiasRepository patologiasRepository;
	
	@Autowired
	private EstudioComplementarioRepository estudioRepository;
	
	@Autowired
	private PrescripcionRepository prescripcionRepository;

	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		EstudioComplementario estudio1 = new EstudioComplementario();
		EstudioComplementario estudio2 = new EstudioComplementario();
		EstudioComplementario estudio3 = new EstudioComplementario();
		EstudioComplementario estudio4 = new EstudioComplementario();
		HashSet<EstudioComplementario> estudiosP1 = new HashSet<EstudioComplementario>();
		estudiosP1.add(estudio1);
		estudiosP1.add(estudio4);
		this.getEstudioRepository().save(estudio1);
		this.getEstudioRepository().save(estudio2);
		this.getEstudioRepository().save(estudio3);
		this.getEstudioRepository().save(estudio4);
		
		Prescripcion prescripcion1 = new Prescripcion();
		HashSet<Prescripcion> prescripcionesP1 = new HashSet<Prescripcion>();
		prescripcionesP1.add(prescripcion1);
		this.getPrescripcionRepository().save(prescripcion1);
	
		Prescripcion prescripcion2 = new Prescripcion();
		this.getPrescripcionRepository().save(prescripcion2);
		
		IngresoPaciente i2 = new IngresoPaciente(2L, "motivo2", "enfermedad 2", "diagostico sintomático2", "diagnostico presuntivo 2");
		i2.addEstudio(estudio2);
		
		IngresoPaciente i3 = new IngresoPaciente(3L, "motivo3", "enfermedad 3", "diagostico sintomático3", "diagnostico presuntivo 3");
		i3.addEstudio(estudio3);
		i3.addPrescripcion(prescripcion2);
		
		this.getIngresoRepository().save(new IngresoPaciente(1L, "motivo1", "enfermedad 1", "diagostico sintomático1", "diagnostico presuntivo 1", estudiosP1,prescripcionesP1));
		this.getIngresoRepository().save(i2);
		this.getIngresoRepository().save(i3);
		
		
//		this.getUserRepository().save(new User(4L, "gmastro", "mastronardi.gonzalo@gmail.com", "ROLE_STUDENT"));
//		this.getUserRepository().save(new User(5L, "marcosmat","iriarte.marcos@gmail.com", "ROLE_STUDENT"));
		
		
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

	public EstudioComplementarioRepository getEstudioRepository() {
		return estudioRepository;
	}

	public void setEstudioRepository(EstudioComplementarioRepository estudioRepository) {
		this.estudioRepository = estudioRepository;
	}

	public PrescripcionRepository getPrescripcionRepository() {
		return prescripcionRepository;
	}

	public void setPrescripcionRepository(PrescripcionRepository prescripcionRepository) {
		this.prescripcionRepository = prescripcionRepository;
	}
	
	
	
	
	
}
