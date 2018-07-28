package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PrescripcionDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Prescripcion;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.PrescripcionRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.PrescripcionService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.Transformer;

@Service
@Transactional

public class PrescripcionServiceImpl implements PrescripcionService {

	@Autowired
	private PrescripcionRepository repository;
	
	@Autowired
	private Transformer<Prescripcion, PrescripcionDTO> transformer;

	@Override
	public void create(PrescripcionDTO persistentDTO) {
		this.getRepository().save(this.getTransformer().toEntity(persistentDTO));
	}

	@Override
	public void update(PrescripcionDTO dto) {
		// TODO Auto-generated method stub
		Optional<Prescripcion> op = this.getRepository().findById(dto.getId());
		Prescripcion p = op.get();
		p.setDatos(dto.getDatos());
		p.setFecha(dto.getFecha());
		this.getRepository().save(p);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		this.getRepository().deleteById(id);
	}

	@Override
	public PrescripcionDTO retrive(Long id) {
		// TODO Auto-generated method stub
		return this.getTransformer().toDTO(this.getRepository().findById(id).get());
	}

	@Override
	public List<PrescripcionDTO> list() {
		// TODO Auto-generated method stub
		return this.getTransformer().toListDTO(this.getRepository().findAll());
	}

	public PrescripcionRepository getRepository() {
		return repository;
	}

	public Transformer<Prescripcion, PrescripcionDTO> getTransformer() {
		return transformer;
	}

	public void setRepository(PrescripcionRepository repository) {
		this.repository = repository;
	}

	public void setTransformer(Transformer<Prescripcion, PrescripcionDTO> transformer) {
		this.transformer = transformer;
	}

}
