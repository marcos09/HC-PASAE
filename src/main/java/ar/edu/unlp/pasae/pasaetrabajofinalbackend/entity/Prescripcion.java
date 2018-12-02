package ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.ObjectUtils;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Prescripcion extends GenericPersistentClass implements Comparable<Prescripcion> {

	private Date fechaIndicacion;
	@NotEmpty(message = "Los datos no pueden ser nulos o vacíos")
	private String datos;
	@NotNull(message = "El medicamento no puede ser nulo o vacío")
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private Medicamento medicamento;

	private Date fechaAdministracion;

	public Prescripcion() {
		super();
		this.setFechaIndicacion(new Date());
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
	
	public Prescripcion(Long id, String datos, Medicamento medicamento, Date fechaAdm) {
		super();
		this.setId(id);
		this.setDatos(datos);
		this.setFechaIndicacion(new Date());
		this.setMedicamento(medicamento);
		this.setFechaAdministracion(fechaAdm);

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
	public int compareTo(Prescripcion prescripcion) {
		return ObjectUtils.compare(this.getFechaAdministracion(), prescripcion.getFechaAdministracion());

	}

}
