package ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Prescripcion extends GenericPersistentClass implements Comparable<Prescripcion> {

	private Date fechaIndicacion;
	private String datos;
	private Date fechaAdministracion;
	
	@OneToOne
	private Medicamento medicamento;
	
	public Prescripcion() {
		super();
	}
	
	public Prescripcion(Long id, String datos, Medicamento medicamento) {
		super();
		this.setId(id);
		this.setDatos(datos);
		this.setFechaIndicacion(new Date());
		this.setMedicamento(medicamento);
	}

	public Prescripcion(String datos, Medicamento medicamento) {
		super();
		this.setDatos(datos);
		this.setFechaIndicacion(new Date());
		this.setMedicamento(medicamento);
	}

	public Date getFechaIndicacion() {
		return fechaIndicacion;
	}

	public void setFechaIndicacion(Date fecha) {
		this.fechaIndicacion = fecha;
	}

	public String getDatos() {
		return datos;
	}

	public void setDatos(String datos) {
		this.datos = datos;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
	
	public void ejecutarPrescripcion() {
		this.setFechaAdministracion(new Date());
	}

	public Date getFechaAdministracion() {
		return fechaAdministracion;
	}

	private void setFechaAdministracion(Date fechaAdministracion) {
		this.fechaAdministracion = fechaAdministracion;
	}
	
	@Override
	public int compareTo(Prescripcion presc) {
		return this.getFechaAdministracion().compareTo(presc.getFechaAdministracion());
	}

}
