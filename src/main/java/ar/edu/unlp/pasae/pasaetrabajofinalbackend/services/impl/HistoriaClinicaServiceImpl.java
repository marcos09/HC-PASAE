package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.EgresoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.ElementoHistoriaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.HistoriaClinicaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.HistoriaCompactaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.HistoriaOrdenadaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PrescripcionDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.SeguimientoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.EstudioComplementario;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.HistoriaClinica;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Paciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Prescripcion;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Seguimiento;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.exception.BaseException;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.HistoriaClinicaRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.HistoriaClinicaService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.EgresoTransformer;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.EstudioComplementarioTransformer;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.HistoriaClinicaTransformer;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.IngresoPacienteTransformer;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.PrescripcionTransformer;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.Transformer;

@Service
@Transactional

public class HistoriaClinicaServiceImpl extends GenericServiceImpl<HistoriaClinicaRepository, HistoriaClinica, HistoriaClinicaDTO> implements HistoriaClinicaService {

	@Autowired
	private EstudioComplementarioTransformer estudioTransformer;

	@Autowired
	private EgresoTransformer egresoTransformer;

	@Autowired
	private HistoriaClinicaTransformer historiaTransformer;

	@Autowired
	private IngresoPacienteTransformer ingresoTransformer;

	@Autowired
	private PrescripcionTransformer prescripcionTransformes;

	@Autowired
	private Transformer<Seguimiento, SeguimientoDTO> seguimientoTransformer;

	@Autowired
	private Transformer<Paciente, PacienteDTO> pacienteTransformer;

	@Autowired
	private Validator validator;

	@Override
	public HistoriaClinicaDTO addIngreso(IngresoPaciente ingreso, Paciente paciente) {
		HistoriaClinica historia = new HistoriaClinica((ingreso));
		historia.setPaciente(paciente);
		Set<ConstraintViolation<HistoriaClinica>> validations = validator.validate(historia);// si esta vacio no
																								// hubieron errores de
																								// validacion
		if (validations.isEmpty()) {
			return this.getHistoriaTransformer().toDTO(this.getRepository().save(historia));
		} else {
			// Levantar excepcion por errores de validacion.
			return null;
		}
	}

	public HistoriaClinicaTransformer getHistoriaTransformer() {
		return historiaTransformer;
	}

	public void setHistoriaTransformer(HistoriaClinicaTransformer historiaTransformer) {
		this.historiaTransformer = historiaTransformer;
	}

	public void setEgresoTransformer(EgresoTransformer egresoTransformer) {
		this.egresoTransformer = egresoTransformer;
	}

	// Actualizo la historia clinica
	@Override
	public void update(HistoriaClinicaDTO persistentDTO) {
		HistoriaClinica historiaBase = this.getRepository().findById(persistentDTO.getId()).get();
		if (historiaBase.getEgreso() == null) {
			HistoriaClinica historia = this.getTransformer().toEntity(persistentDTO);
			this.getRepository().save(historia);
		}

	}

	// Elimino la historia con el id
	@Override
	public void delete(Long id) {
		this.getRepository().deleteById(id);

	}

	// Recuperom historia clinica mediante id
	@Override
	public HistoriaClinicaDTO retrive(Long id) {
		return this.getTransformer().toDTO(this.getRepository().findById(id).get());
	}

	// Listo todas las historias clinicas
	@Override
	public List<HistoriaClinicaDTO> list() {
		return this.getTransformer().toListDTO(this.getRepository().findAll());
	}

	public Transformer<Paciente, PacienteDTO> getPacienteTransformer() {
		return pacienteTransformer;
	}

	public void setPacienteTransformer(Transformer<Paciente, PacienteDTO> pacienteTransformer) {
		this.pacienteTransformer = pacienteTransformer;
	}

	@Override
	public Object agregarSeguimiento(Long id, SeguimientoDTO seguimiento) throws BaseException {
		Optional<HistoriaClinica> optional = this.getRepository().findById(id);
		if (optional.isPresent()) {
			HistoriaClinica historia = optional.get();
			if (historia.getEgreso() == null) {
				Set<PrescripcionDTO> prescripcionesDTO = seguimiento.getPrescripcionesDTO();
				for (PrescripcionDTO p : prescripcionesDTO) {
					if (p.getMedicamento() == null) {
						throw new RuntimeException("Debe indicar un medicamento en la prescripcion");
					}
				}
				historia.addSeguimiento(this.getSeguimientoTransformer().toEntity(seguimiento));
				this.getRepository().save(historia);
				return historia;
			} else {
				throw new RuntimeException("El paciente ya egreso");
			}
		} else {
			throw new RuntimeException("La historia clinica no existe");
		}
	}

	private Transformer<Seguimiento, SeguimientoDTO> getSeguimientoTransformer() {
		return seguimientoTransformer;
	}

	public EstudioComplementarioTransformer getEstudioTransformer() {
		return estudioTransformer;
	}

	public void setEstudioTransformer(EstudioComplementarioTransformer estudioTransformer) {
		this.estudioTransformer = estudioTransformer;
	}

	public PrescripcionTransformer getPrescripcionTransformes() {
		return prescripcionTransformes;
	}

	public void setPrescripcionTransformes(PrescripcionTransformer prescripcionTransformes) {
		this.prescripcionTransformes = prescripcionTransformes;
	}

	public Validator getValidator() {
		return validator;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	public void setSeguimientoTransformer(Transformer<Seguimiento, SeguimientoDTO> seguimientoTransformer) {
		this.seguimientoTransformer = seguimientoTransformer;
	}

	@Override
	public List<ElementoHistoriaDTO> getHistoriaOrdenada(Long idHistoria) {
		
		Optional<HistoriaClinica> optional = this.getRepository().findById(idHistoria);
		if (optional.isPresent()) {
			HistoriaClinica historia = optional.get();
			ArrayList<ElementoHistoriaDTO> result = new ArrayList<ElementoHistoriaDTO>();
			
			ArrayList<EstudioComplementario> estudios = (ArrayList<EstudioComplementario>) historia
					.getEstudiosFinalizados();
			
			for(EstudioComplementario e: estudios) {
				result.add(new ElementoHistoriaDTO(e.getId(), "EstudioComplementario", e.getFechaResultado()));
			}
			
			
			ArrayList<Prescripcion> prescripciones = (ArrayList<Prescripcion>) historia.getPrescripciones();
			
			for(Prescripcion p: prescripciones) {
				result.add(new ElementoHistoriaDTO(p.getId(), "Aplicacion", p.getFechaAdministracion()));
			}
			
			result.add(new ElementoHistoriaDTO(historia.getIngreso().getId(), "Ingreso", historia.getIngreso().getFechaIngreso()));
			
			if (historia.getEgreso() != null) {
				result.add(new ElementoHistoriaDTO(historia.getEgreso().getId(), "Egreso", historia.getEgreso().getFecha()));
			}
			
			for(Seguimiento s: historia.getSeguimientos()) {
				result.add(new ElementoHistoriaDTO(s.getId(), "Seguimiento", s.getFecha()));
			}
			
			Collections.sort(result);
			return result;
		}
		return null;
	}

	@Override
	public PacienteDTO getPaciente(Long id) {

		Optional<HistoriaClinica> optional = this.getRepository().findById(id);
		if (optional.isPresent()) {
			HistoriaClinica historia = optional.get();
			Paciente paciente = historia.getPaciente();
			return this.getPacienteTransformer().toDTO(paciente);
		}
		return null;
	}

	public List<HistoriaCompactaDTO> historiasActivas() {
		
		List<HistoriaClinica> list = this.getRepository().findByEgresoIsNull();
		List<HistoriaCompactaDTO> result = new ArrayList<HistoriaCompactaDTO>();
		for (HistoriaClinica h : list) {
			String nombreCompleto = h.getPaciente().getApellido() + ", " + h.getPaciente().getNombre();
			result.add(new HistoriaCompactaDTO(h.getId(), h.getPaciente().getId(), nombreCompleto,
					h.getIngreso().getEnfermedadActual(), h.getIngreso().getMotivoConsulta(),
					h.getIngreso().getFechaIngreso()));

		}
		return result;
	}

	/*
	 * public List<EgresoDTO> toListDTO(List<Egreso> list) { List<EgresoDTO> lista =
	 * new ArrayList<EgresoDTO>(); for (Egreso e : list) { lista.add(this.toDTO(e));
	 * } return lista; } (non-Javadoc)
	 * 
	 * @see
	 * ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.HistoriaClinicaService#
	 * egresar(java.lang.Long,
	 * ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.EgresoDTO)
	 */

	@Override
	public void egresar(Long id, @Valid EgresoDTO egreso) {
		Optional<HistoriaClinica> optional = this.getRepository().findById(id);
		if (optional.isPresent()) {
			HistoriaClinica historia = optional.get();
			if (historia.getEgreso() == null) {
				historia.setEgreso(this.getEgresoTransformer().toEntity(egreso));
				this.getRepository().save(historia);
			}
		}
		// Levantar excepción historia no encontrada
	}

	public EgresoTransformer getEgresoTransformer() {
		return egresoTransformer;
	}

	public IngresoPacienteTransformer getIngresoTransformer() {
		return ingresoTransformer;
	}

	public void setIngresoTransformer(IngresoPacienteTransformer ingresoTransformer) {
		this.ingresoTransformer = ingresoTransformer;
	}

	@Override
	public HistoriaOrdenadaDTO getHistoriaCompletaOrdenada(Long idHistoria) {
			Optional<HistoriaClinica> optional = this.getRepository().findById(idHistoria);
			if (optional.isPresent()) {
				HistoriaClinica historia = optional.get();
				ArrayList<EstudioComplementario> estudios = (ArrayList<EstudioComplementario>) historia
						.getEstudiosFinalizados();

				Collections.sort(estudios);
				ArrayList<Prescripcion> prescripciones = (ArrayList<Prescripcion>) historia.getPrescripciones();
				Collections.sort(prescripciones);
				HistoriaOrdenadaDTO historiaOrdenada = new HistoriaOrdenadaDTO();
				historiaOrdenada.setAplicaciones(this.getPrescripcionTransformes().toListDTO(prescripciones));
				historiaOrdenada.setEstudios(this.getEstudioTransformer().toListDTO(estudios));
				IngresoPacienteDTO ingresoDTO = this.getIngresoTransformer().toDTO(historia.getIngreso());
				historiaOrdenada.setIngreso(ingresoDTO);
				if (historia.getEgreso() != null) {
					EgresoDTO egresoDTO = this.getEgresoTransformer().toDTO(historia.getEgreso());
					historiaOrdenada.setEgreso(egresoDTO);
				}

				historiaOrdenada.setPacienteDTO(this.getPacienteTransformer().toDTO(historia.getPaciente()));
				historiaOrdenada.setId(historia.getId());

				List<Seguimiento> seguimientosList = new ArrayList<Seguimiento>();
				seguimientosList.addAll(historia.getSeguimientos());
				ArrayList<SeguimientoDTO> seguimientos = (ArrayList<SeguimientoDTO>) this.getSeguimientoTransformer()
						.toCollectionDTO(seguimientosList);
				Collections.sort(seguimientos);
				historiaOrdenada.setSeguimientos(seguimientos);
				return historiaOrdenada;
			}
			return null;
	}

}
