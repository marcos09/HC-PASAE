package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.EstudioComplementarioDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.EstudioComplementario;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.exception.BaseException;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.EstudioComplementarioRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.EstudioComplementarioService;

@Service
@Transactional

public class EstudioComplementarioServiceImpl extends GenericServiceImpl<EstudioComplementarioRepository, EstudioComplementario, EstudioComplementarioDTO> implements EstudioComplementarioService {
	
	@Override
	public void create(EstudioComplementarioDTO persistentDTO) {
		this.getRepository().save(this.getTransformer().toEntity(persistentDTO));

	}

	@Override
	public void update(EstudioComplementarioDTO dto) throws BaseException{
		Optional<EstudioComplementario> op = this.getRepository().findById(dto.getId());
		EstudioComplementario ec = op.get();
		if (ec.getInformeResultado() == null) {
			ec.setInformeResultado(dto.getInformeResultado());
			this.getRepository().save(ec);
		}
		else {
			throw new RuntimeException("El resultado del estudio complementario ya se cargo");
		}
	}

	@Override
	public void delete(Long id) {
		this.getRepository().deleteById(id);
	}

	@Override
	public EstudioComplementarioDTO retrive(Long id) {
		return this.getTransformer().toDTO(this.getRepository().findById(id).get());
	}

	@Override
	public List<EstudioComplementarioDTO> list() {
		return this.getTransformer().toListDTO(this.getRepository().findAll());
	}

}
