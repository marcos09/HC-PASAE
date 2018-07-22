package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SeguimientoDTO extends GenericDTOImpl {

	private Date fecha;
	private String resultado;
	private Set<PrescripcionDTO> prescripcionesDTO;
	private Set<EstudioComplementarioDTO> estudiosComplementariosDTO;

	public SeguimientoDTO() {
		super();
		this.setEstudiosComplementariosDTO(new HashSet<EstudioComplementarioDTO>());
		this.setPrescripcionesDTO(new HashSet<PrescripcionDTO>());
		this.setFecha(new Date());
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Set<PrescripcionDTO> getPrescripcionesDTO() {
		return prescripcionesDTO;
	}

	public void setPrescripcionesDTO(Set<PrescripcionDTO> prescripciones) {
		this.prescripcionesDTO = prescripciones;
	}

	public Set<EstudioComplementarioDTO> getEstudiosComplementariosDTO() {
		return estudiosComplementariosDTO;
	}

	public void setEstudiosComplementariosDTO(Set<EstudioComplementarioDTO> estudiosComplementarios) {
		this.estudiosComplementariosDTO = estudiosComplementarios;
	}

}
