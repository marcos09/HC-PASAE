package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Paciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.exception.BaseException;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.PacienteRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.PacienteService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.Transformer;

@Service
public class PacienteServiceImpl implements PacienteService {
	
	@Autowired
	private PacienteRepository repository;
	
	@Autowired
	private Transformer<Paciente, PacienteDTO> transformer;

	@Autowired
	private Validator validator;

	@Override
	public void create(PacienteDTO persistentDTO) throws BaseException {
		int dni = persistentDTO.getDni();
	
		if (this.getRepository().findByDni(dni) != null) {
			if ( dni == (this.getRepository().findByDni(dni).getDni()) ) {
				throw new RuntimeException("El paciente con el dni que intenta agregar ya existe");
			}
		}
		
		Set<ConstraintViolation<PacienteDTO>> validations = validator.validate(persistentDTO);
		if (validations.isEmpty()) {
			this.getRepository().save(this.getTransformer().toEntity(persistentDTO));
		}
		
	}

	@Override
	public void update(PacienteDTO persistentDTO) {
		
	}

	@Override
	public void delete(Long id) {
		this.getRepository().deleteById(id);
	}

	@Override
	public PacienteDTO retrive(Long id) {
		return this.getTransformer().toDTO(this.getRepository().findById(id).get());

	}

	@Override
	public List<PacienteDTO> findByApellidoContaining(String apellido) {
		Optional<Collection<Paciente>> optional = this.getRepository().findByApellidoContaining(apellido);
		if(optional.isPresent()) {
			List<Paciente> result = (List<Paciente>) optional.get();
			return this.getTransformer().toListDTO(result);
		}
		return null;
				
	}
	
	@Override
	public List<PacienteDTO> list() {
		List<Paciente> listPacientes = this.getRepository().findAll();
		return this.getTransformer().toListDTO(listPacientes);
	}

	public PacienteRepository getRepository() {
		return repository;
	}

	public void setRepository(PacienteRepository repository) {
		this.repository = repository;
	}

	public Transformer<Paciente, PacienteDTO> getTransformer() {
		return transformer;
	}

	public void setTransformer(Transformer<Paciente, PacienteDTO> transformer) {
		this.transformer = transformer;
	}
	
	
	
}