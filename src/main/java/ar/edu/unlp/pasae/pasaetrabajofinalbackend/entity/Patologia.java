package ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Patologia extends GenericPersistentClass {

	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Patologia father;

	@NotFound(action = NotFoundAction.IGNORE)
	@NotNull(message = "La coleccion de hijos no puede ser nulo o vacío")
	@OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<Patologia> childs;

	@NotEmpty(message = "El nombre no puede ser nulo o vacío")
	private String nombre;

	private String otroDato;

	public Patologia(String nombre, String otroDato) {
		super();
		this.setNombre(nombre);
		this.setOtroDato(otroDato);
		this.setChilds(new HashSet<Patologia>());
	}
	
	public Patologia(String nombre) {
		super();
		this.setNombre(nombre);
		this.setChilds(new HashSet<Patologia>());
	}

	public Patologia(Long id, String nombre, String otroDato) {
		super();
		this.setId(id);
		this.setNombre(nombre);
		this.setOtroDato(otroDato);
		this.setChilds(new HashSet<Patologia>());
	}
	
	public Patologia(Long id, String nombre) {
		super();
		this.setId(id);
		this.setNombre(nombre);
		this.setChilds(new HashSet<Patologia>());
	}

	public Patologia(Long id, Patologia father, Set<Patologia> childs, String nombre, String otroDato) {
		super();
		this.setId(id);
		this.setFather(father);
		this.setChilds(childs);
		this.setNombre(nombre);
		this.setOtroDato(otroDato);
	}


	public Patologia(Long id, String nombre, String otroDato, Set<Patologia> childs) {
		super();
		this.setId(id);
		this.setNombre(nombre);
		this.setOtroDato(otroDato);
		this.setChilds(childs);
	}
	public Patologia() {
		super();
		this.setChilds(new HashSet<Patologia>());	}

	public Patologia(Long id, String nombre, String otroDato, Patologia father) {
		super();
		this.setId(id);
		this.setNombre(nombre);
		this.setOtroDato(otroDato);
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

	public Patologia getFather() {
		return father;
	}

	public void setFather(Patologia father) {
		this.father = father;
	}

	public Set<Patologia> getChilds() {
		return childs;
	}

	public void setChilds(Set<Patologia> childs) {
		this.childs = childs;
	}

	public void addChild(Patologia patologia) {
		this.childs.add(patologia);
	}

	public void removeChild(Patologia patologia) {
		this.getChilds().remove(patologia);
	}

	public void removeChilds(Collection<Patologia> patologias) {
		this.getChilds().removeAll(patologias);
	}

}
