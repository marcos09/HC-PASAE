package ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class HistoriaClinica extends GenericPersistentClass {

	@OneToOne
	private IngresoPaciente ingreso;
	
	@OneToOne
	private Egreso egreso;
	
	@OneToMany
	private Set<Seguimiento> seguimientos;
	
	public HistoriaClinica() {
		super();
		this.setSeguimientos(new HashSet<Seguimiento>());
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

	
	
}