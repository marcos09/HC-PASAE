package ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Seguimiento extends GenericPersistentClass {

	private Date fecha;
	private String resultado;

	@OneToMany
	private Set<Prescripcion> prescripciones;

	@OneToMany
	private Set<EstudioComplementario> estudiosComplementarios;

	public Seguimiento() {
		super();
		this.setEstudiosComplementarios(new HashSet<EstudioComplementario>());
		this.setPrescripciones(new HashSet<Prescripcion>());
		this.setFecha(new Date());
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Set<Prescripcion> getPrescripciones() {
		return prescripciones;
	}

	public void setPrescripciones(Set<Prescripcion> prescripciones) {
		this.prescripciones = prescripciones;
	}

	public Set<EstudioComplementario> getEstudiosComplementarios() {
		return estudiosComplementarios;
	}

	public void setEstudiosComplementarios(Set<EstudioComplementario> estudiosComplementarios) {
		this.estudiosComplementarios = estudiosComplementarios;
	}

}
