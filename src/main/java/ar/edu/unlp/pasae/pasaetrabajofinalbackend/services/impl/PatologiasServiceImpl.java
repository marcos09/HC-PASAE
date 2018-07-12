package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Patologia;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.GenericRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.PatologiasRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.PatologiasService;

@Service
public class PatologiasServiceImpl extends GenericServiceImpl implements PatologiasService{

	
	@Autowired
	private PatologiasRepository repository;

	public GenericRepository<Patologia, Long> getRepository() {
		return (GenericRepository<Patologia, Long>) repository;
	}

	public void setRepository(PatologiasRepository repository) {
		this.repository = repository;
	}
	
	

}