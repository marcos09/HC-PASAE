package ar.edu.unlp.pasae.pasaetrabajofinalbackend;
import org.springframework.stereotype.Component;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.IngresoPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

@Component
public class AppStartupRunner implements ApplicationRunner {

	@Autowired
	private IngresoPacienteRepository ingresoRepository;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.getIngresoRepository().save(new IngresoPaciente(1L, "motivo1", "enfermedad 1", "diagostico sintomático1", "diagnostico presuntivo 1"));
		this.getIngresoRepository().save(new IngresoPaciente(2L, "motivo2", "enfermedad 2", "diagostico sintomático2", "diagnostico presuntivo 2"));
		this.getIngresoRepository().save(new IngresoPaciente(3L, "motivo3", "enfermedad 3", "diagostico sintomático3", "diagnostico presuntivo 3"));
	}

	public IngresoPacienteRepository getIngresoRepository() {
		return ingresoRepository;
	}

	public void setIngresoRepository(IngresoPacienteRepository ingresoRepository) {
		this.ingresoRepository = ingresoRepository;
	}
	
	
}
