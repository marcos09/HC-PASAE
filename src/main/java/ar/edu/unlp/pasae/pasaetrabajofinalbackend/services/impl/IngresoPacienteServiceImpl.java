package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.GenericRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.IngresoPacienteRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.IngresoPacienteService;

@Service
public class IngresoPacienteServiceImpl extends GenericServiceImpl implements IngresoPacienteService{
	
	@Autowired
	private IngresoPacienteRepository repository;

	
	public GenericRepository<IngresoPaciente, Long> getRepository() {
		return (GenericRepository<IngresoPaciente, Long>) repository;
	}
	
	
	public IngresoPacienteServiceImpl() {
		super();
	}

	public void setRepository(IngresoPacienteRepository repository) {
		this.repository = repository;
	}

	//Prueba para ver si funciona el aspecto que convierte las excepciones no manejadas
//	@Override
//	public void thowException() throws BaseException {
//		throw new RuntimeException("Excepción runtime");
//	}

	
}
