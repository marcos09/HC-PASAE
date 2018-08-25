package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PrescripcionDTO extends GenericDTOImpl {

	private Date fechaIndicacion;
	@NotEmpty(message = "Los datos no pueden ser nulos o vacíos")
	private String datos;
	@NotNull(message = "El medicamento no puede ser nulo o vacío")
	private MedicamentoDTO medicamento;

	private Date fechaAdministracion;

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
		this.setId(id);
		this.setDatos(datos);
		this.setFechaIndicacion(fecha);
		this.setMedicamento(medicamento);
		this.setFechaAdministracion(fechaAdm);

	}

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
