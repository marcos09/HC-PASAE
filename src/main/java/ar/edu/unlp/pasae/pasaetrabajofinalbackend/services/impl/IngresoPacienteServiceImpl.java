package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.GenericDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.IngresoPacienteRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.IngresoPacienteService;

@Service
public class IngresoPacienteServiceImpl implements IngresoPacienteService{
	
	@Autowired
	private IngresoPacienteRepository repository;

	public IngresoPacienteRepository getRepository() {
		return repository;
	}
	
	
	public IngresoPacienteServiceImpl() {
		super();
	}

	public void setRepository(IngresoPacienteRepository repository) {
		this.repository = repository;
	}

	@Override
	public void create(GenericDTO persistentDTO) {

	}

	@Override
	public void update(GenericDTO person) {

	}

	@Override
	public void delete(Long id) {
		
	}

	@Override
	public GenericDTO retrive(Long id) {
		return null;
	}

	@Override
	public List<GenericDTO> list() {
		return null;
	}
}
