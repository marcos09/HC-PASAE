package ar.edu.unlp.pasae.pasaetrabajofinalbackend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PatologiaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Paciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.exception.BaseException;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.EstudioComplementarioService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.IngresoPacienteService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.PacienteService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.PatologiasService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.PrescripcionService;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional
@Rollback(true)
public class HCApplicationTests {

	@Autowired
	private IngresoPacienteService ingresoService;

	@Autowired
	private EstudioComplementarioService estudioService;

	@Autowired
	private PrescripcionService prescripcionService;

	@Autowired
	private PatologiasService patologiaService;

	@Autowired
	private PacienteService pacienteService;

	public PacienteService getPacienteService() {
		return pacienteService;
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void createAndFindPatientByDNI() throws BaseException {

		int dni = 37423161;

		PacienteDTO request = new PacienteDTO(dni, true, "OSPE", (long) 112806, "Gonzalo", "Mastronardi", "Calle 71",
				"4555555");

		this.getPacienteService().create(request);

		PacienteDTO paciente = this.getPacienteService().findByDni(dni);

		Assert.assertNotNull(paciente);
		Assert.assertEquals(dni, paciente.getDni());
		Assert.assertEquals("OSPE", paciente.getObraSocialNombre());
		Assert.assertEquals("Gonzalo", paciente.getNombre());
		Assert.assertEquals("Mastronardi", paciente.getApellido());
		Assert.assertEquals("Calle 71", paciente.getDomicilio());

	}

	@Test
	public void throwExceptionIfPacientDoesntExist() {

		int dni = 99999999;

		try {
			this.getPacienteService().findByDni(dni);
		} catch (BaseException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void createAndFindPatientBySurnameContaining() throws BaseException {

		String surname = "Mastronardi";

		PacienteDTO request = new PacienteDTO(37423161, true, "OSPE", (long) 112806, "Gonzalo", surname, "Calle 71",
				"4555555");

		this.getPacienteService().create(request);

		List<PacienteDTO> pacientesList = this.getPacienteService().findByApellidoContaining(surname);
		PacienteDTO paciente = pacientesList.get(0);

		Assert.assertNotNull(paciente);
		Assert.assertEquals(37423161, paciente.getDni());
		Assert.assertEquals("OSPE", paciente.getObraSocialNombre());
		Assert.assertEquals("Gonzalo", paciente.getNombre());
		Assert.assertEquals(surname, paciente.getApellido());
		Assert.assertEquals("Calle 71", paciente.getDomicilio());

	}

	@Test
	public void deletePatient() throws BaseException {

		PacienteDTO request = new PacienteDTO(37423161, true, "OSPE", (long) 112806, "Matias", "Butti", "Calle 50",
				"4555555");

		Long patientID = this.getPacienteService().create(request).getId();

		PacienteDTO paciente;

		paciente = this.getPacienteService().retrive(patientID);
		Assert.assertNotNull(paciente);

		this.getPacienteService().delete(patientID);

		thrown.expect(BaseException.class);

		paciente = this.getPacienteService().retrive(patientID);
		Assert.assertNull(paciente);

	}

	@Test
	public void updatePatologia() throws BaseException {

		PatologiaDTO request = new PatologiaDTO("Nombre", "Otro Dato");

		Long patologiaId = this.getPatologiaService().create(request).getId();

		String updatedName = "New Name";
		
		PatologiaDTO updatedRequest = this.getPatologiaService().retrive(patologiaId);
		
		updatedRequest.setNombre(updatedName);

		this.getPatologiaService().update(updatedRequest);

		PatologiaDTO updatedPatologia = this.getPatologiaService().retrive(patologiaId);

		Assert.assertNotNull(updatedPatologia);
		Assert.assertEquals(updatedName, updatedPatologia.getNombre());
		Assert.assertNotEquals(request.getNombre(), updatedPatologia.getNombre());

	}
	
	@Test
	public void throwExceptionIfPatologyHasEmptyName() {
		
		String nombre = "";

		PatologiaDTO request = new PatologiaDTO(nombre, "Otro Dato");

		try {
			this.getPatologiaService().create(request);
		} catch (BaseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void patologiaList() throws BaseException {

		List <PatologiaDTO> patologiasList = new ArrayList<PatologiaDTO>();
		Assert.assertTrue("True", patologiasList.isEmpty());

	}
	
	@Test
	public void createIngreso() throws BaseException {
		
		
		PatologiaDTO patologiaDTO = new PatologiaDTO("Nombre", "Otro Dato");
		this.getPatologiaService().create(patologiaDTO);
		
		IngresoPacienteDTO ingresoDTO = new IngresoPacienteDTO( null,"Motociclista accidentado en la vía pública",
				"Traumatismo severo de craneo, lesiones en manos, rodillas, pérdida del conocimiento.", patologiaDTO,
				patologiaDTO, "antecedentesEnfermedad", "antecedentesPersonales", "examenFisico", new Date());
		
//		IngresoPacienteDTO ingresoDTO = new IngresoPacienteDTO();
//		ingresoDTO.setAntecedentesEnfermedad("antecedentes enfermedad");
//		ingresoDTO.setAntecedentesPersonales("antecedentes personales");
//		ingresoDTO.setDiagnosticoPresuntivo(patologiaDTO);
//		ingresoDTO.setDiagnosticoSintomatico(patologiaDTO);
//		ingresoDTO.setEnfermedadActual("enfermedad actual");
//		ingresoDTO.setExamenFisico("examen fisico");
//		ingresoDTO.setMotivoConsulta("motivo consulta");
		
		PacienteDTO pacienteDTO = new PacienteDTO(37423111, false, null, null, "Nombre", "Apellido",
				"Domicilio", "1321421");
		
		Long patientID = this.getPacienteService().create(pacienteDTO).getId();	
		
		try {
			this.getIngresoService().create(ingresoDTO, patientID);	
		}catch (BaseException e) {
			e.printStackTrace();
		}
		
		

	}
	
	

	public IngresoPacienteService getIngresoService() {
		return ingresoService;
	}

	public void setIngresoService(IngresoPacienteService personService) {
		this.ingresoService = personService;
	}

	public EstudioComplementarioService getEstudioService() {
		return estudioService;
	}

	public void setEstudioService(EstudioComplementarioService estudioService) {
		this.estudioService = estudioService;
	}

	public PrescripcionService getPrescripcionService() {
		return prescripcionService;
	}

	public void setPrescripcionService(PrescripcionService prescripcionService) {
		this.prescripcionService = prescripcionService;
	}

	public PatologiasService getPatologiaService() {
		return patologiaService;
	}

	public void setPatologiaService(PatologiasService patologiaService) {
		this.patologiaService = patologiaService;
	}

}
