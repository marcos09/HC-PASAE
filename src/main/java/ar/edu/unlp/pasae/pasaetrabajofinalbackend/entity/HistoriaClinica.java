package ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
	private List<Seguimiento> seguimientos;

	public HistoriaClinica() {
		super();
		this.setSeguimientos(new ArrayList<Seguimiento>());
	}

	public HistoriaClinica(IngresoPaciente i) {
		super();
		this.setSeguimientos(new ArrayList<Seguimiento>());
		this.setIngreso(i);
	}
	
	public HistoriaClinica(Long id, IngresoPaciente i) {
		super();
		this.setId(id);
		this.setSeguimientos(new ArrayList<Seguimiento>());
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

	public List<Seguimiento> getSeguimientos() {
		return seguimientos;
	}

	public void setSeguimientos(List<Seguimiento> seguimientos) {
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
		
		for(EstudioComplementario e: this.getIngreso().getEstudiosComplementarios()) {
			if(e.getFechaResultado() != null) {
				estudios.add(e);
			}
		}
		
		for(Seguimiento s: this.getSeguimientos()) {
			for(EstudioComplementario e: s.getEstudiosComplementarios()) {
				if(e.getFechaResultado() != null) {
					estudios.add(e);
				}
			}
			
		}
		return estudios;
	}
	
	public Collection<Prescripcion> getPrescripcionesFinalizadas() {
		List<Prescripcion> prescripciones = new ArrayList<Prescripcion>();
		for(Prescripcion p: this.getIngreso().getPrescripciones()) {
			if(p.getFechaAdministracion() != null) {
				prescripciones.add(p);
			}
		}
		for(Seguimiento s: this.getSeguimientos()) {
			for(Prescripcion p: s.getPrescripciones()) {
				if(p.getFechaAdministracion() != null) {
					prescripciones.add(p);
				}
			}
		}
		return prescripciones;
	}

	public Collection<Prescripcion> getPrescripciones() {
		List<Prescripcion> prescripciones = new ArrayList<Prescripcion>();
		for(Prescripcion p: this.getIngreso().getPrescripciones()) {
				prescripciones.add(p);
			
		}
		for(Seguimiento s: this.getSeguimientos()) {
			for(Prescripcion p: s.getPrescripciones()) {
				prescripciones.add(p);
				
			}
		}
		return prescripciones;
	}

	public Collection<EstudioComplementario> getEstudios() {
		List<EstudioComplementario> estudios = new ArrayList<EstudioComplementario>();
		
		for(EstudioComplementario e: this.getIngreso().getEstudiosComplementarios()) {
			estudios.add(e);
		}
		for(Seguimiento s: this.getSeguimientos()) {
			for(EstudioComplementario e: s.getEstudiosComplementarios()) {
				estudios.add(e);
			}
		}
		return estudios;
	}

}