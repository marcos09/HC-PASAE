package ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class HistoriaClinica extends GenericPersistentClass {

	@OneToOne
	private IngresoPaciente ingreso;
	
	@OneToOne
	private Egreso egreso;

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

	
	
}