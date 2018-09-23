package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.SeguimientoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Seguimiento;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.SeguimientoRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.SeguimientoService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.SeguimientoTransformer;


@Service
public class SeguimientoServiceImpl implements SeguimientoService{

	@Autowired
	private SeguimientoRepository repository;

	@Autowired
	private SeguimientoTransformer seguimientoTransformer;

	public SeguimientoTransformer getSeguimientoTransformer() {
		return seguimientoTransformer;
	}


	public void setSeguimientoTransformer(SeguimientoTransformer seguimientoTransformer) {
		this.seguimientoTransformer = seguimientoTransformer;
	}


	public SeguimientoRepository getRepository() {
		return repository;
	}


	public void setRepository(SeguimientoRepository repository) {
		this.repository = repository;
	}


	public SeguimientoDTO retrive(Long id) {
		Optional<Seguimiento> optional = this.getRepository().findById(id);
		if(optional.isPresent()) {
			Seguimiento s = optional.get();
			return this.getSeguimientoTransformer().toDTO(s);
		}
		return null;
	}
}
