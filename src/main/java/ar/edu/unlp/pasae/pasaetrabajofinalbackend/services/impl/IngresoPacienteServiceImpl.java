package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.HistoriaClinicaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PatologiaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PrescripcionDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Medicamento;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Paciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Prescripcion;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.exception.BaseException;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.IngresoPacienteRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.MedicamentoRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.PacienteRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.HistoriaClinicaService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.IngresoPacienteService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.EstudioComplementarioTransformer;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.PatologiaTransformer;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.PrescripcionTransformer;

@Service
@Transactional
public class IngresoPacienteServiceImpl
		extends GenericServiceImpl<IngresoPacienteRepository, IngresoPaciente, IngresoPacienteDTO>
		implements IngresoPacienteService {

	@Autowired
	private MedicamentoRepository medicamentosRepository;

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private HistoriaClinicaService historia;

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

	public IngresoPacienteServiceImpl() {
		super();
	}

	@PreAuthorize("hasAuthority('ROLE_MEDICO')")
	@Override
	public List<IngresoPacienteDTO> list() {
		List<IngresoPaciente> listIngresos = this.getRepository().findAll();
		return this.getTransformer().toListDTO(listIngresos);

	}
	

	// idPaciente debe recibir un número menor a 0 para indicar que se creará la
	// historia sin paciente, un número mayor que se corresponderá
	// al número de id del paciente a internar. Deberá existir dicho paciente previo
	// al ingreso, caso contrario ocurrirá un error.
	@Override
	public HistoriaClinicaDTO create(IngresoPacienteDTO dto, Long idPaciente) throws BaseException {
		Paciente paciente = null;
		PatologiaDTO sintomatico = dto.getDiagnosticoSintomatico();
		PatologiaDTO presuntivo = dto.getDiagnosticoPresuntivo();
		
	

		Set<Prescripcion> listPrescripciones = new HashSet<Prescripcion>();

		for (PrescripcionDTO p : dto.getPrescripcionesDTO()) {
			Optional<Medicamento> med = this.getMedicamentosRepository().findById(p.getMedicamento().getId());
			if (med.isPresent()) {
				Prescripcion presc = this.getPrescripcionTransformer().toEntity(p);
				presc.setMedicamento(med.get());
				listPrescripciones.add(presc);
			}

		}
		if (idPaciente > 0) {
			Optional<Paciente> optional = this.getPacienteRepository().findById(idPaciente);
			if (optional.isPresent()) {
				paciente = optional.get();
			} else {
				throw new BaseException("El paciente no se indico en la creacion del ingreso");
			}

		}
		IngresoPaciente ip = new IngresoPaciente(dto.getId(), dto.getMotivoConsulta(), dto.getEnfermedadActual(),
				this.getPatologiaTransformer().toEntity(sintomatico),
				this.getPatologiaTransformer().toEntity(presuntivo),
				this.getEstudioTransformer().toSet(dto.getEstudiosComplementariosDTO()), listPrescripciones,
				dto.getAntecedentesEnfermedad(), dto.getAntecedentesPersonales(), dto.getExamenFisico());

		Set<ConstraintViolation<IngresoPaciente>> validations = validator.validate(ip);// si esta vacio no hubieron
																						// errores de validacion
		if (validations.isEmpty()) {
			this.getRepository().save(ip);
			return this.getHistoriaService().addIngreso(ip, paciente);
		} else {
			throw new BaseException("Errores en validacion");
		}

	}

	private MedicamentoRepository getMedicamentosRepository() {
		return medicamentosRepository;
	}

	public void setMedicamentosRepository(MedicamentoRepository medicamentosRepository) {
		this.medicamentosRepository = medicamentosRepository;
	}

	public HistoriaClinicaService getHistoria() {
		return historia;
	}

	public void setHistoria(HistoriaClinicaService historia) {
		this.historia = historia;
	}

	public Validator getValidator() {
		return validator;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	public void setEstudioTransformer(EstudioComplementarioTransformer estudioTransformer) {
		this.estudioTransformer = estudioTransformer;
	}

	public void setPatologiaTransformer(PatologiaTransformer patologiaTransformer) {
		this.patologiaTransformer = patologiaTransformer;
	}

	public void setPrescripcionTransformer(PrescripcionTransformer prescripcionTransformer) {
		this.prescripcionTransformer = prescripcionTransformer;
	}

	@Override
	public void update(IngresoPacienteDTO dto) {
		Optional<IngresoPaciente> op = this.getRepository().findById(dto.getId());
		IngresoPaciente ip = op.get();
		ip.editDiagnosticoPresuntivo(this.getPatologiaTransformer().toEntity(dto.getDiagnosticoPresuntivo()));
		ip.editMotivoConsulta(dto.getMotivoConsulta());
		ip.editDiagnosticoSintomatico(this.getPatologiaTransformer().toEntity(dto.getDiagnosticoSintomatico()));
		ip.editEnfermedadActual(dto.getEnfermedadActual());
		ip.setEstudiosComplementarios(this.getEstudioTransformer().toSet(dto.getEstudiosComplementariosDTO()));
		ip.setPrescripciones(this.getPrescripcionTransformer().toSet(dto.getPrescripcionesDTO()));
		this.getRepository().save(ip);

	}

	@Override
	public void delete(Long id) {
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

	public PacienteRepository getPacienteRepository() {
		return pacienteRepository;
	}

	public void setPacienteRepository(PacienteRepository pacienteRepository) {
		this.pacienteRepository = pacienteRepository;
	}

}
