package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class HistoriaClinicaDTO extends GenericDTOImpl {

	@NotNull(message = "El ingreso no puede ser nulo o vacio")
	private IngresoPacienteDTO ingreso;
	private EgresoDTO egreso;
	@NotNull(message = "La coleccion de seguimientos no puede ser nula")
	private Set<SeguimientoDTO> seguimientos;

	public HistoriaClinicaDTO() {
		super();
		this.setSeguimientos(new HashSet<SeguimientoDTO>());
	}

	public HistoriaClinicaDTO(IngresoPacienteDTO i) {
		super();
		this.setSeguimientos(new HashSet<SeguimientoDTO>());
		this.setIngreso(i);
	}

	public HistoriaClinicaDTO(Long id, IngresoPacienteDTO i) {
		super();
		this.setId(id);
		this.setSeguimientos(new HashSet<SeguimientoDTO>());
		this.setIngreso(i);
	}

	public EgresoDTO getEgreso() {
		return egreso;
	}

	public void setEgreso(EgresoDTO egreso) {
		this.egreso = egreso;
	}

	public IngresoPacienteDTO getIngreso() {
		return ingreso;
	}

	public void setIngreso(IngresoPacienteDTO ingreso) {
		this.ingreso = ingreso;
	}

	public Set<SeguimientoDTO> getSeguimientos() {
		return seguimientos;
	}

	public void setSeguimientos(Set<SeguimientoDTO> seguimientos) {
		this.seguimientos = seguimientos;
	}

	public void addSeguimiento(SeguimientoDTO seguimiento) {
		this.getSeguimientos().add(seguimiento);
	}

	public void removeSeguimiento(SeguimientoDTO seguimiento) {
		this.getSeguimientos().remove(seguimiento);
	}

}
