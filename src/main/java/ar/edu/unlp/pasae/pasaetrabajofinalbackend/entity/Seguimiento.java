package ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Seguimiento extends GenericPersistentClass implements Comparable<Seguimiento> {

	private Date fecha;
	private String resultado;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Prescripcion> prescripciones;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<EstudioComplementario> estudiosComplementarios;

	public Seguimiento() {
		super();
		this.setEstudiosComplementarios(new HashSet<EstudioComplementario>());
		this.setPrescripciones(new HashSet<Prescripcion>());
		this.setFecha(Calendar.getInstance().getTime());
	}
	
	public Seguimiento(Long id, String resultado, Set<EstudioComplementario> estudios, Set<Prescripcion> prescripciones) {
		super();
		this.setId(id);
		this.setResultado(resultado);
		this.setEstudiosComplementarios(estudios);
		this.setPrescripciones(prescripciones);
		this.setFecha(new Date());
	}
	
	public Seguimiento(Long id, String resultado) {
		super();
		this.setId(id);
		this.setResultado(resultado);
		this.setEstudiosComplementarios(new HashSet<EstudioComplementario>());
		this.setPrescripciones(new HashSet<Prescripcion>());
		this.setFecha(Calendar.getInstance().getTime());
	}
	
	public Seguimiento(String resultado, Set<EstudioComplementario> estudios, Set<Prescripcion> prescripciones) {
		super();
		this.setResultado(resultado);
		this.setEstudiosComplementarios(estudios);
		this.setPrescripciones(prescripciones);
		this.setFecha(Calendar.getInstance().getTime());
	}

	public Seguimiento(String resultado) {
		super();
		this.setResultado(resultado);
		this.setEstudiosComplementarios(new HashSet<EstudioComplementario>());
		this.setPrescripciones(new HashSet<Prescripcion>());
		this.setFecha(Calendar.getInstance().getTime());
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

	@Override
	public int compareTo(Seguimiento seguimiento) {
		return this.getFecha().compareTo(seguimiento.getFecha());
	}

}
