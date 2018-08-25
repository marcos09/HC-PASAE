package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class EgresoDTO extends GenericDTOImpl {

	@NotEmpty(message = "El diagnostico final no puede ser nulo o vacio")
	private String diagnosticoFinal;

	private Date fecha;

	public EgresoDTO() {
		super();
		this.setFecha(new Date());
	}

	public EgresoDTO(String diagnosticoFinal) {
		super();
		this.setDiagnosticoFinal(diagnosticoFinal);
	}

	public EgresoDTO(Long id, String diagnosticoFinal, Date fecha) {
		super();
		this.setId(id);
		this.setDiagnosticoFinal(diagnosticoFinal);
		this.setFecha(fecha);
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDiagnosticoFinal() {
		return diagnosticoFinal;
	}

	public void setDiagnosticoFinal(String diagnosticoFinal) {
		this.diagnosticoFinal = diagnosticoFinal;
	}

}
