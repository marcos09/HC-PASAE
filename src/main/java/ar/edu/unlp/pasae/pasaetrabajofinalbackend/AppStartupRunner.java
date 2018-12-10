package ar.edu.unlp.pasae.pasaetrabajofinalbackend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

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
		this.createHistoria2();
		this.createHistoria3();
		Medicamento med1 = new Medicamento("Enarapril", "Antihipertensivo", "contraindicacion");
		Medicamento med2 = new Medicamento("Losartan", "Antihipertensivo", "contraindicacion2");
		Medicamento med3 = new Medicamento("metformina", "Diabetes", "contraindicacion3");
		Medicamento med4 = new Medicamento("Carvedilol", "Cardiaco", "contraindicacion3");
		Medicamento med5 = new Medicamento("Aspirina", "Cardiovascular", "contraindicacion3");
		Medicamento med6 = new Medicamento("Amoxicilina", "Antibiotico", "contraindicacion3");
		Medicamento med7 = new Medicamento("Esomeptrazol", "Gastritis", "contraindicacion3");
		Medicamento med8 = new Medicamento("Propinox", "Antiespasmodico", "contraindicacion3");
		
		this.getMedicamentosRepository().save(med1);
		this.getMedicamentosRepository().save(med2);
		this.getMedicamentosRepository().save(med3);
		this.getMedicamentosRepository().save(med4);
		this.getMedicamentosRepository().save(med5);
		this.getMedicamentosRepository().save(med6);
		this.getMedicamentosRepository().save(med7);
		this.getMedicamentosRepository().save(med8);

		// Prescripcion presc = new Prescripcion("1 comprimido cada 24 hs", med1);

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

		
		
		Patologia patologia3 = new Patologia("Amioplasia", "Otro dato");
		Patologia patologia4 = new Patologia("Síndrome de down", "Dato Random");
		Patologia patologia5 = new Patologia("Artrosis", "Otro dato");
		Patologia patologia6 = new Patologia("Edema pulmonar", "Dato random");
		Patologia patologia7 = new Patologia("Hipertrofia ventricular", "Dato random");
		Patologia patologia8 = new Patologia("Aneurisma", "Dato random");
		Patologia patologia9 = new Patologia("Angiopatia", "Dato random");
		Patologia patologia10 = new Patologia("Lepra", "Dato random");
		Patologia patologia11 = new Patologia("Sífilis 6", "Dato random");
		Patologia patologia12 = new Patologia("Hepatitis", "Dato random");
		Patologia patologia13 = new Patologia("Hemiplegia", "Dato random");
		

		this.getPatologiasRepository().save(patologia3);
		this.getPatologiasRepository().save(patologia4);
		this.getPatologiasRepository().save(patologia5);
		this.getPatologiasRepository().save(patologia6);
		this.getPatologiasRepository().save(patologia7);
		this.getPatologiasRepository().save(patologia8);
		this.getPatologiasRepository().save(patologia9);
		this.getPatologiasRepository().save(patologia10);
		this.getPatologiasRepository().save(patologia11);
		this.getPatologiasRepository().save(patologia12);
		this.getPatologiasRepository().save(patologia13);

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
	private void createHistoria() throws ParseException {

		Patologia patologia1 = new Patologia("Traumatismo de craneo", "Datos");
		Patologia patologia2 = new Patologia("Cefalea", "Dato");

		this.getPatologiasRepository().save(patologia1);
		this.getPatologiasRepository().save(patologia2);

		IngresoPaciente ingreso = new IngresoPaciente("Motociclista accidentado en la vía pública",
				"Traumatismo severo de craneo, lesiones en manos, rodillas, pérdida del conocimiento.", patologia1,
				patologia2, "antecedentesEnfermedad", "antecedentesPersonales", "examenFisico");

		Date date;
		date = new SimpleDateFormat("yyy-MM-dd").parse("2018-11-19");
		ingreso.setFechaIngreso(date);
		
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

		Medicamento med0 = new Medicamento("Azitromicina 500", "Indicaciones", "Contraindicaciones");
		this.medicamentosRepository.save(med0);
		Prescripcion p0 = new Prescripcion("Unica dosis diaria");
		p0.setMedicamento(med0);
		
		Medicamento med1 = new Medicamento("Ibuprofeno 600", "Indicaciones", "Contraindicaciones");
		this.medicamentosRepository.save(med1);
		Prescripcion p1 = new Prescripcion("Tomar un comprimido a las 18 hs");
		p1.setMedicamento(med1);
		Set<Prescripcion> prescSeg3 = new HashSet<Prescripcion>();
		prescSeg3.add(p1);
		prescSeg3.add(p0);
		
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
		this.medicamentosRepository.save(med2);
		Prescripcion p2 = new Prescripcion("Única dosis");
		p2.setMedicamento(med2);
		
		Medicamento med3 = new Medicamento("Rifampicina", "Indicaciones", "Contraindicaciones");
		this.medicamentosRepository.save(med3);
		Prescripcion p3 = new Prescripcion("Única dosis");
		p3.setMedicamento(med3);
		
		Prescripcion p4 = new Prescripcion("1 cada 12 hs");
		p4.setMedicamento(med1);
		
		Set<Prescripcion> prescSeg4 = new HashSet<Prescripcion>();
		prescSeg4.add(p2);
		prescSeg4.add(p3);
		prescSeg4.add(p4);
		// Fin prescripciones seguimiento 4

		Seguimiento seg4 = new Seguimiento("Seguimiento 4 con una prescripcion de morfina.",
				new HashSet<EstudioComplementario>(), prescSeg4);

		hc.addSeguimiento(seg1);
		hc.addSeguimiento(seg2);
		hc.addSeguimiento(seg3);
		hc.addSeguimiento(seg4);
		
		 Egreso egreso = new Egreso("Fin de la internacion");
		 Date date2;
			
		date2 = new SimpleDateFormat("yyy-MM-dd").parse("2018-11-27");
		 
//		 egreso.setFecha(date2);
//		 hc.setEgreso(egreso);

		// this.getMedicamentosRepository().save(med1);
		// this.getMedicamentosRepository().save(med2);
		// this.getIngresoRepository().save(ingreso);
		this.getHistoriaRepository().save(hc);
	}

	
	
	
	public void createHistoria2() throws ParseException {

		Patologia patologia1 = new Patologia("Cancer de pulmón", "Datos");

		this.getPatologiasRepository().save(patologia1);

		IngresoPaciente ingreso = new IngresoPaciente("Paciente con cancer de pulmon",
				"Cancer.", patologia1,
				patologia1, "antecedentesEnfermedad", "antecedentesPersonales", "examenFisico");
		
//		LocalDate date = LocalDate.parse("2018-11-22");
		Date date;
		
		date = new SimpleDateFormat("yyy-MM-dd").parse("2018-11-22");
		ingreso.setFechaIngreso(date);
	
		
		
		
		
		Paciente p = new Paciente(12345678, false, null, null, "Paciente historia nombre", "Apellido paciente historia",
				"Domicilio", "1321421");

		HistoriaClinica hc = new HistoriaClinica(ingreso);
		hc.setPaciente(p);

		Seguimiento seg1 = new Seguimiento("Seguimiento 1 sin estudios ni indicaciones",
				new HashSet<EstudioComplementario>(), new HashSet<Prescripcion>());
		seg1.setFecha(date);
		
		
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

		Medicamento med0 = new Medicamento("Cefixima", "Indicaciones", "Contraindicaciones");
		this.medicamentosRepository.save(med0);
		Prescripcion p0 = new Prescripcion("Una dosis diaria");
		p0.setMedicamento(med0);
		
		Medicamento med1 = new Medicamento("Doxicilina", "Indicaciones", "Contraindicaciones");
		this.medicamentosRepository.save(med1);
		Prescripcion p1 = new Prescripcion("Tomar un comprimido a las 18 hs");
		p1.setMedicamento(med1);
		
		
		Set<Prescripcion> prescSeg3 = new HashSet<Prescripcion>();
		prescSeg3.add(p1);
		prescSeg3.add(p0);
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
		Medicamento med2 = new Medicamento("Paracetamol", "Indicaciones", "Contraindicaciones");
		this.medicamentosRepository.save(med2);
		Prescripcion p2 = new Prescripcion("Única dosis");
		p2.setMedicamento(med2);
		Set<Prescripcion> prescSeg4 = new HashSet<Prescripcion>();
		
		Medicamento med3 = new Medicamento("Levamisol", "Indicaciones", "Contraindicaciones");
		this.medicamentosRepository.save(med3);
		Prescripcion p3 = new Prescripcion("1x6");
		p3.setMedicamento(med3);
		
		Medicamento med4 = new Medicamento("Lidocaina", "Indicaciones", "Contraindicaciones");
		this.medicamentosRepository.save(med4);
		Prescripcion p4 = new Prescripcion("Uno cada 12");
		p4.setMedicamento(med4);
		
		Prescripcion p5 = new Prescripcion("Única dosis");
		p5.setMedicamento(med2);
		prescSeg4.add(p2);
		prescSeg4.add(p3);
		prescSeg4.add(p4);
		prescSeg4.add(p5);
		// Fin prescripciones seguimiento 4

		Seguimiento seg4 = new Seguimiento("Seguimiento 4 con una prescripcion de morfina.",
				new HashSet<EstudioComplementario>(), prescSeg4);

		hc.addSeguimiento(seg1);
		hc.addSeguimiento(seg2);
		hc.addSeguimiento(seg3);
		hc.addSeguimiento(seg4);

		 Egreso egreso = new Egreso("Murio a causa de un derrame cerebral producto del fuerte golpe recibido en el cráneo");
		 Date date2;
			
		date2 = new SimpleDateFormat("yyy-MM-dd").parse("2018-11-29");
		 
		 egreso.setFecha(date);
		 hc.setEgreso(egreso);

		// this.getMedicamentosRepository().save(med1);
		// this.getMedicamentosRepository().save(med2);
		// this.getIngresoRepository().save(ingreso);
		this.getHistoriaRepository().save(hc);
	}

	
	public void createHistoria3() throws ParseException {

		Patologia patologia1 = new Patologia("Fractura", "Datos");

		this.getPatologiasRepository().save(patologia1);

		IngresoPaciente ingreso = new IngresoPaciente("Paciente con fractura de femur",
				"Cancer.", patologia1,
				patologia1, "antecedentesEnfermedad", "antecedentesPersonales", "examenFisico");
		
//		LocalDate date = LocalDate.parse("2018-11-22");
		Date date;
		
		date = new SimpleDateFormat("yyy-MM-dd").parse("2018-10-19");
		ingreso.setFechaIngreso(date);
	
		
		
		
		
		Paciente p = new Paciente(12345678, false, null, null, "Matias", "Martin",
				"Domicilio", "1321421");

		HistoriaClinica hc = new HistoriaClinica(ingreso);
		hc.setPaciente(p);

		Seguimiento seg1 = new Seguimiento("Nuevo seguimiento",
				new HashSet<EstudioComplementario>(), new HashSet<Prescripcion>());
		seg1.setFecha(date);
		
		
		// Creación del estudio para el seguimiento 2
		EstudioComplementario ec1 = new EstudioComplementario("Radiografia completa");
		Set<EstudioComplementario> estudioTac = new HashSet<EstudioComplementario>();
		estudioTac.add(ec1);
		// Fin estudios seguimiento 2

		Seguimiento seg2 = new Seguimiento(
				"Seguimiento 2",
				estudioTac, new HashSet<Prescripcion>());
		seg2.setFecha(date);

		// Estudios y prescripciónes del seguimiento 3
		Set<EstudioComplementario> estudioSeg3 = new HashSet<EstudioComplementario>();
		EstudioComplementario ec2 = new EstudioComplementario("Rx de rodilla y de mano derecha.");
		EstudioComplementario ec3 = new EstudioComplementario("Rx pierna izquierda");
		estudioSeg3.add(ec2);
		estudioSeg3.add(ec3);

		Medicamento med0 = new Medicamento("Doxicilina", "Indicaciones", "Contraindicaciones");
		this.medicamentosRepository.save(med0);
		Prescripcion p0 = new Prescripcion("Una dosis diaria");
		p0.setMedicamento(med0);
		
		Medicamento med1 = new Medicamento("Pirantes", "Indicaciones", "Contraindicaciones");
		this.medicamentosRepository.save(med1);
		Prescripcion p1 = new Prescripcion("Tomar un comprimido a las 18 hs");
		p1.setMedicamento(med1);
		
		Prescripcion p7 = new Prescripcion("Dosis diaria");
		p7.setMedicamento(med0);
		
		Prescripcion p8 = new Prescripcion("1 al dia");
		p8.setMedicamento(med0);
		
		Set<Prescripcion> prescSeg3 = new HashSet<Prescripcion>();
		prescSeg3.add(p1);
		prescSeg3.add(p0);
		prescSeg3.add(p8);
		prescSeg3.add(p7);
		// Fin complementos seguimiento 3

		Seguimiento seg3 = new Seguimiento(
				"Seguimiento 3 con 2 estudios (Rx y RMN) y una prescripción",
				estudioSeg3, prescSeg3);
		seg3.setFecha(date);
		ec2.setInformeResultado(
				"Fractura rodilla y femur");
		ec1.setInformeResultado("Rotisimo");
		p1.ejecutarPrescripcion();

		// Prescripciones seguimiento 4
		Medicamento med2 = new Medicamento("Etambutol", "Indicaciones", "Contraindicaciones");
		this.medicamentosRepository.save(med2);
		Prescripcion p2 = new Prescripcion("Única dosis");
		p2.setMedicamento(med2);
		Set<Prescripcion> prescSeg4 = new HashSet<Prescripcion>();
		
		Medicamento med3 = new Medicamento("Ritonavir", "Indicaciones", "Contraindicaciones");
		this.medicamentosRepository.save(med3);
		Prescripcion p3 = new Prescripcion("1x6");
		p3.setMedicamento(med3);
		
		Medicamento med4 = new Medicamento("Artemetero", "Indicaciones", "Contraindicaciones");
		this.medicamentosRepository.save(med4);
		Prescripcion p4 = new Prescripcion("Uno cada 12");
		p4.setMedicamento(med4);
		
		Prescripcion p5 = new Prescripcion("Única dosis");
		p5.setMedicamento(med2);
		prescSeg4.add(p2);
		prescSeg4.add(p3);
		prescSeg4.add(p4);
		prescSeg4.add(p5);
		// Fin prescripciones seguimiento 4

		Seguimiento seg4 = new Seguimiento("Seguimiento 4",
				new HashSet<EstudioComplementario>(), prescSeg4);
		seg4.setFecha(date);

		hc.addSeguimiento(seg1);
		hc.addSeguimiento(seg2);
		hc.addSeguimiento(seg3);
		hc.addSeguimiento(seg4);

		 Egreso egreso = new Egreso("Fin de la internacion");
		 Date date2;
			
		date2 = new SimpleDateFormat("yyy-MM-dd").parse("2018-10-27");
		 
		 egreso.setFecha(date2);
		 hc.setEgreso(egreso);

		// this.getMedicamentosRepository().save(med1);
		// this.getMedicamentosRepository().save(med2);
		// this.getIngresoRepository().save(ingreso);
		this.getHistoriaRepository().save(hc);
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
