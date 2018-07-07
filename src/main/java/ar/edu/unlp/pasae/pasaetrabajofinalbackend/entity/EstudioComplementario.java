package ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class EstudioComplementario extends GenericPersistentClass{
	
	@Id   @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	private Date fechaRealizacion;
	private Date fechaResultado;
	private String informeResultado;
	
	
	
	public EstudioComplementario(Long id, Date fechaRealizacion, Date fechaResultado, String informeResultado) {
		super();
		this.id = id;
		this.fechaRealizacion = fechaRealizacion;
		this.fechaResultado = fechaResultado;
		this.informeResultado = informeResultado;
	}
	
	
	
	public EstudioComplementario(Date fechaRealizacion, Date fechaResultado, String informeResultado) {
		super();
		this.fechaRealizacion = fechaRealizacion;
		this.fechaResultado = fechaResultado;
		this.informeResultado = informeResultado;
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
