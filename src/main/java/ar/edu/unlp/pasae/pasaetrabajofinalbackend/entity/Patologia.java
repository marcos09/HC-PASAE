package ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotEmpty;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Patologia extends GenericPersistentClass {

	public Patologia() {
		super();
	}

	@NotEmpty(message = "El nombre no puede ser nulo o vacío")
	private String nombre;

	private String otroDato;

	public Patologia(String nombre, String otroDato) {
		super();
		this.setNombre(nombre);
		this.setOtroDato(otroDato);
	}

	public Patologia(String nombre) {
		super();
		this.setNombre(nombre);
	}

	public Patologia(Long id, String nombre, String otroDato) {
		super();
		this.setId(id);
		this.setNombre(nombre);
		this.setOtroDato(otroDato);
	}

	public Patologia(Long id, String nombre) {
		super();
		this.setId(id);
		this.setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getOtroDato() {
		return otroDato;
	}

	public void setOtroDato(String otroDato) {
		this.otroDato = otroDato;
	}

}
