package ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class HistoriaClinica extends GenericPersistentClass {

	//Se cambió el CascadeType de {CascadeType.MERGE, CascadeType.REMOVE} a ALL
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@NotNull(message = "El ingreso no puede ser nulo o vacio")
	private IngresoPaciente ingreso;

	@OneToOne(cascade = CascadeType.ALL,  orphanRemoval = true)
	private Egreso egreso;

	@OneToOne(cascade = CascadeType.ALL,  orphanRemoval = true)
	private Paciente paciente;
	
	@NotNull(message = "La coleccion de seguimientos no puede ser nula")
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

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Collection<EstudioComplementario> getEstudiosFinalizados() {
		List<EstudioComplementario> estudios = new ArrayList<EstudioComplementario>();
		for(Seguimiento s: this.getSeguimientos()) {
			for(EstudioComplementario e: s.getEstudiosComplementarios()) {
				if(e.getFechaResultado() != null) {
					estudios.add(e);
				}
			}
			
		}
		return estudios;
	}
	
	public Collection<Prescripcion> getPrescripciones() {
		List<Prescripcion> prescripciones = new ArrayList<Prescripcion>();
		for(Seguimiento s: this.getSeguimientos()) {
			for(Prescripcion p: s.getPrescripciones()) {
				if(p.getFechaAdministracion() != null) {
					prescripciones.add(p);
				}
			}
		}
		return prescripciones;
	}

	
}