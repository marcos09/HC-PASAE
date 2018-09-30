package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PatologiaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Patologia;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.PatologiasRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.PatologiasService;

@Service
@Transactional

public class PatologiasServiceImpl extends GenericServiceImpl<PatologiasRepository, Patologia, PatologiaDTO> implements PatologiasService {


	@Autowired
	private Validator validator;

	@Override
	public void create(PatologiaDTO dto) {
		Patologia ip = new Patologia(dto.getId(), dto.getNombre(), dto.getOtroDato(), true);
		Set<ConstraintViolation<Patologia>> validations = validator.validate(ip);// si esta vacio no hubieron errores de
																					// validacion
		if (validations.isEmpty()) {
			this.getRepository().save(ip);
		}

	}

	@Override
	public void update(PatologiaDTO dto) {
		// TODO Auto-generated method stub
		Optional<Patologia> op = this.getRepository().findById(dto.getId());
		Patologia p = op.get();
		p.setOtroDato(dto.getOtroDato());
		p.setNombre(dto.getNombre());
		this.getRepository().save(p);

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		Optional<Patologia> op = this.getRepository().findById(id);
		Patologia p = op.get();
		p.setDisponible(false);
		this.getRepository().save(p);

	}

	@Override
	public PatologiaDTO retrive(Long id) {
		// TODO Auto-generated method stub
		Patologia p = this.getRepository().findById(id).get();
		return this.getTransformer().toDTO(p);
	}

	@Override
	public List<PatologiaDTO> list() {
		// TODO Auto-generated method stub
		List<Patologia> list = this.getRepository().findByDisponibleIsTrue();
		return this.getTransformer().toListDTO(list);
	}

}