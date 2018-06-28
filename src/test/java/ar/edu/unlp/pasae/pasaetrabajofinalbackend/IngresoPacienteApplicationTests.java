package ar.edu.unlp.pasae.pasaetrabajofinalbackend;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.IngresoPacienteService;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class IngresoPacienteApplicationTests {
	
	@Autowired
	private IngresoPacienteService ingresoService;
	
	@Test
	public void create() {
		IngresoPacienteDTO ingreso = new IngresoPacienteDTO(1L, "motivoConsulta", "enfermedadActual", "diagnosticoSintomatico", "diagnosticoPresuntivo");
		this.getIngresoService().create(ingreso);
		IngresoPacienteDTO retrive = (IngresoPacienteDTO) ingresoService.retrive(1L);
		Assert.assertEquals("diagnosticoPresuntivo", retrive.getDiagnosticoPresuntivo());
	}
	
	public IngresoPacienteService getIngresoService() {
		return ingresoService;
	}

	public void setIngresoService(IngresoPacienteService personService) {
		this.ingresoService = personService;
	}
	
}


