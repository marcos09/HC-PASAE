package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.HistoriaClinicaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.HistoriaClinica;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.HistoriaClinicaRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.HistoriaClinicaService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.Transformer;

@Service
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService {

	@Autowired
	private HistoriaClinicaRepository repository;

	@Autowired
	private Transformer<HistoriaClinica, HistoriaClinicaDTO> transformer;

	@Autowired
	private Validator validator;

	@Override
	public void create(HistoriaClinicaDTO persistentDTO) {
		HistoriaClinica historia = new HistoriaClinica(this.getTransformer().toEntity(persistentDTO).getIngreso());
		Set<ConstraintViolation<HistoriaClinica>> validations = validator.validate(historia);// si esta vacio no
																								// hubieron errores de
																								// validacion
		if (validations.isEmpty()) {
			this.getRepository().save(historia);
		}
	}

	@Override
	public void update(HistoriaClinicaDTO persistentDTO) {
		Optional<HistoriaClinica> op = this.getRepository().findById(persistentDTO.getId());
		HistoriaClinica hc = op.get();
		hc.setEgreso(this.getTransformer().toEntity(persistentDTO).getEgreso());
		hc.setIngreso(this.getTransformer().toEntity(persistentDTO).getIngreso());
		this.getRepository().save(hc);

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		this.getRepository().deleteById(id);

	}

	@Override
	public HistoriaClinicaDTO retrive(Long id) {
		// TODO Auto-generated method stub
		return this.getTransformer().toDTO(this.getRepository().findById(id).get());
	}

	@Override
	public List<HistoriaClinicaDTO> list() {
		// TODO Auto-generated method stub
		return this.getTransformer().toListDTO(this.getRepository().findAll());
	}

	public HistoriaClinicaRepository getRepository() {
		return repository;
	}

	public Transformer<HistoriaClinica, HistoriaClinicaDTO> getTransformer() {
		return transformer;
	}

	public void setRepository(HistoriaClinicaRepository repository) {
		this.repository = repository;
	}

	public void setTransformer(Transformer<HistoriaClinica, HistoriaClinicaDTO> transformer) {
		this.transformer = transformer;
	}

}
