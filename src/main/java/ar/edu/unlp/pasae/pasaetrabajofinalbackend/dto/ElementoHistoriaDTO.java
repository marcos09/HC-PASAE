package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

import java.util.Date;

public class ElementoHistoriaDTO extends GenericDTOImpl implements Comparable<ElementoHistoriaDTO> {
	
	private String tipoElemento; 
	private Date fecha;
	
	
	
	public ElementoHistoriaDTO() {
		super();
	}

	public ElementoHistoriaDTO(Long id, String tipoElemento, Date fecha) {
		super();
		this.setId(id);
		this.setFecha(fecha);
		this.setTipoElemento(tipoElemento);
	}
	
	
	public String getTipoElemento() {
		return tipoElemento;
	}
	public void setTipoElemento(String tipoElemento) {
		this.tipoElemento = tipoElemento;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public int compareTo(ElementoHistoriaDTO elemento) {
		return this.getFecha().compareTo(elemento.getFecha());
	}
	
	
	
}
