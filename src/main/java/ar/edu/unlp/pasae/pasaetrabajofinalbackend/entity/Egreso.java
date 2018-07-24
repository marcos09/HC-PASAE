package ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotEmpty;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Egreso extends GenericPersistentClass {

	public Egreso() {
		super();
	}

	public Egreso(String diagnosticoFinal) {
		super();
		this.setDiagnosticoFinal(diagnosticoFinal);
	}
	
	public Egreso(Long id, String diagnosticoFinal, Date fecha) {
		super();
		this.setId(id);
		this.setDiagnosticoFinal(diagnosticoFinal);
		this.setFecha(fecha);
	}

	@NotEmpty
	private String diagnosticoFinal;
	
	private Date fecha;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDiagnosticoFinal() {
		return diagnosticoFinal;
	}

	public void setDiagnosticoFinal(String diagnosticoFinal) {
		this.diagnosticoFinal = diagnosticoFinal;
	}

}
