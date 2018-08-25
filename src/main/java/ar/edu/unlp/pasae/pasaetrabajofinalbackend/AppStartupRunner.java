package ar.edu.unlp.pasae.pasaetrabajofinalbackend;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.controller.PacienteController;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Egreso;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.EstudioComplementario;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.HistoriaClinica;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Medicamento;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Paciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Patologia;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Prescripcion;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Seguimiento;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.EstudioComplementarioRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.HistoriaClinicaRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.IngresoPacienteRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.MedicamentoRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.PacienteRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.PatologiasRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.PrescripcionRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.UserRepository;

@Component
public class AppStartupRunner implements ApplicationRunner {

	@Autowired
	private IngresoPacienteRepository ingresoRepository;

	@Autowired
	private HistoriaClinicaRepository historiaRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PatologiasRepository patologiasRepository;

	@Autowired
	private EstudioComplementarioRepository estudioRepository;

	@Autowired
	private PrescripcionRepository prescripcionRepository;

	@Autowired
	private MedicamentoRepository medicamentosRepository;
	@Autowired
	private PacienteRepository pacientesRepository;
	

	@Override
	public void run(ApplicationArguments args) throws Exception {

		this.createHistoria();
		Medicamento med1 = new Medicamento("nombre", "indicacion", "contraindicacion");
		Medicamento med2 = new Medicamento("nombre2", "indicacion2", "contraindicacion2");
		Medicamento med3 = new Medicamento("nombre3", "indicacion2", "contraindicacion3");

		this.getMedicamentosRepository().save(med1);
		this.getMedicamentosRepository().save(med2);
		this.getMedicamentosRepository().save(med3);

		Prescripcion presc = new Prescripcion("1 comprimido cada 24 hs", med1);

		/*
		 * HashSet<Prescripcion> prescripcionesP1 = new HashSet<Prescripcion>();
		 * prescripcionesP1.add(presc); this.getPrescripcionRepository().save(presc);
		 * 
		 * Prescripcion prescripcion2 = new Prescripcion();
		 * prescripcion2.setMedicamento(med2);
		 * this.getPrescripcionRepository().save(prescripcion2);
		 * 
		 * IngresoPaciente i2 = new IngresoPaciente("motivo2", "enfermedad 2",
		 * "diagostico sintomático2", "diagnostico presuntivo 2");
		 * 
		 * IngresoPaciente i3 = new IngresoPaciente("motivo3", "enfermedad 3",
		 * "diagostico sintomático3", "diagnostico presuntivo 3");
		 * i3.addPrescripcion(prescripcion2);
		 */

		// this.getIngresoRepository().save(i2);
		// this.getIngresoRepository().save(i3);

		// this.getUserRepository().save(new User(4L, "gmastro",
		// "mastronardi.gonzalo@gmail.com", "ROLE_STUDENT"));
		// this.getUserRepository().save(new User(5L,
		// "marcosmat","iriarte.marcos@gmail.com", "ROLE_STUDENT"));

		
		Patologia patologia3 = new Patologia(3L, null, new HashSet<Patologia>(), "Patologia 3",
				"Patologias hijas:  4 y 5");
		Patologia patologia4 = new Patologia(4L, patologia3, new HashSet<Patologia>(), "Patologia 4",
				"Patologias hijas: 6");
		Patologia patologia5 = new Patologia(5L, patologia3, new HashSet<Patologia>(), "Patologia 5", "Sin hijos");
		Patologia patologia6 = new Patologia(6L, patologia4, new HashSet<Patologia>(), "Patologia 6", "Sin hijos");
		patologia3.addChild(patologia4);
		patologia3.addChild(patologia5);
		patologia4.addChild(patologia6);

		
		this.getPatologiasRepository().save(patologia3);
		this.getPatologiasRepository().save(patologia4);
		this.getPatologiasRepository().save(patologia5);
		this.getPatologiasRepository().save(patologia6);

		this.getIngresoRepository().save(new IngresoPaciente("motivo1", "enfermedad 1", patologia3, patologia4,
				"antecedentesEnfermedad", "antecedentesPersonales", "examenFisico"));

	
		
		/*
		 * Paciente paciente1 = new Paciente(11111111, false, null, null, "Juan Martín",
		 * "Gomez", "Calle falsa 123", 123123123); Paciente paciente2 = new
		 * Paciente(22222222, true, "OSDE", 743894823L, "Juan Martín", "Gomez",
		 * "Calle falsa 123", 123123123); Paciente paciente3 = new Paciente(33333333,
		 * true, "IOMA", 233333333402L, "Juan Martín", "Gomila", "Calle falsa 123",
		 * 123123123); Paciente paciente4 = new Paciente(12344556, true, "IOMA",
		 * 233333333402L, "Juan Martín", "Camila", "Calle falsa 123", 123123123);
		 * Paciente paciente5 = new Paciente(33344455, true, "IOMA", 233333333402L,
		 * "Juan Martín", "Perez ", "Calle falsa 123", 123123123); Paciente paciente6 =
		 * new Paciente(12345678, true, "IOMA", 233333333402L, "Juan Martín", "Perez 2",
		 * "Calle falsa 123", 123123123); Paciente paciente7 = new Paciente(98765432,
		 * true, "IOMA", 233333333402L, "Juan Martín", "Diaz Perez", "Calle falsa 123",
		 * 123123123); Paciente paciente8 = new Paciente(98712345, true, "IOMA",
		 * 233333333402L, "Juan Martín", "Pereyra", "Calle falsa 123", 123123123);
		 * 
		 * this.getPacientesRepository().save(paciente1);
		 * this.getPacientesRepository().save(paciente2);
		 * this.getPacientesRepository().save(paciente3);
		 * this.getPacientesRepository().save(paciente4);
		 * this.getPacientesRepository().save(paciente5);
		 * this.getPacientesRepository().save(paciente6);
		 * this.getPacientesRepository().save(paciente7);
		 * this.getPacientesRepository().save(paciente8);
		 */
	}

	// Método explicado en la última parte del documento introducción
	private void createHistoria() {

		Patologia patologia1 = new Patologia(1L, "Patologia padre", "Patologias hijas: 2");
		Patologia patologia2 = new Patologia(2L, patologia1, new HashSet<Patologia>(), "Patologia 2",
				"Sin hijos");
		patologia1.addChild(patologia2);
		this.getPatologiasRepository().save(patologia1);
		this.getPatologiasRepository().save(patologia2);

		IngresoPaciente ingreso = new IngresoPaciente("Motociclista accidentado en la vía pública",
				"Traumatismo severo de craneo, lesiones en manos, rodillas, pérdida del conocimiento.", patologia1,
				patologia2, "antecedentesEnfermedad", "antecedentesPersonales", "examenFisico");

		Paciente p = new Paciente(12345678, false, null, null, "Paciente historia nombre", "Apellido paciente historia",
				"Domicilio", "1321421");
		
		HistoriaClinica hc = new HistoriaClinica(ingreso);
		hc.setPaciente(p);
		

		Seguimiento seg1 = new Seguimiento("Seguimiento 1 sin estudios ni indicaciones",
				new HashSet<EstudioComplementario>(), new HashSet<Prescripcion>());

		// Creación del estudio para el seguimiento 2
		EstudioComplementario ec1 = new EstudioComplementario("TAC de craneo y cuello.");
		Set<EstudioComplementario> estudioTac = new HashSet<EstudioComplementario>();
		estudioTac.add(ec1);
		// Fin estudios seguimiento 2

		Seguimiento seg2 = new Seguimiento(
				"Seguimiento 2 con estudio TAC a resolverse después de que el estudio del seguimiento 3 haya sido resuelto.",
				estudioTac, new HashSet<Prescripcion>());

		// Estudios y prescripciónes del seguimiento 3
		Set<EstudioComplementario> estudioSeg3 = new HashSet<EstudioComplementario>();
		EstudioComplementario ec2 = new EstudioComplementario("Rx de rodilla y de mano derecha.");
		EstudioComplementario ec3 = new EstudioComplementario("RMN de cerebro con y sin gadolino");
		estudioSeg3.add(ec2);
		estudioSeg3.add(ec3);

		Medicamento med1 = new Medicamento("Ibuprofeno 600", "Indicaciones", "Contraindicaciones");
		Prescripcion p1 = new Prescripcion("Tomar un comprimido a las 18 hs", med1);
		Set<Prescripcion> prescSeg3 = new HashSet<Prescripcion>();
		prescSeg3.add(p1);
		// Fin complementos seguimiento 3

		Seguimiento seg3 = new Seguimiento(
				"Seguimiento 3 con 2 estudios (Rx y RMN) y una prescripción. La Rx se realiza antes del seguimiento 4 y la RMN "
						+ "continua pendiente de realización",
				estudioSeg3, prescSeg3);
		ec2.setInformeResultado(
				"Rotura de la primer falange del pulgar y la tercera del dedo índice, fisura de rodilla");
		ec1.setInformeResultado("El paciente está todo roto");
		p1.ejecutarPrescripcion();

		// Prescripciones seguimiento 4
		Medicamento med2 = new Medicamento("Morfina 12mg", "Indicaciones", "Contraindicaciones");
		Prescripcion p2 = new Prescripcion("Única dosis", med2);
		Set<Prescripcion> prescSeg4 = new HashSet<Prescripcion>();
		prescSeg4.add(p2);
		// Fin prescripciones seguimiento 4

		Seguimiento seg4 = new Seguimiento("Seguimiento 4 con una prescripcion de morfina.",
				new HashSet<EstudioComplementario>(), prescSeg4);

		hc.addSeguimiento(seg1);
		hc.addSeguimiento(seg2);
		hc.addSeguimiento(seg3);
		hc.addSeguimiento(seg4);

		Egreso egreso = new Egreso(
				"Murio a causa de un derrame cerebral producto del fuerte golpe recibido en el cráneo");
		hc.setEgreso(egreso);

		this.getMedicamentosRepository().save(med1);
		this.getMedicamentosRepository().save(med2);
		// this.getIngresoRepository().save(ingreso);
		this.getHistoriaRepository().save(hc);
		Date date = new Date();
		Date date1 = new Date();
		Date date2 = new Date();
		System.out.println(date.toString());
		System.out.println(date1.toString());
		System.out.println(date2.toString());

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

	public MedicamentoRepository getMedicamentosRepository() {
		return medicamentosRepository;
	}

	public void setMedicamentosRepository(MedicamentoRepository medicamentosRepository) {
		this.medicamentosRepository = medicamentosRepository;
	}

	public PacienteRepository getPacientesRepository() {
		return pacientesRepository;
	}

	public void setPacientesRepository(PacienteRepository pacientesRepository) {
		this.pacientesRepository = pacientesRepository;
	}

	public HistoriaClinicaRepository getHistoriaRepository() {
		return historiaRepository;
	}

	public void setHistoriaRepository(HistoriaClinicaRepository historiaRepository) {
		this.historiaRepository = historiaRepository;
	}
}
