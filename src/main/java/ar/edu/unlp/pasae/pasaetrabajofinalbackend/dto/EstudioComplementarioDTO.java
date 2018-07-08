package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

import java.util.Date;

public class EstudioComplementarioDTO extends GenericDTOImpl {

	private Long id;
	private Date fechaRealizacion;
	private Date fechaResultado;
	private String informeResultado;
	public EstudioComplementarioDTO(Long id, Date fechaRealizacion, Date fechaResultado, String informeResultado) {
		super();
		this.id = id;
		this.fechaRealizacion = fechaRealizacion;
		this.fechaResultado = fechaResultado;
		this.informeResultado = informeResultado;
	}
	public EstudioComplementarioDTO(Date fechaRealizacion, Date fechaResultado, String informeResultado) {
		super();
		this.fechaRealizacion = fechaRealizacion;
		this.fechaResultado = fechaResultado;
		this.informeResultado = informeResultado;
	}
	public EstudioComplementarioDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
