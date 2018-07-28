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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Patologia extends GenericPersistentClass {
	
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Patologia father;
	
	@NotFound(action = NotFoundAction.IGNORE)
	
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER,   orphanRemoval = true)
	private Set<Patologia> childs;
	
	private String nombre, otroDato;
	
	public Patologia(String nombre, String otroDato) {
		super();
		this.setNombre(nombre);
		this.setOtroDato(otroDato);
	}
	
	
	public Patologia(Long id, String nombre, String otroDato) {
		super();
		this.setId(id);
		this.setNombre(nombre);
		this.setOtroDato(otroDato);
	}

	
	public Patologia(Long id, Patologia father, Set<Patologia> childs, String nombre, String otroDato) {
		super();
		this.setId(id);
		this.setFather(father);
		this.setChilds(new HashSet<Patologia>());
		if(childs != null)
			this.getChilds().addAll(childs);
		this.setNombre(nombre);
		this.setOtroDato(otroDato);
	}


	public Patologia() {
		super();
		setChilds(new HashSet<>());

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
		this.getChilds().add(patologia);
	}
	
	public void removeChild(Patologia patologia) {
		this.getChilds().remove(patologia);
	}
	public void removeChilds(Collection<Patologia> patologias) {
		this.getChilds().removeAll(patologias);
	}
	
}
