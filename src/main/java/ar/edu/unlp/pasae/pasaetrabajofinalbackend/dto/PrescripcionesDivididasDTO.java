package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

import java.util.List;

public class PrescripcionesDivididasDTO {

	List<PrescripcionDTO> finalizadas;
	List<PrescripcionDTO> pendientes;
	
	
	public PrescripcionesDivididasDTO(List<PrescripcionDTO> finalizadas, List<PrescripcionDTO> pendientes) {
		super();
		this.finalizadas = finalizadas;
		this.pendientes = pendientes;
	}


	public List<PrescripcionDTO> getFinalizadas() {
		return finalizadas;
	}


	public void setFinalizadas(List<PrescripcionDTO> finalizadas) {
		this.finalizadas = finalizadas;
	}


	public List<PrescripcionDTO> getPendientes() {
		return pendientes;
	}


	public void setPendientes(List<PrescripcionDTO> pendientes) {
		this.pendientes = pendientes;
	}

	
	
}
