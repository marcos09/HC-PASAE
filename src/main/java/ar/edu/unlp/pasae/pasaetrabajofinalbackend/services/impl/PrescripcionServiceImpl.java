package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.CantidadPrescripcionesMedicamentoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PrescripcionDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Prescripcion;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.PrescripcionRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.ChartsRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.PrescripcionService;

@Service
@Transactional

public class PrescripcionServiceImpl extends GenericServiceImpl<PrescripcionRepository, Prescripcion, PrescripcionDTO> implements PrescripcionService {
	
	@Autowired
	private ChartsRepository chartsRepository;

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

	
	public ChartsRepository getChartsRepository() {
		return chartsRepository;
	}


	public void setChartsRepository(ChartsRepository chartsRepository) {
		this.chartsRepository = chartsRepository;
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

	@Override
	public List<PrescripcionDTO> listEndPrescriptionForHistory(Long id) {
		this.getRepository(); //
		return null;
	}

	@Override
	public Set<CantidadPrescripcionesMedicamentoDTO> cantidadPrescripcionesMedicamento() {
		return this.getChartsRepository().cantidadPrescripcionesPorMedicamento();
	}

}
