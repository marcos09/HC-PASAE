package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

import java.util.HashSet;
import java.util.Set;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Seguimiento;

public class HistoriaClinicaDTO extends GenericDTOImpl {

	private IngresoPacienteDTO ingresoDTO;
	private EgresoDTO egresoDTO;
	private Set<SeguimientoDTO> seguimientosDTO;

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
		return egresoDTO;
	}

	public void setEgreso(EgresoDTO egreso) {
		this.egresoDTO = egreso;
	}

	public IngresoPacienteDTO getIngreso() {
		return ingresoDTO;
	}

	public void setIngreso(IngresoPacienteDTO ingreso) {
		this.ingresoDTO = ingreso;
	}

	public Set<SeguimientoDTO> getSeguimientos() {
		return seguimientosDTO;
	}

	public void setSeguimientos(Set<SeguimientoDTO> seguimientos) {
		this.seguimientosDTO = seguimientos;
	}

	public void addSeguimiento(SeguimientoDTO seguimiento) {
		this.getSeguimientos().add(seguimiento);
	}

	public void removeSeguimiento(SeguimientoDTO seguimiento) {
		this.getSeguimientos().remove(seguimiento);
	}

}
