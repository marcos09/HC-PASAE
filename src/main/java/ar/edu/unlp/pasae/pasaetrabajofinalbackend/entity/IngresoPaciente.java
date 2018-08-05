package ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotEmpty;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class IngresoPaciente extends GenericPersistentClass{	

	@NotEmpty(message = "El motivo de consulta no puede ser nulo o vacío")
	private String motivoConsulta;
	@NotEmpty(message = "La enfermedad actual no puede ser nula o vacía")
	private String enfermedadActual;
	@NotEmpty(message = "El diagnostico sintomatico no puede ser nulo o vacío")
	private String diagnosticoSintomatico;
	@NotEmpty(message = "El diagnostico presuntivo no puede ser nulo o vacío")
	private String diagnosticoPresuntivo;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<EstudioComplementario> estudiosComplementarios;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Prescripcion> prescripciones;
	
	//Creación de un ingreso sin estudios complementarios sin estudios ni indicaciones.
	public IngresoPaciente(Long id, String motivoConsulta, String enfermedadActual, String diagnosticoSintomatico,
			String diagnosticoPresuntivo) {
		super();
		this.setId(id);
		this.setMotivoConsulta(motivoConsulta);
		this.setEnfermedadActual(enfermedadActual);
		this.setDiagnosticoSintomatico(diagnosticoSintomatico);
		this.setDiagnosticoPresuntivo(diagnosticoPresuntivo);
		this.setEstudiosComplementarios(new HashSet<EstudioComplementario>());
		this.setPrescripciones(new HashSet<Prescripcion>());

	}
	
	// Ingreso con estudios e indicaciones.
	public IngresoPaciente(Long id, String motivoConsulta, String enfermedadActual, String diagnosticoSintomatico,
			String diagnosticoPresuntivo, Set<EstudioComplementario> estudios,Set<Prescripcion> prescripciones ) {
		super();
		this.setId(id);
		this.setMotivoConsulta(motivoConsulta);
		this.setEnfermedadActual(enfermedadActual);
		this.setDiagnosticoSintomatico(diagnosticoSintomatico);
		this.setDiagnosticoPresuntivo(diagnosticoPresuntivo);
		this.setEstudiosComplementarios(estudios);
		this.setPrescripciones(prescripciones);

	}

	//Creación de un ingreso sin estudios complementarios sin estudios ni indicaciones.
	public IngresoPaciente(String motivoConsulta, String enfermedadActual, String diagnosticoSintomatico,
			String diagnosticoPresuntivo) {
		super();
		this.setMotivoConsulta(motivoConsulta);
		this.setEnfermedadActual(enfermedadActual);
		this.setDiagnosticoSintomatico(diagnosticoSintomatico);
		this.setDiagnosticoPresuntivo(diagnosticoPresuntivo);
		this.setEstudiosComplementarios(new HashSet<EstudioComplementario>());
		this.setPrescripciones(new HashSet<Prescripcion>());

	}
	
	// Ingreso con estudios e indicaciones.
	public IngresoPaciente(String motivoConsulta, String enfermedadActual, String diagnosticoSintomatico,
			String diagnosticoPresuntivo, Set<EstudioComplementario> estudios,Set<Prescripcion> prescripciones ) {
		super();
		this.setMotivoConsulta(motivoConsulta);
		this.setEnfermedadActual(enfermedadActual);
		this.setDiagnosticoSintomatico(diagnosticoSintomatico);
		this.setDiagnosticoPresuntivo(diagnosticoPresuntivo);
		this.setEstudiosComplementarios(estudios);
		this.setPrescripciones(prescripciones);

	}
	
	public IngresoPaciente() {
		super();
		this.setEstudiosComplementarios(new HashSet<EstudioComplementario>());
		this.setPrescripciones(new HashSet<Prescripcion>());
	}

	public String getMotivoConsulta() {
		return motivoConsulta;
	}

	private void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}

	public String getEnfermedadActual() {
		return enfermedadActual;
	}

	private void setEnfermedadActual(String enfermedadActual) {
		this.enfermedadActual = enfermedadActual;
	}

	public String getDiagnosticoSintomatico() {
		return diagnosticoSintomatico;
	}

	private void setDiagnosticoSintomatico(String diagnosticoSintomatico) {
		this.diagnosticoSintomatico = diagnosticoSintomatico;
	}
	public String getDiagnosticoPresuntivo() {
		return diagnosticoPresuntivo;
	}

	private void setDiagnosticoPresuntivo(String diagnosticoPresuntivo) {
		this.diagnosticoPresuntivo = diagnosticoPresuntivo;
	}
	
	public void editDiagnosticoPresuntivo(String diagnosticoPresuntivo) {
		this.diagnosticoPresuntivo = diagnosticoPresuntivo;
	}

	public void editDiagnosticoSintomatico(String diagnosticoSintomatico) {
		this.diagnosticoSintomatico = diagnosticoSintomatico;
	}
	public void editEnfermedadActual(String enfermedadActual) {
		this.enfermedadActual = enfermedadActual;
	}
	public void editMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}
	public Set<EstudioComplementario> getEstudiosComplementarios() {
		return estudiosComplementarios;
	}
	public void setEstudiosComplementarios(Set<EstudioComplementario> estudiosComplementarios) {
		this.estudiosComplementarios = estudiosComplementarios;
	}
	public Set<Prescripcion> getPrescripciones() {
		return prescripciones;
	}
	public void setPrescripciones(Set<Prescripcion> prescripciones) {
		this.prescripciones = prescripciones;
	}
	
	public void addEstudio(EstudioComplementario estudio) {
		this.getEstudiosComplementarios().add(estudio);
	}
	public void addPrescripcion(Prescripcion prescripcion) {
		this.getPrescripciones().add(prescripcion);
	}
	public void removeEstudio(EstudioComplementario estudio) {
		this.getEstudiosComplementarios().remove(estudio);
	}
	public void removePrescripcion(Prescripcion prescripcion) {
		this.getPrescripciones().remove(prescripcion);
	}
	
	public void editId(Long id) {
		this.setId(id);
	}

	
}
	
