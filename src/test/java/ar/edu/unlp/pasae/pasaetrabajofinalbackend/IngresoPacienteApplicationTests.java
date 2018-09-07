package ar.edu.unlp.pasae.pasaetrabajofinalbackend;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.EstudioComplementarioDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PatologiaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PrescripcionDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.EstudioComplementarioService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.IngresoPacienteService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.PatologiasService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.PrescripcionService;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class IngresoPacienteApplicationTests {
	
	@Autowired
	private IngresoPacienteService ingresoService;
	
	@Autowired
	private EstudioComplementarioService estudioService;
	
	@Autowired
	private PrescripcionService prescripcionService;
	
	@Autowired
	private PatologiasService patologiaService;
	
	@Test
	public void create() {
		
		/*
		 * 
		 * 
		EstudioComplementarioDTO estudio1 = new EstudioComplementarioDTO();
		this.getEstudioService().create(estudio1);
		PrescripcionDTO prescripcion1 = new PrescripcionDTO();
		this.getPrescripcionService().create(prescripcion1);
		Date fecha = new Date();
		PatologiaDTO patologia1 = new PatologiaDTO("Patologia x");
		this.getPatologiaService().create(patologia1);
		IngresoPacienteDTO ingreso = new IngresoPacienteDTO(1L, "motivoConsulta", "enfermedadActual", patologia1, patologia1, "antecedentesEnfermedad","antecedentesPersonales", "examenFisico", fecha );
		ingreso.addEstudio(estudio1);
		ingreso.addPrescripcion(prescripcion1);
		
		this.getIngresoService().create(ingreso);
		
		IngresoPacienteDTO retrive = (IngresoPacienteDTO) ingresoService.retrive(1L);
		Assert.assertEquals("diagnosticoPresuntivo", retrive.getDiagnosticoPresuntivo());
		
		*/
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


