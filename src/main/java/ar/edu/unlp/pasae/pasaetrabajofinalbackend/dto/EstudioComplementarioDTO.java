package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

import java.util.Date;

public class EstudioComplementarioDTO extends GenericDTOImpl {

	private Date fechaRealizacion;
	private Date fechaResultado;
	private String informeResultado;

	public EstudioComplementarioDTO(Long id, Date fechaRealizacion, Date fechaResultado, String informeResultado) {
		super();
		this.setId(id);
		this.setFechaRealizacion(fechaRealizacion);
		this.setFechaResultado(fechaResultado);
		this.setInformeResultado(informeResultado);
	}

	public EstudioComplementarioDTO(Date fechaRealizacion, Date fechaResultado, String informeResultado) {
		super();
		this.setFechaRealizacion(fechaRealizacion);
		this.setFechaResultado(fechaResultado);
		this.setInformeResultado(informeResultado);
	}

	public EstudioComplementarioDTO() {
		super();
	}

	public Date getFechaRealizacion() {
		return fechaRealizacion;
	}

	public void setFechaRealizacion(Date fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
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
}
