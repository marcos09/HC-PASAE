package ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class IngresoPaciente extends GenericPersistentClass {
	@Id   @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	
	@NotEmpty(message = "El motivo de consulta no puede ser nulo o vacío")
	private String motivoConsulta;
	@NotEmpty(message = "La enfermedad actual no puede ser nula o vacía")
	private String enfermedadActual;
	@NotEmpty(message = "El diagnostico sintomatico no puede ser nulo o vacío")
	private String diagnosticoSintomatico;
	@NotEmpty(message = "El diagnostico presuntivo no puede ser nulo o vacío")
	private String diagnosticoPresuntivo;
	
	
	
	public IngresoPaciente(Long id, String motivoConsulta, String enfermedadActual, String diagnosticoSintomatico,
			String diagnosticoPresuntivo) {
		super();
		this.setId(id);
		this.setMotivoConsulta(motivoConsulta);
		this.setEnfermedadActual(enfermedadActual);
		this.setDiagnosticoSintomatico(diagnosticoSintomatico);
		this.setDiagnosticoPresuntivo(diagnosticoPresuntivo);
	}

	public IngresoPaciente() {
		super();
	}

	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
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
	public void editId(Long id) {
		this.id = id;
	}

}
	
