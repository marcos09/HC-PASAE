package ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Prescripcion extends GenericPersistentClass {

	private Date fecha;
	private String datos;
	
	@OneToOne
	private Medicamento medicamento;
	
	public Prescripcion() {
		super();
		
		
	}

	public Prescripcion(String datos, Medicamento medicamento) {
		super();
		this.setDatos(datos);
		this.setFecha(new Date());
		this.setMedicamento(medicamento);
	}

	public Prescripcion(Long id, String datos, Medicamento medicamento) {
		super();
		this.setId(id);
		this.setDatos(datos);
		this.setFecha(new Date());
		this.setMedicamento(medicamento);
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

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
	
	

}
