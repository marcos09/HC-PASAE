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

@Service
public class PacienteServiceImpl extends GenericServiceImpl<PacienteRepository, Paciente, PacienteDTO> implements PacienteService {

	@Autowired
	private Validator validator;

	@Override
	public PacienteDTO create(PacienteDTO persistentDTO) throws BaseException {
		int dni = persistentDTO.getDni();

		if (this.getRepository().findByDni(dni) != null) {
			if (dni == (this.getRepository().findByDni(dni).getDni())) {
				throw new BaseException("El paciente con el dni que intenta agregar ya existe");
			}
		}

		Set<ConstraintViolation<PacienteDTO>> validations = validator.validate(persistentDTO);
		if (validations.isEmpty()) {
			return this.getTransformer().toDTO(
					this.getRepository()
					.save(this.getTransformer().toEntity(persistentDTO)));
		}else {
			throw new BaseException("El paciente no se pudo agregar correctamente");
		}
		

	}

	@Override
	public PacienteDTO update(PacienteDTO persistentDTO) throws BaseException{
		Set<ConstraintViolation<PacienteDTO>> validations = validator.validate(persistentDTO);
		if (validations.isEmpty()) {
			return this.getTransformer().toDTO(this.getRepository().save(this.getTransformer().toEntity(persistentDTO)));
		}else {
			throw new BaseException("El paciente no se pudo actualizar correctamente");
		}
	}

	@Override
	public void delete(Long id) {
		this.getRepository().deleteById(id);
	}

	@Override
	public PacienteDTO retrive(Long id) throws BaseException {
		if (this.getRepository().findById(id) != null) {
			return this.getTransformer().toDTO(this.getRepository().findById(id).get());
		} else {
			throw new BaseException("El paciente no existe");
		}

	}

	@Override
	public List<PacienteDTO> findByApellidoContaining(String apellido) {
		Optional<Collection<Paciente>> optional = this.getRepository().findByApellidoContaining(apellido);
		if (optional.isPresent()) {
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

	@Override
	public PacienteDTO findByDni(int dni) throws BaseException{
		
		if (this.getRepository().findByDni(dni) !=null) {
			return this.getTransformer().toDTO(this.getRepository().findByDni(dni));
		} else {
			throw new BaseException("El paciente no existe");
		}
	}

}