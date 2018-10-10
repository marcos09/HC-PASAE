package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.EstudioComplementarioDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.EstudioComplementario;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Paciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.exception.BaseException;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.EstudioComplementarioRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.EstudioComplementarioService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.Transformer;

@Service
@Transactional

public class EstudioComplementarioServiceImpl extends GenericServiceImpl<EstudioComplementarioRepository, EstudioComplementario, EstudioComplementarioDTO> implements EstudioComplementarioService {
	
	@Autowired
	private Transformer<Paciente, PacienteDTO> pacienteTransformer;

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
			throw new BaseException("El resultado del estudio complementario ya se cargo");
		}
	}

	@Override
	public void delete(Long id) {
		this.getRepository().deleteById(id);
	}

	@Override
	public EstudioComplementarioDTO retrive(Long id) throws BaseException{
		Optional <EstudioComplementario> op = this.getRepository().findById(id);
		if (op.isPresent()) {
			return this.getTransformer().toDTO(op.get());
		}else {
			throw new BaseException("El estudio no existe");
		}
		
	}

	@Override
	public List<EstudioComplementarioDTO> list() {
		return this.getTransformer().toListDTO(this.getRepository().findAll());
	}

	@Override
	public List<EstudioComplementarioDTO> estudiosActivos() {
		return this.getTransformer().toListDTO(this.getRepository().findByInformeResultadoIsNull());
	}

	@Override
	public PacienteDTO findPacienteFromEstudio(Long idEstudio) throws BaseException  {
		Optional <EstudioComplementario> op = this.getRepository().findById(idEstudio);
		if (op.isPresent()) {
			Paciente p = this.getRepository().findPacienteFromEstudio(op.get());
			return this.getPacienteTransformer().toDTO(p);
		}else {
			throw new BaseException("El estudio no existe");
		}

	}

	protected Transformer<Paciente, PacienteDTO> getPacienteTransformer() {
		return pacienteTransformer;
	}

	protected void setPacienteTransformer(Transformer<Paciente, PacienteDTO> pacienteTransformer) {
		this.pacienteTransformer = pacienteTransformer;
	}
	
	

}
