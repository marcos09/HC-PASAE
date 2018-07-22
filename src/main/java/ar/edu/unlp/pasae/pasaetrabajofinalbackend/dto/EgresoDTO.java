package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

public class EgresoDTO extends GenericDTOImpl {

	public EgresoDTO() {
		super();
	}

	public EgresoDTO(String diagnosticoFinal) {
		super();
		this.setDiagnosticoFinal(diagnosticoFinal);
	}

	private String diagnosticoFinal;

	public String getDiagnosticoFinal() {
		return diagnosticoFinal;
	}

	public void setDiagnosticoFinal(String diagnosticoFinal) {
		this.diagnosticoFinal = diagnosticoFinal;
	}

}
