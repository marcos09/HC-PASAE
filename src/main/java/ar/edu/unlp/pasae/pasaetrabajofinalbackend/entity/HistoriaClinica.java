package ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HistoriaClinica extends GenericPersistentClass {
	@Id   @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private IngresoPaciente ingreso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public IngresoPaciente getIngreso() {
		return ingreso;
	}

	public void setIngreso(IngresoPaciente ingreso) {
		this.ingreso = ingreso;
	}

	
	
}