package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PatologiaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.IngresoPacienteRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.HistoriaClinicaService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.IngresoPacienteService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.EstudioComplementarioTransformer;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.PatologiaTransformer;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.PrescripcionTransformer;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.Transformer;

@Service
@Transactional
public class IngresoPacienteServiceImpl implements IngresoPacienteService {

	@Autowired
	private IngresoPacienteRepository repository;

	@Autowired
	private HistoriaClinicaService historia;

	@Autowired
	private Transformer<IngresoPaciente, IngresoPacienteDTO> transformer;

	@Autowired
	private Validator validator;

	@Autowired
	private EstudioComplementarioTransformer estudioTransformer;

	@Autowired
	private PatologiaTransformer patologiaTransformer;

	public PatologiaTransformer getPatologiaTransformer() {
		return patologiaTransformer;
	}

	@Autowired
	private PrescripcionTransformer prescripcionTransformer;

	public EstudioComplementarioTransformer getEstudioTransformer() {
		return estudioTransformer;
	}

	public PrescripcionTransformer getPrescripcionTransformer() {
		return prescripcionTransformer;
	}

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

	@PreAuthorize("hasAuthority('ROLE_MEDICO')")
	@Override
	public List<IngresoPacienteDTO> list() {
		List<IngresoPaciente> listIngresos = this.getRepository().findAll();
		return this.getTransformer().toListDTO(listIngresos);

	}

	@Override
	public void create(IngresoPacienteDTO dto) {
		PatologiaDTO sintomatico = dto.getDiagnosticoSintomatico();
		PatologiaDTO presuntivo = dto.getDiagnosticoPresuntivo();
		IngresoPaciente ip = new IngresoPaciente(dto.getId(), dto.getMotivoConsulta(), dto.getEnfermedadActual(),
				this.getPatologiaTransformer().toEntity(sintomatico),
				this.getPatologiaTransformer().toEntity(presuntivo),
				this.getEstudioTransformer().toSet(dto.getEstudiosComplementarios()),
				this.getPrescripcionTransformer().toSet(dto.getPrescripciones()), dto.getAntecedentesEnfermedad(),
				dto.getAntecedentesPersonales(), dto.getExamenFisico());
		Set<ConstraintViolation<IngresoPaciente>> validations = validator.validate(ip);// si esta vacio no hubieron
																						// errores de validacion
		if (validations.isEmpty()) {
			this.getRepository().save(ip);
			this.getHistoriaService().addIngreso(ip);
		}
	}

	@Override
	public void update(IngresoPacienteDTO dto) {
		Optional<IngresoPaciente> op = this.getRepository().findById(dto.getId());
		IngresoPaciente ip = op.get();
		ip.editDiagnosticoPresuntivo(this.getPatologiaTransformer().toEntity(dto.getDiagnosticoPresuntivo()));
		ip.editMotivoConsulta(dto.getMotivoConsulta());
		ip.editDiagnosticoSintomatico(this.getPatologiaTransformer().toEntity(dto.getDiagnosticoSintomatico()));
		ip.editEnfermedadActual(dto.getEnfermedadActual());
		ip.setEstudiosComplementarios(this.getEstudioTransformer().toSet(dto.getEstudiosComplementarios()));
		ip.setPrescripciones(this.getPrescripcionTransformer().toSet(dto.getPrescripciones()));
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

	public HistoriaClinicaService getHistoriaService() {
		return historia;
	}
	// Prueba para ver si funciona el aspecto que convierte las excepciones no
	// manejadas
	// @Override
	// public void thowException() throws BaseException {
	// throw new RuntimeException("Excepción runtime");
	// }

}
