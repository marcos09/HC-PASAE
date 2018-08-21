package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PatologiaDTO extends GenericDTOImpl {

	@NotEmpty(message = "El nombre no puede ser nulo o vacío")
	private String nombre;

	private String otroDato;

	private PatologiaDTO father;

	@NotNull(message = "La coleccion de hijos no puede ser nulo o vacío")
	private Set<PatologiaDTO> childs;

	public PatologiaDTO() {
		super();
		this.setChilds(new HashSet<PatologiaDTO>());
	}

	public PatologiaDTO(String nombre, String otroDato) {
		super();
		this.setNombre(nombre);
		this.setOtroDato(otroDato);
		this.setChilds(new HashSet<PatologiaDTO>());
	}

	public PatologiaDTO(Long id, String nombre) {
		super();
		this.setId(id);
		this.setNombre(nombre);
		this.setChilds(new HashSet<PatologiaDTO>());
	}

	public PatologiaDTO(String nombre) {
		super();
		this.setNombre(nombre);
		this.setChilds(new HashSet<PatologiaDTO>());
	}

	public PatologiaDTO(Long id, String nombre, String otroDato, PatologiaDTO father, Set<PatologiaDTO> childs) {
		super();
		this.setId(id);
		this.setNombre(nombre);
		this.setOtroDato(otroDato);
		this.setChilds(childs);
		if (childs != null)
			this.getChilds().addAll(childs);
		this.setFather(father);
	}
	
	public PatologiaDTO(Long id, String nombre, String otroDato, Set<PatologiaDTO> childs) {
		super();
		this.setId(id);
		this.setNombre(nombre);
		this.setOtroDato(otroDato);
		this.setChilds(childs);
		if (childs != null)
			this.getChilds().addAll(childs);
	}

	public PatologiaDTO(Long id, String nombre, String otroDato, PatologiaDTO father) {
		super();
		this.setId(id);
		this.setNombre(nombre);
		this.setOtroDato(otroDato);
		this.setFather(father);
	}

	public PatologiaDTO(Long id, String nombre, String otroDato) {
		super();
		this.setId(id);
		this.setNombre(nombre);
		this.setOtroDato(otroDato);
	}

	public PatologiaDTO(String nombre, String otroDato, PatologiaDTO father, Set<PatologiaDTO> childs) {
		super();
		this.setNombre(nombre);
		this.setOtroDato(otroDato);
		this.setChilds(childs);
		this.setFather(father);
		if (childs != null)
			this.getChilds().addAll(childs);
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

	public PatologiaDTO getFather() {
		return father;
	}

	public void setFather(PatologiaDTO father) {
		this.father = father;
	}

	public Set<PatologiaDTO> getChilds() {
		return childs;
	}

	public void setChilds(Set<PatologiaDTO> childs) {
		this.childs = childs;
	}

	public void addChild(PatologiaDTO child) {
		childs.add(child);
	}

}
