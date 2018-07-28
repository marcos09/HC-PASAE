package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

public class MedicamentoDTO extends GenericDTOImpl{
	private String nombre;
	private String indicaciones;
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
