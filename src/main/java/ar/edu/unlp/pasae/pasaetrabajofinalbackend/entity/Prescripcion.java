package ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Prescripcion extends GenericPersistentClass {

	private Date fecha;
	private String datos;

	public Prescripcion() {
		super();
	}

	public Prescripcion(String datos, Date fecha) {
		// TODO Auto-generated constructor stub
		super();
		this.setDatos(datos);
		this.setFecha(fecha);
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDatos() {
		return datos;
	}

	public void setDatos(String datos) {
		this.datos = datos;
	}

}
