package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

public class IngresoPacienteDTO implements GenericDTO{
	
	private Long id;
	private String motivoConsulta;
	private String enfermedadActual;
	private String diagnosticoSintomatico;
	private String diagnosticoPresuntivo;
	
	
	public IngresoPacienteDTO() {
		super();
	}

	public IngresoPacienteDTO(Long id, String motivoConsulta, String enfermedadActual, String diagnosticoSintomatico,
			String diagnosticoPresuntivo) {
		super();
		this.setId(id);
		this.setMotivoConsulta(motivoConsulta);
		this.setEnfermedadActual(enfermedadActual);
		this.setDiagnosticoSintomatico(diagnosticoSintomatico);
		this.setDiagnosticoPresuntivo(diagnosticoPresuntivo);
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
	
	

}
