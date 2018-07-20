package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.IngresoPacienteRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.IngresoPacienteService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.Transformer;


@Service
public class IngresoPacienteServiceImpl implements IngresoPacienteService{
	
	@Autowired
	private IngresoPacienteRepository repository;
	
	@Autowired
	private Transformer<IngresoPaciente, IngresoPacienteDTO> transformer;
	
	@Autowired
	private Validator validator;
	
	private Transformer<IngresoPaciente, IngresoPacienteDTO> getTransformer() {
		return transformer;
	}

	@SuppressWarnings("unused")
	private void setTransformer(Transformer<IngresoPaciente, IngresoPacienteDTO> transformer) {
		this.transformer = transformer;
	}
	
	public IngresoPacienteRepository getRepository() {
		return repository;
	}
	

	public void setRepository(IngresoPacienteRepository repository) {
		this.repository = repository;
	}


	
	public IngresoPacienteServiceImpl() {
		super();
	}
	
	
	@Override
	public List<IngresoPacienteDTO> list() {
		 List<IngresoPaciente> listIngresos = this.getRepository().findAll();
		 return this.getTransformer().toListDTO(listIngresos);
		
	}


	@Override
	public void create(IngresoPacienteDTO dto) {
		// TODO Auto-generated method stub
		IngresoPaciente ip = new IngresoPaciente(dto.getId(),dto.getMotivoConsulta(),dto.getEnfermedadActual(),dto.getDiagnosticoSintomatico(),dto.getDiagnosticoPresuntivo(),dto.getEstudiosComplementarios(),dto.getPrescripciones());
		Set<ConstraintViolation<IngresoPaciente>> validations = validator.validate(ip);//si esta vacio no hubieron errores de validacion
		if (validations.isEmpty()) {
			this.getRepository().save(ip);
		}
		
	}


	@Override
	public void update(IngresoPacienteDTO dto) {
		// TODO Auto-generated method stub
		Optional<IngresoPaciente> op = this.getRepository().findById(dto.getId());
		IngresoPaciente ip = op.get();
		ip.editDiagnosticoPresuntivo(dto.getDiagnosticoPresuntivo());
		ip.editMotivoConsulta(dto.getMotivoConsulta());
		ip.editDiagnosticoSintomatico(dto.getDiagnosticoSintomatico());
		ip.editEnfermedadActual(dto.getEnfermedadActual());
		this.getRepository().save(ip);
		
	}


	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		this.getRepository().deleteById(id);
		
	}


	@Override
	public IngresoPacienteDTO retrive(Long id) {
		IngresoPaciente ip = this.getRepository().findById(id).get();
		return this.getTransformer().toDTO(ip);
	}

	//Prueba para ver si funciona el aspecto que convierte las excepciones no manejadas
//	@Override
//	public void thowException() throws BaseException {
//		throw new RuntimeException("Excepción runtime");
//	}

	
}
