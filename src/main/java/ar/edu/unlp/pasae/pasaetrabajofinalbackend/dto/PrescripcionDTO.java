package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

import java.util.Date;

public class PrescripcionDTO extends GenericDTOImpl {

	public PrescripcionDTO() {
		// TODO Auto-generated constructor stub
	}

	public PrescripcionDTO(String datos, Date fecha) {
		// TODO Auto-generated constructor stub
		super();
		this.setDatos(datos);
		this.setFecha(fecha);
	}

	private Date fecha;
	private String datos;

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
