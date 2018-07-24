package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.HistoriaClinicaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.HistoriaClinica;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;
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
	public void addIngreso(IngresoPaciente ingreso) {
		HistoriaClinica historia = new HistoriaClinica((ingreso));
		Set<ConstraintViolation<HistoriaClinica>> validations = validator.validate(historia);// si esta vacio no
																								// hubieron errores de
																								// validacion
		if (validations.isEmpty()) {
			this.getRepository().save(historia);
		}
	}

	//Actualizo la historia clinica
	@Override
	public void update(HistoriaClinicaDTO persistentDTO) {
		HistoriaClinica historiaBase = this.getRepository().findById(persistentDTO.getId()).get();
		if (historiaBase.getEgreso() == null) {
			HistoriaClinica historia = this.getTransformer().toEntity(persistentDTO);
			this.getRepository().save(historia);
		}
		

	}

	//Elimino la historia con el id
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		this.getRepository().deleteById(id);

	}

	//Recuperom historia clinica mediante id
	@Override
	public HistoriaClinicaDTO retrive(Long id) {
		// TODO Auto-generated method stub
		return this.getTransformer().toDTO(this.getRepository().findById(id).get());
	}

	//Listo todas las historias clinicas
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
