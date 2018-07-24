package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

import java.util.Date;

public class EgresoDTO extends GenericDTOImpl {

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
	private String diagnosticoFinal;
	
	private Date fecha;

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
