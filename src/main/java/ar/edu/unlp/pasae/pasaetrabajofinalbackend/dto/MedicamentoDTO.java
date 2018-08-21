package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

import javax.validation.constraints.NotEmpty;

public class MedicamentoDTO extends GenericDTOImpl {

	@NotEmpty(message = "El nombre no puede ser nulo o vacío")
	private String nombre;

	@NotEmpty(message = "Las indicaciones no pueden ser nulas o vacias")
	private String indicaciones;

	@NotEmpty(message = "Las contra-indicaciones no pueden ser nulas o vacias")
	private String contraindicaciones;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIndicaciones() {
		return indicaciones;
	}

	public void setIndicaciones(String indicaciones) {
		this.indicaciones = indicaciones;
	}

	public String getContraindicaciones() {
		return contraindicaciones;
	}

	public void setContraindicaciones(String contraindicaciones) {
		this.contraindicaciones = contraindicaciones;
	}

	public MedicamentoDTO(String nombre, String indicaciones, String contraindicaciones) {
		super();
		this.setNombre(nombre);
		this.setIndicaciones(indicaciones);
		this.setContraindicaciones(contraindicaciones);
	}

	public MedicamentoDTO(Long id, String nombre, String indicaciones, String contraindicaciones) {
		super();
		this.setId(id);
		this.setNombre(nombre);
		this.setIndicaciones(indicaciones);
		this.setContraindicaciones(contraindicaciones);
	}

}
