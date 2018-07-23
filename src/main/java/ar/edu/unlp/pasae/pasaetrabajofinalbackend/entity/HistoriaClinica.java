package ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class HistoriaClinica extends GenericPersistentClass {

	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
	private IngresoPaciente ingreso;

	@OneToOne(cascade = CascadeType.ALL,  orphanRemoval = true)
	private Egreso egreso;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Seguimiento> seguimientos;

	public HistoriaClinica() {
		super();
		this.setSeguimientos(new HashSet<Seguimiento>());
	}

	public HistoriaClinica(IngresoPaciente i) {
		super();
		this.setSeguimientos(new HashSet<Seguimiento>());
		this.setIngreso(i);
	}
	
	public HistoriaClinica(Long id, IngresoPaciente i) {
		super();
		this.setId(id);
		this.setSeguimientos(new HashSet<Seguimiento>());
		this.setIngreso(i);
	}

	public Egreso getEgreso() {
		return egreso;
	}

	public void setEgreso(Egreso egreso) {
		this.egreso = egreso;
	}

	public IngresoPaciente getIngreso() {
		return ingreso;
	}

	public void setIngreso(IngresoPaciente ingreso) {
		this.ingreso = ingreso;
	}

	public Set<Seguimiento> getSeguimientos() {
		return seguimientos;
	}

	public void setSeguimientos(Set<Seguimiento> seguimientos) {
		this.seguimientos = seguimientos;
	}

	public void addSeguimiento(Seguimiento seguimiento) {
		this.getSeguimientos().add(seguimiento);
	}

	public void removeSeguimiento(Seguimiento seguimiento) {
		this.getSeguimientos().remove(seguimiento);
	}

}