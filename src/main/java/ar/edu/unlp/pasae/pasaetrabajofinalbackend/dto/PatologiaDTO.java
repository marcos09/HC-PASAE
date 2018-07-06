package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

import java.util.HashSet;
import java.util.Set;

public class PatologiaDTO extends GenericDTOImpl {
	
	private String nombre, otroDato;
	private PatologiaDTO father;
	private Set<PatologiaDTO> childs;
	public PatologiaDTO() {
		super();
		this.setChilds(new HashSet<PatologiaDTO>());
	}

	public PatologiaDTO(String nombre, String otroDato) {
		super();
		this.nombre = nombre;
		this.otroDato = otroDato;
	}

	public PatologiaDTO(String nombre, String otroDato, PatologiaDTO father, Set<PatologiaDTO> childs) {
		super();
		this.setNombre(nombre);
		this.setOtroDato(otroDato);
		this.setChilds(childs);
		this.setFather(father);
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
