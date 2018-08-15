package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;

public class IngresoPacienteDTO extends GenericDTOImpl {

	
	@NotEmpty(message = "La fecha de ingreso no puede ser nula o vacia")
	private Date fechaIngreso;
	@NotEmpty(message = "El motivo de consulta no puede ser nulo o vacío")
	private String motivoConsulta;
	@NotEmpty(message = "La enfermedad actual no puede ser nula o vacía")
	private String enfermedadActual;
	@NotEmpty(message = "Los antecedentes de la enfermedad actual no pueden ser nulos o vacíos")
	private String antecedentesEnfermedad;
	@NotEmpty(message = "Los antecedentes personales no pueden ser nulos o vacíos")
	private String antecedentesPersonales;
	@NotEmpty(message = "El examen fisico no puede ser nulo o vacio")
	private String examenFisico;
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
			String diagnosticoPresuntivo, Set<EstudioComplementarioDTO> estudios, Set<PrescripcionDTO> prescripciones, String antecedentesEnfermedad, String antecedentesPersonales, String examenFisico, Date fecha) {
		super();
		this.setId(id);
		this.setMotivoConsulta(motivoConsulta);
		this.setEnfermedadActual(enfermedadActual);
		this.setDiagnosticoSintomatico(diagnosticoSintomatico);
		this.setDiagnosticoPresuntivo(diagnosticoPresuntivo);
		this.setEstudiosComplementarios(estudios);
		this.setPrescripciones(prescripciones);
		this.setFechaIngreso(fecha);
		this.setAntecedentesEnfermedad(antecedentesEnfermedad);
		this.setAntecedentesPersonales(antecedentesPersonales);
		this.setExamenFisico(examenFisico);
	}

	public IngresoPacienteDTO(Long id, String motivoConsulta, String enfermedadActual, String diagnosticoSintomatico,
			String diagnosticoPresuntivo, String antecedentesEnfermedad, String antecedentesPersonales, String examenFisico, Date fecha) {
		super();
		this.setId(id);
		this.setMotivoConsulta(motivoConsulta);
		this.setEnfermedadActual(enfermedadActual);
		this.setDiagnosticoSintomatico(diagnosticoSintomatico);
		this.setDiagnosticoPresuntivo(diagnosticoPresuntivo);
		this.setEstudiosComplementarios(new HashSet<EstudioComplementarioDTO>());
		this.setPrescripciones(new HashSet<PrescripcionDTO>());
		this.setFechaIngreso(fecha);
		this.setAntecedentesEnfermedad(antecedentesEnfermedad);
		this.setAntecedentesPersonales(antecedentesPersonales);
		this.setExamenFisico(examenFisico);

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
	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public String getAntecedentesEnfermedad() {
		return antecedentesEnfermedad;
	}

	public String getAntecedentesPersonales() {
		return antecedentesPersonales;
	}

	public String getExamenFisico() {
		return examenFisico;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public void setAntecedentesEnfermedad(String antecedentesEnfermedad) {
		this.antecedentesEnfermedad = antecedentesEnfermedad;
	}

	public void setAntecedentesPersonales(String antecedentesPersonales) {
		this.antecedentesPersonales = antecedentesPersonales;
	}

	public void setExamenFisico(String examenFisico) {
		this.examenFisico = examenFisico;
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
