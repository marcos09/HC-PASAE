package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.HistoriaClinicaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.HistoriaOrdenadaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.SeguimientoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.EstudioComplementario;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.HistoriaClinica;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Prescripcion;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Seguimiento;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.HistoriaClinicaRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.HistoriaClinicaService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.EstudioComplementarioTransformer;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.PrescripcionTransformer;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.Transformer;

@Service
@Transactional

public class HistoriaClinicaServiceImpl implements HistoriaClinicaService {

	@Autowired
	private EstudioComplementarioTransformer estudioTransformer;

	@Autowired
	private PrescripcionTransformer prescripcionTransformes;
	
	@Autowired
	private HistoriaClinicaRepository repository;

	@Autowired
	private Transformer<HistoriaClinica, HistoriaClinicaDTO> transformer;

	@Autowired
	private Transformer<Seguimiento, SeguimientoDTO> seguimientoTransformer;
	
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
		this.getRepository().deleteById(id);

	}

	//Recuperom historia clinica mediante id
	@Override
	public HistoriaClinicaDTO retrive(Long id) {
		return this.getTransformer().toDTO(this.getRepository().findById(id).get());
	}

	//Listo todas las historias clinicas
	@Override
	public List<HistoriaClinicaDTO> list() {
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

	@Override
	public void agregarSeguimiento(Long id, @Valid SeguimientoDTO seguimiento) {
		Optional<HistoriaClinica> optional = this.getRepository().findById(id);
		if(optional.isPresent()) {
			HistoriaClinica historia = optional.get();
			historia.addSeguimiento(this.getSeguimientoTransformer().toEntity(seguimiento));
			this.getRepository().save(historia);
		}
		//Levantar excepción historia no encontrada
		
	}

	private Transformer<Seguimiento, SeguimientoDTO> getSeguimientoTransformer() {
		return seguimientoTransformer;
	}
	
	

	public EstudioComplementarioTransformer getEstudioTransformer() {
		return estudioTransformer;
	}

	public void setEstudioTransformer(EstudioComplementarioTransformer estudioTransformer) {
		this.estudioTransformer = estudioTransformer;
	}

	public PrescripcionTransformer getPrescripcionTransformes() {
		return prescripcionTransformes;
	}

	public void setPrescripcionTransformes(PrescripcionTransformer prescripcionTransformes) {
		this.prescripcionTransformes = prescripcionTransformes;
	}

	public Validator getValidator() {
		return validator;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	public void setSeguimientoTransformer(Transformer<Seguimiento, SeguimientoDTO> seguimientoTransformer) {
		this.seguimientoTransformer = seguimientoTransformer;
	}

	@Override
	public HistoriaOrdenadaDTO getHistoriaOrdenada(Long idHistoria) {
		Optional<HistoriaClinica> optional = this.getRepository().findById(idHistoria);
		if(optional.isPresent()) {
			HistoriaClinica historia = optional.get();
			ArrayList<EstudioComplementario> estudios = (ArrayList<EstudioComplementario>) historia.getEstudiosFinalizados();
			
			Collections.sort(estudios);
			ArrayList<Prescripcion> prescripciones = (ArrayList<Prescripcion>) historia.getPrescripciones();
			Collections.sort(prescripciones);
			HistoriaOrdenadaDTO historiaOrdenada = new HistoriaOrdenadaDTO();
			historiaOrdenada.setAplicaciones(this.getPrescripcionTransformes().toListDTO(prescripciones));
			historiaOrdenada.setEstudios(this.getEstudioTransformer().toListDTO(estudios));
			/*
			historia.getSeguimientos().toArray()
			historiaOrdenada.setSeguimientos((Set<SeguimientoDTO>)this.getSeguimientoTransformer().toListDTO(null);
			
					historia.getSeguimientos().
					.toCollectionDTO((List<Seguimiento>) historia.getSeguimientos()));
			*/
					
					
			return historiaOrdenada;
		}
		return null;
	}
}
