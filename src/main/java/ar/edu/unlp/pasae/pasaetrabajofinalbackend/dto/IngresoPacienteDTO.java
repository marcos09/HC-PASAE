package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class IngresoPacienteDTO extends GenericDTOImpl {

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
	@NotNull(message = "El diagnostico sintomatico no puede ser nulo o vacío")
	private PatologiaDTO diagnosticoSintomatico;
	@NotNull(message = "El diagnostico presuntivo no puede ser nulo o vacío")
	private PatologiaDTO diagnosticoPresuntivo;

	private Set<EstudioComplementarioDTO> estudiosComplementariosDTO;
	private Set<PrescripcionDTO> prescripcionesDTO;

	public IngresoPacienteDTO() {
		super();
		this.setEstudiosComplementariosDTO(new HashSet<EstudioComplementarioDTO>());
		this.setPrescripcionesDTO(new HashSet<PrescripcionDTO>());
		
	}

	public IngresoPacienteDTO(Long id, String motivoConsulta, String enfermedadActual,
			PatologiaDTO diagnosticoSintomatico, PatologiaDTO diagnosticoPresuntivo,
			Set<EstudioComplementarioDTO> estudios, Set<PrescripcionDTO> prescripciones, String antecedentesEnfermedad,
			String antecedentesPersonales, String examenFisico, Date fecha) {
		super();
		this.setId(id);
		this.setMotivoConsulta(motivoConsulta);
		this.setEnfermedadActual(enfermedadActual);
		this.setDiagnosticoSintomatico(diagnosticoSintomatico);
		this.setDiagnosticoPresuntivo(diagnosticoPresuntivo);
		this.setEstudiosComplementariosDTO(estudios);
		this.setPrescripcionesDTO(prescripciones);
		this.setFechaIngreso(fecha);
		this.setAntecedentesEnfermedad(antecedentesEnfermedad);
		this.setAntecedentesPersonales(antecedentesPersonales);
		this.setExamenFisico(examenFisico);
	}

	public IngresoPacienteDTO(Long id, String motivoConsulta, String enfermedadActual,
			PatologiaDTO diagnosticoSintomatico, PatologiaDTO diagnosticoPresuntivo, String antecedentesEnfermedad,
			String antecedentesPersonales, String examenFisico, Date fecha) {
		super();
		this.setId(id);
		this.setMotivoConsulta(motivoConsulta);
		this.setEnfermedadActual(enfermedadActual);
		this.setDiagnosticoSintomatico(diagnosticoSintomatico);
		this.setDiagnosticoPresuntivo(diagnosticoPresuntivo);
		this.setEstudiosComplementariosDTO(new HashSet<EstudioComplementarioDTO>());
		this.setPrescripcionesDTO(new HashSet<PrescripcionDTO>());
		this.setFechaIngreso(fecha);
		this.setAntecedentesEnfermedad(antecedentesEnfermedad);
		this.setAntecedentesPersonales(antecedentesPersonales);
		this.setExamenFisico(examenFisico);

	}
	
	public IngresoPacienteDTO( String motivoConsulta, String enfermedadActual,
			PatologiaDTO diagnosticoSintomatico, PatologiaDTO diagnosticoPresuntivo, String antecedentesEnfermedad,
			String antecedentesPersonales, String examenFisico, Date fecha) {
		super();
		this.setMotivoConsulta(motivoConsulta);
		this.setEnfermedadActual(enfermedadActual);
		this.setDiagnosticoSintomatico(diagnosticoSintomatico);
		this.setDiagnosticoPresuntivo(diagnosticoPresuntivo);
		this.setEstudiosComplementariosDTO(new HashSet<EstudioComplementarioDTO>());
		this.setPrescripcionesDTO(new HashSet<PrescripcionDTO>());
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

	public PatologiaDTO getDiagnosticoSintomatico() {
		return diagnosticoSintomatico;
	}

	public void setDiagnosticoSintomatico(PatologiaDTO diagnosticoSintomatico) {
		this.diagnosticoSintomatico = diagnosticoSintomatico;
	}

	public PatologiaDTO getDiagnosticoPresuntivo() {
		return diagnosticoPresuntivo;
	}

	public void setDiagnosticoPresuntivo(PatologiaDTO diagnosticoPresuntivo) {
		this.diagnosticoPresuntivo = diagnosticoPresuntivo;
	}

	public Set<EstudioComplementarioDTO> getEstudiosComplementariosDTO() {
		return estudiosComplementariosDTO;
	}

	public void setEstudiosComplementariosDTO(Set<EstudioComplementarioDTO> estudiosComplementarios) {
		this.estudiosComplementariosDTO = estudiosComplementarios;
	}

	public Set<PrescripcionDTO> getPrescripcionesDTO() {
		return prescripcionesDTO;
	}

	public void setPrescripcionesDTO(Set<PrescripcionDTO> prescripciones) {
		this.prescripcionesDTO = prescripciones;
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
		this.getEstudiosComplementariosDTO().add(estudio);
	}

	public void addPrescripcion(PrescripcionDTO prescripcion) {
		this.getPrescripcionesDTO().add(prescripcion);
	}

	public void removeEstudio(EstudioComplementarioDTO estudio) {
		this.getEstudiosComplementariosDTO().remove(estudio);
	}

	public void removePrescripcion(PrescripcionDTO prescripcion) {
		this.getPrescripcionesDTO().remove(prescripcion);
	}

}
