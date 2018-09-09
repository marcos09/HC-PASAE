package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

import java.util.Date;

public class HistoriaCompactaDTO extends GenericDTOImpl{
	private Long idHistoria;
	private Long idPaciente;
	private String nombrePaciente;
	private String enfermedadActual;
	private String motivoConsulta;
	private Date fechaIngreso;
	
	
	public HistoriaCompactaDTO(Long idHistoria, Long idPaciente, String nombrePaciente, String enfermedadActual,
			String motivoConsulta, Date fechaIngreso) {
		super();
		this.idHistoria = idHistoria;
		this.idPaciente = idPaciente;
		this.nombrePaciente = nombrePaciente;
		this.enfermedadActual = enfermedadActual;
		this.motivoConsulta = motivoConsulta;
		this.fechaIngreso = fechaIngreso;
	}
	
	public Long getIdHistoria() {
		return idHistoria;
	}
	public void setIdHistoria(Long idHistoria) {
		this.idHistoria = idHistoria;
	}
	public Long getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getNombrePaciente() {
		return nombrePaciente;
	}
	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}
	public String getEnfermedadActual() {
		return enfermedadActual;
	}
	public void setEnfermedadActual(String enfermedadActual) {
		this.enfermedadActual = enfermedadActual;
	}
	public String getMotivoConsulta() {
		return motivoConsulta;
	}
	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
}
