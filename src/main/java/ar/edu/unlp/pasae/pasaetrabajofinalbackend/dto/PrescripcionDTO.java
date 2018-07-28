package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

import java.util.Date;

public class PrescripcionDTO extends GenericDTOImpl {

	public PrescripcionDTO() {
		super();
	}

	public PrescripcionDTO(String datos, Date fecha, MedicamentoDTO medicamento) {
		super();
		this.setDatos(datos);
		this.setFecha(fecha);
		this.setMedicamento(medicamento);
	}
	
	public PrescripcionDTO(Long id, String datos, Date fecha, MedicamentoDTO medicamento) {
		super();
		this.setDatos(datos);
		this.setFecha(fecha);
		this.setMedicamento(medicamento);
	}

	

	private Date fecha;
	private String datos;
	private MedicamentoDTO medicamento;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
}
