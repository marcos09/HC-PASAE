package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.EstudioComplementarioDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.EstudioComplementario;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.EstudioComplementarioRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.EstudioComplementarioService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.Transformer;

@Service
@Transactional

public class EstudioComplementarioServiceImpl implements EstudioComplementarioService {

	@Autowired
	private EstudioComplementarioRepository estudioRepository;

	@Autowired
	private Transformer<EstudioComplementario, EstudioComplementarioDTO> transformer;

	@Override
	public void create(EstudioComplementarioDTO persistentDTO) {
		// TODO Auto-generated method stub
		this.getEstudioRepository().save(this.getTransformer().toEntity(persistentDTO));

	}

	@Override
	public void update(EstudioComplementarioDTO dto) {
		Optional<EstudioComplementario> op = this.getEstudioRepository().findById(dto.getId());
		EstudioComplementario ec = op.get();
		ec.setFechaRealizacion(dto.getFechaRealizacion());
		ec.setFechaResultado(dto.getFechaResultado());
		ec.setInformeResultado(dto.getInformeResultado());
		this.getEstudioRepository().save(ec);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		this.getEstudioRepository().deleteById(id);
	}

	@Override
	public EstudioComplementarioDTO retrive(Long id) {
		// TODO Auto-generated method stub
		return this.getTransformer().toDTO(this.getEstudioRepository().findById(id).get());
	}

	@Override
	public List<EstudioComplementarioDTO> list() {
		// TODO Auto-generated method stub
		return this.getTransformer().toListDTO(this.getEstudioRepository().findAll());
	}

	public EstudioComplementarioRepository getEstudioRepository() {
		return estudioRepository;
	}

	public Transformer<EstudioComplementario, EstudioComplementarioDTO> getTransformer() {
		return transformer;
	}

	public void setEstudioRepository(EstudioComplementarioRepository estudioRepository) {
		this.estudioRepository = estudioRepository;
	}

	public void setTransformer(Transformer<EstudioComplementario, EstudioComplementarioDTO> transformer) {
		this.transformer = transformer;
	}

}
