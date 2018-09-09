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
		Optional<Prescripcion> op = this.getRepository().findById(dto.getId());
		Prescripcion p = op.get();
		p.setDatos(dto.getDatos());
		p.setFechaIndicacion(dto.getFechaIndicacion());
		this.getRepository().save(p);
	}

	@Override
	public void delete(Long id) {
		this.getRepository().deleteById(id);
	}

	@Override
	public PrescripcionDTO retrive(Long id) {
		return this.getTransformer().toDTO(this.getRepository().findById(id).get());
	}

	@Override
	public List<PrescripcionDTO> list() {
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

	@Override
	public List<PrescripcionDTO> listActivePrescriptions() {
		return this.getTransformer().toListDTO(this.getRepository().findByFechaAdministracionIsNull());
	}

	@Override
	public void aplicar(Long id) {
		Optional<Prescripcion> optional = this.getRepository().findById(id);
		if(optional.isPresent()) {
			Prescripcion p = optional.get();
			p.ejecutarPrescripcion();
			this.getRepository().save(p);
		}
		else {
			//Levantar excepcion
		}
		
	}

}
