package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.EstudioComplementarioDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.EstudioComplementario;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.exception.BaseException;
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
		this.getEstudioRepository().save(this.getTransformer().toEntity(persistentDTO));

	}

	@Override
	public void update(EstudioComplementarioDTO dto) throws BaseException{
		Optional<EstudioComplementario> op = this.getEstudioRepository().findById(dto.getId());
		EstudioComplementario ec = op.get();
		if (ec.getInformeResultado() == null) {
			ec.setInformeResultado(dto.getInformeResultado());
			this.getEstudioRepository().save(ec);
		}
		else {
			throw new RuntimeException("El resultado del estudio complementario ya se cargo");
		}
	}

	@Override
	public void delete(Long id) {
		this.getEstudioRepository().deleteById(id);
	}

	@Override
	public EstudioComplementarioDTO retrive(Long id) {
		return this.getTransformer().toDTO(this.getEstudioRepository().findById(id).get());
	}

	@Override
	public List<EstudioComplementarioDTO> list() {
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
