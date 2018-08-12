package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

import java.util.List;

public class HistoriaOrdenadaDTO extends HistoriaClinicaDTO{

	List<PrescripcionDTO> aplicaciones;
	List<EstudioComplementarioDTO> estudios;
	
	public List<PrescripcionDTO> getAplicaciones() {
		return aplicaciones;
	}
	public void setAplicaciones(List<PrescripcionDTO> aplicaciones) {
		this.aplicaciones = aplicaciones;
	}
	public List<EstudioComplementarioDTO> getEstudios() {
		return estudios;
	}
	public void setEstudios(List<EstudioComplementarioDTO> estudios) {
		this.estudios = estudios;
	}
}
