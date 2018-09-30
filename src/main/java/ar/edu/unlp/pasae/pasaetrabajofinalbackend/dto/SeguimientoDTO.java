package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

public class SeguimientoDTO extends GenericDTOImpl implements Comparable<SeguimientoDTO> {

	private Date fecha;
	private String resultado;
	@NotNull(message = "La coleccion de prescripciones no puede ser nula")
	private Set<PrescripcionDTO> prescripcionesDTO;
	@NotNull(message = "La coleccion de estudios complementarios no puede ser nula")
	private Set<EstudioComplementarioDTO> estudiosComplementariosDTO;

	public SeguimientoDTO() {
		super();
		this.setEstudiosComplementariosDTO(new HashSet<EstudioComplementarioDTO>());
		this.setPrescripcionesDTO(new HashSet<PrescripcionDTO>());
		this.setFecha(new Date());
	}

	public SeguimientoDTO(Long id, String resultado, Set<EstudioComplementarioDTO> estudios,
			Set<PrescripcionDTO> prescripciones, Date fecha) {
		super();
		this.setId(id);
		this.setResultado(resultado);
		this.setEstudiosComplementariosDTO(estudios);
		this.setPrescripcionesDTO(prescripciones);
		this.setFecha(fecha);
	}

	public SeguimientoDTO(String resultado, Set<EstudioComplementarioDTO> estudios,
			Set<PrescripcionDTO> prescripciones) {
		super();
		this.setResultado(resultado);
		this.setEstudiosComplementariosDTO(estudios);
		this.setPrescripcionesDTO(prescripciones);
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

	@Override
	public int compareTo(SeguimientoDTO seguimiento) {
		return this.getFecha().compareTo(seguimiento.getFecha());
	}

}
