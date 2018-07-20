package ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class EstudioComplementario extends GenericPersistentClass{
	

	private Date fechaRealizacion;
	private Date fechaResultado;
	private String informeResultado;
	
	
	
	public EstudioComplementario(Long id, Date fechaRealizacion, Date fechaResultado, String informeResultado) {
		super();
		this.setId(id);
		this.setFechaRealizacion(fechaRealizacion);
		this.setFechaResultado(fechaResultado);
		this.setInformeResultado(informeResultado);
	}
	
	
	
	public EstudioComplementario(Date fechaRealizacion, Date fechaResultado, String informeResultado) {
		super();
		this.setFechaRealizacion(fechaRealizacion);
		this.setFechaResultado(fechaResultado);
		this.setInformeResultado(informeResultado);
	}

	public EstudioComplementario() {
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
