package ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class HistoriaClinica extends GenericPersistentClass {

	@OneToOne
	private IngresoPaciente ingreso;

	public IngresoPaciente getIngreso() {
		return ingreso;
	}

	public void setIngreso(IngresoPaciente ingreso) {
		this.ingreso = ingreso;
	}

	
	
}