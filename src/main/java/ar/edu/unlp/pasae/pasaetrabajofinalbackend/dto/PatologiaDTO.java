package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

import javax.validation.constraints.NotEmpty;

public class PatologiaDTO extends GenericDTOImpl {

	@NotEmpty(message = "El nombre no puede ser nulo o vacío")
	private String nombre;

	private String otroDato;
	private boolean disponible;

	public PatologiaDTO() {
		super();
	}

	public PatologiaDTO(String nombre, String otroDato) {
		super();
		this.setNombre(nombre);
		this.setOtroDato(otroDato);
		this.setDisponible(true);
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public PatologiaDTO(Long id, String nombre, String otroDato, boolean b) {
		super();
		this.setId(id);
		this.setNombre(nombre);
		this.setOtroDato(otroDato);
		this.setDisponible(b);
	}

	public PatologiaDTO(Long id, String nombre) {
		super();
		this.setId(id);
		this.setNombre(nombre);
	}

	public PatologiaDTO(String nombre) {
		super();
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
