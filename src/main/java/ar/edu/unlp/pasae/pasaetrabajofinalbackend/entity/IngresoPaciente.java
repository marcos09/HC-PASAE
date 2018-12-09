package ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class IngresoPaciente extends GenericPersistentClass {

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
	@OneToOne
	private Patologia diagnosticoSintomatico;
	@NotNull(message = "El diagnostico presuntivo no puede ser nulo o vacío")
	@OneToOne
	private Patologia diagnosticoPresuntivo;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<EstudioComplementario> estudiosComplementarios;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Prescripcion> prescripciones;

	// Creación de un ingreso sin estudios complementarios sin estudios ni
	// indicaciones.
	public IngresoPaciente(Long id, String motivoConsulta, String enfermedadActual, Patologia diagnosticoSintomatico,
			Patologia diagnosticoPresuntivo, String antecedentesEnfermedad, String antecedentesPersonales,
			String examenFisico) {
		super();
		this.setId(id);
		this.setMotivoConsulta(motivoConsulta);
		this.setEnfermedadActual(enfermedadActual);
		this.setDiagnosticoSintomatico(diagnosticoSintomatico);
		this.setDiagnosticoPresuntivo(diagnosticoPresuntivo);
		this.setFechaIngreso(new Date());
		this.setAntecedentesEnfermedad(antecedentesEnfermedad);
		this.setAntecedentesPersonales(antecedentesPersonales);
		this.setExamenFisico(examenFisico);
		this.setEstudiosComplementarios(new HashSet<EstudioComplementario>());
		this.setPrescripciones(new HashSet<Prescripcion>());

	}

	// Ingreso con estudios e indicaciones.
	public IngresoPaciente(Long id, String motivoConsulta, String enfermedadActual, Patologia diagnosticoSintomatico,
			Patologia diagnosticoPresuntivo, Set<EstudioComplementario> estudios, Set<Prescripcion> prescripciones,
			String antecedentesEnfermedad, String antecedentesPersonales, String examenFisico) {
		super();
		this.setId(id);
		this.setMotivoConsulta(motivoConsulta);
		this.setEnfermedadActual(enfermedadActual);
		this.setDiagnosticoSintomatico(diagnosticoSintomatico);
		this.setDiagnosticoPresuntivo(diagnosticoPresuntivo);
		this.setEstudiosComplementarios(estudios);
		this.setPrescripciones(prescripciones);
		this.setFechaIngreso(new Date());
		this.setAntecedentesEnfermedad(antecedentesEnfermedad);
		this.setAntecedentesPersonales(antecedentesPersonales);
		this.setExamenFisico(examenFisico);

	}

	// Creación de un ingreso sin estudios complementarios sin estudios ni
	// indicaciones.
	public IngresoPaciente(String motivoConsulta, String enfermedadActual, Patologia diagnosticoSintomatico,
			Patologia diagnosticoPresuntivo, String antecedentesEnfermedad, String antecedentesPersonales,
			String examenFisico) {
		super();
		this.setMotivoConsulta(motivoConsulta);
		this.setEnfermedadActual(enfermedadActual);
		this.setDiagnosticoSintomatico(diagnosticoSintomatico);
		this.setDiagnosticoPresuntivo(diagnosticoPresuntivo);
		this.setEstudiosComplementarios(new HashSet<EstudioComplementario>());
		this.setPrescripciones(new HashSet<Prescripcion>());
		this.setFechaIngreso(new Date());
		this.setAntecedentesEnfermedad(antecedentesEnfermedad);
		this.setAntecedentesPersonales(antecedentesPersonales);
		this.setExamenFisico(examenFisico);

	}

	// Ingreso con estudios e indicaciones.
	public IngresoPaciente(String motivoConsulta, String enfermedadActual, Patologia diagnosticoSintomatico,
			Patologia diagnosticoPresuntivo, Set<EstudioComplementario> estudios, Set<Prescripcion> prescripciones,
			String antecedentesEnfermedad, String antecedentesPersonales, String examenFisico) {
		super();
		this.setMotivoConsulta(motivoConsulta);
		this.setEnfermedadActual(enfermedadActual);
		this.setDiagnosticoSintomatico(diagnosticoSintomatico);
		this.setDiagnosticoPresuntivo(diagnosticoPresuntivo);
		this.setEstudiosComplementarios(estudios);
		this.setPrescripciones(prescripciones);
		this.setFechaIngreso(new Date());
		this.setAntecedentesEnfermedad(antecedentesEnfermedad);
		this.setAntecedentesPersonales(antecedentesPersonales);
		this.setExamenFisico(examenFisico);

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

	public Patologia getDiagnosticoSintomatico() {
		return diagnosticoSintomatico;
	}

	private void setDiagnosticoSintomatico(Patologia diagnosticoSintomatico) {
		this.diagnosticoSintomatico = diagnosticoSintomatico;
	}

	public Patologia getDiagnosticoPresuntivo() {
		return diagnosticoPresuntivo;
	}

	private void setDiagnosticoPresuntivo(Patologia diagnosticoPresuntivo) {
		this.diagnosticoPresuntivo = diagnosticoPresuntivo;
	}

	public void editDiagnosticoPresuntivo(Patologia diagnosticoPresuntivo) {
		this.diagnosticoPresuntivo = diagnosticoPresuntivo;
	}

	public void editDiagnosticoSintomatico(Patologia diagnosticoSintomatico) {
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
