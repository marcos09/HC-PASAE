package ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotEmpty;

@Entity
@PrimaryKeyJoinColumn(name = "id")

public class Medicamento extends GenericPersistentClass {

	@NotEmpty(message = "El nombre no puede ser nulo o vacío")
	private String nombre;

	@NotEmpty(message = "Las indicaciones no pueden ser nulas o vacias")
	private String indicaciones;

	@NotEmpty(message = "Las contra-indicaciones no pueden ser nulas o vacias")
	private String contraindicaciones;

	public Medicamento() {
		super();
	}

	public Medicamento(String nombre, String indicaciones, String contraindicaciones) {
		super();
		this.setNombre(nombre);
		this.setIndicaciones(indicaciones);
		this.setContraindicaciones(contraindicaciones);
	}

	public Medicamento(Long id, String nombre, String indicaciones, String contraindicaciones) {
		super();
		this.setId(id);
		this.setNombre(nombre);
		this.setIndicaciones(indicaciones);
		this.setContraindicaciones(contraindicaciones);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIndicaciones() {
		return indicaciones;
	}

	public void setIndicaciones(String indicaciones) {
		this.indicaciones = indicaciones;
	}

	public String getContraindicaciones() {
		return contraindicaciones;
	}

	public void setContraindicaciones(String contraindicaciones) {
		this.contraindicaciones = contraindicaciones;
	}
}
