package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PrescripcionDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Prescripcion;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.PrescripcionRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.PrescripcionService;

@Service
@Transactional

public class PrescripcionServiceImpl extends GenericServiceImpl<PrescripcionRepository, Prescripcion, PrescripcionDTO> implements PrescripcionService {
	
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
