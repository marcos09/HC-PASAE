package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

public class CantidadPrescripcionesMedicamentoDTO {

	private String nombreMedicamento;
	private Long cantidadPrescripciones;
	
	
	public CantidadPrescripcionesMedicamentoDTO(String nombreMedicamento, Long cantidadPrescripciones) {
		super();
		this.setNombreMedicamento(nombreMedicamento);
		this.setCantidadPrescripciones(cantidadPrescripciones);
	}
	
	public String getNombreMedicamento() {
		return nombreMedicamento;
	}
	public void setNombreMedicamento(String nombreMedicamento) {
		this.nombreMedicamento = nombreMedicamento;
	}
	public Long getCantidadPrescripciones() {
		return cantidadPrescripciones;
	}
	public void setCantidadPrescripciones(Long cantidadPrescripciones) {
		this.cantidadPrescripciones = cantidadPrescripciones;
	}
	
	
}
