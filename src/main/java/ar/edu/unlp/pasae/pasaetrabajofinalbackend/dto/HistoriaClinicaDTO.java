package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;

public class HistoriaClinicaDTO extends GenericDTOImpl {

	@NotNull(message = "El ingreso no puede ser nulo o vacio")
	private IngresoPacienteDTO ingreso;
	private EgresoDTO egreso;
	@NotNull(message = "La coleccion de seguimientos no puede ser nula")
	private List<SeguimientoDTO> seguimientos;

	private PacienteDTO pacienteDTO;
	
	public HistoriaClinicaDTO() {
		super();
		this.setSeguimientos(new ArrayList<SeguimientoDTO>());
	}

	public HistoriaClinicaDTO(IngresoPacienteDTO i) {
		super();
		this.setSeguimientos(new ArrayList<SeguimientoDTO>());
		this.setIngreso(i);
	}

	public HistoriaClinicaDTO(Long id, IngresoPacienteDTO i) {
		super();
		this.setId(id);
		this.setSeguimientos(new ArrayList<SeguimientoDTO>());
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

	public List<SeguimientoDTO> getSeguimientos() {
		return seguimientos;
	}

	public void setSeguimientos(List<SeguimientoDTO> seguimientos) {
		this.seguimientos = seguimientos;
	}

	public void addSeguimiento(SeguimientoDTO seguimiento) {
		this.getSeguimientos().add(seguimiento);
	}

	public void removeSeguimiento(SeguimientoDTO seguimiento) {
		this.getSeguimientos().remove(seguimiento);
	}

	public PacienteDTO getPacienteDTO() {
		return pacienteDTO;
	}

	public void setPacienteDTO(PacienteDTO pacienteDTO) {
		this.pacienteDTO = pacienteDTO;
	}
	
}
