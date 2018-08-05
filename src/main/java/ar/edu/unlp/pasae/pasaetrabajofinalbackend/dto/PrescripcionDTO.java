package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

import java.util.Date;

public class PrescripcionDTO extends GenericDTOImpl {

	public PrescripcionDTO() {
		super();
	}

	
	public PrescripcionDTO(String datos, Date fecha, MedicamentoDTO medicamento, Date fechaAdm) {
		super();
		this.setDatos(datos);
		this.setFechaIndicacion(fecha);
		this.setMedicamento(medicamento);
		this.setFechaAdministracion(fechaAdm);
	}

	

	public PrescripcionDTO(Long id, String datos, Date fecha, MedicamentoDTO medicamento, Date fechaAdm) {
		super();
		this.setDatos(datos);
		this.setFechaIndicacion(fecha);
		this.setMedicamento(medicamento);
		this.setFechaAdministracion(fechaAdm);

	}

	private Date fechaIndicacion;
	private String datos;
	private MedicamentoDTO medicamento;
	private Date fechaAdministracion;
	
	public Date getFechaIndicacion() {
		return fechaIndicacion;
	}

	public void setFechaIndicacion(Date fecha) {
		this.fechaIndicacion = fecha;
	}

	public String getDatos() {
		return datos;
	}

	public void setDatos(String datos) {
		this.datos = datos;
	}

	public MedicamentoDTO getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(MedicamentoDTO medicamento) {
		this.medicamento = medicamento;
	}

	public Date getFechaAdministracion() {
		return fechaAdministracion;
	}

	public void setFechaAdministracion(Date fechaAdministracion) {
		this.fechaAdministracion = fechaAdministracion;
	}
	
	
}
