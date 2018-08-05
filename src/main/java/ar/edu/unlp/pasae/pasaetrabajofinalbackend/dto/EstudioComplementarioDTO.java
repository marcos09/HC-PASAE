package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

import java.util.Date;

public class EstudioComplementarioDTO extends GenericDTOImpl {

	private Date fechaIndicacion;
	private Date fechaResultado;
	private String informeResultado;
	private String estudioSolicitado;
	public EstudioComplementarioDTO(Long id, String estudioSolicitado,  Date fechaIndicacion, Date fechaResultado, String informeResultado) {
		super();
		this.setId(id);
		this.setEstudioSolicitado(estudioSolicitado);
		this.setFechaIndicacion(fechaIndicacion);
		this.setFechaResultado(fechaResultado);
		this.setInformeResultado(informeResultado);
	}

	public EstudioComplementarioDTO(Date fechaIndicacion, String estudioSolicitado, Date fechaResultado, String informeResultado) {
		super();
		this.setEstudioSolicitado(estudioSolicitado);
		this.setFechaIndicacion(fechaIndicacion);
		this.setFechaResultado(fechaResultado);
		this.setInformeResultado(informeResultado);
	}

	public EstudioComplementarioDTO() {
		super();
	}

	public Date getFechaIndicacion() {
		return fechaIndicacion;
	}

	public void setFechaIndicacion(Date fechaRealizacion) {
		this.fechaIndicacion = fechaRealizacion;
	}

	public Date getFechaResultado() {
		return fechaResultado;
	}

	public void setFechaResultado(Date fechaResultado) {
		this.fechaResultado = fechaResultado;
	}

	public String getInformeResultado() {
		return informeResultado;
	}

	public void setInformeResultado(String informeResultado) {
		this.informeResultado = informeResultado;
	}

	public String getEstudioSolicitado() {
		return estudioSolicitado;
	}

	public void setEstudioSolicitado(String estudioSolicitado) {
		this.estudioSolicitado = estudioSolicitado;
	}
	
	
}
