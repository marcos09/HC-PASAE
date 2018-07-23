package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;

public class IngresoPacienteDTO extends GenericDTOImpl {

	private Long id;
	@NotEmpty(message = "El motivo de consulta no puede ser nulo o vacío")
	private String motivoConsulta;
	@NotEmpty(message = "La enfermedad actual no puede ser nula o vacía")
	private String enfermedadActual;
	@NotEmpty(message = "El diagnostico sintomatico no puede ser nulo o vacío")
	private String diagnosticoSintomatico;
	@NotEmpty(message = "El diagnostico presuntivo no puede ser nulo o vacío")
	private String diagnosticoPresuntivo;

	private Set<EstudioComplementarioDTO> estudiosComplementarios;
	private Set<PrescripcionDTO> prescripciones;

	public IngresoPacienteDTO() {
		super();
	}

	public IngresoPacienteDTO(Long id, String motivoConsulta, String enfermedadActual, String diagnosticoSintomatico,
			String diagnosticoPresuntivo, Set<EstudioComplementarioDTO> estudios, Set<PrescripcionDTO> prescripciones) {
		super();
		this.setId(id);
		this.setMotivoConsulta(motivoConsulta);
		this.setEnfermedadActual(enfermedadActual);
		this.setDiagnosticoSintomatico(diagnosticoSintomatico);
		this.setDiagnosticoPresuntivo(diagnosticoPresuntivo);
		this.setEstudiosComplementarios(estudios);
		this.setPrescripciones(prescripciones);
	}

	public IngresoPacienteDTO(Long id, String motivoConsulta, String enfermedadActual, String diagnosticoSintomatico,
			String diagnosticoPresuntivo) {
		super();
		this.setId(id);
		this.setMotivoConsulta(motivoConsulta);
		this.setEnfermedadActual(enfermedadActual);
		this.setDiagnosticoSintomatico(diagnosticoSintomatico);
		this.setDiagnosticoPresuntivo(diagnosticoPresuntivo);
		this.setEstudiosComplementarios(new HashSet<EstudioComplementarioDTO>());
		this.setPrescripciones(new HashSet<PrescripcionDTO>());

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMotivoConsulta() {
		return motivoConsulta;
	}

	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}

	public String getEnfermedadActual() {
		return enfermedadActual;
	}

	public void setEnfermedadActual(String enfermedadActual) {
		this.enfermedadActual = enfermedadActual;
	}

	public String getDiagnosticoSintomatico() {
		return diagnosticoSintomatico;
	}

	public void setDiagnosticoSintomatico(String diagnosticoSintomatico) {
		this.diagnosticoSintomatico = diagnosticoSintomatico;
	}

	public String getDiagnosticoPresuntivo() {
		return diagnosticoPresuntivo;
	}

	public void setDiagnosticoPresuntivo(String diagnosticoPresuntivo) {
		this.diagnosticoPresuntivo = diagnosticoPresuntivo;
	}

	public Set<EstudioComplementarioDTO> getEstudiosComplementarios() {
		return estudiosComplementarios;
	}

	public void setEstudiosComplementarios(Set<EstudioComplementarioDTO> estudiosComplementarios) {
		this.estudiosComplementarios = estudiosComplementarios;
	}

	public Set<PrescripcionDTO> getPrescripciones() {
		return prescripciones;
	}

	public void setPrescripciones(Set<PrescripcionDTO> prescripciones) {
		this.prescripciones = prescripciones;
	}

	public void addEstudio(EstudioComplementarioDTO estudio) {
		this.getEstudiosComplementarios().add(estudio);
	}

	public void addPrescripcion(PrescripcionDTO prescripcion) {
		this.getPrescripciones().add(prescripcion);
	}

	public void removeEstudio(EstudioComplementarioDTO estudio) {
		this.getEstudiosComplementarios().remove(estudio);
	}

	public void removePrescripcion(PrescripcionDTO prescripcion) {
		this.getPrescripciones().remove(prescripcion);
	}

}
