package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

public class CantidadIngresosDiagnosticoDTO {

	private String nombrePatologia;
	private Long cantidadPacientes;
	
	
	public CantidadIngresosDiagnosticoDTO(String nombrePatologia, Long cantidadPacientes) {
		super();
		this.setCantidadPacientes(cantidadPacientes);
		this.setNombrePatologia(nombrePatologia);
	}
	public String getNombrePatologia() {
		return nombrePatologia;
	}
	public void setNombrePatologia(String nombrePatologia) {
		this.nombrePatologia = nombrePatologia;
	}
	public Long getCantidadPacientes() {
		return cantidadPacientes;
	}
	public void setCantidadPacientes(Long cantidadPacientes) {
		this.cantidadPacientes = cantidadPacientes;
	}
	
	
	
	
}
