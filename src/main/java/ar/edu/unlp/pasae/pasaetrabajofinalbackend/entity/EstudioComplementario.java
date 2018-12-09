package ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotEmpty;

import org.apache.commons.lang3.ObjectUtils;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class EstudioComplementario extends GenericPersistentClass implements Comparable<EstudioComplementario> {

	private Date fechaIndicacion;
	private Date fechaResultado;
	private String informeResultado;
	@NotEmpty(message = "El estudio solicitado no puede ser nulo o vacio")
	private String estudioSolicitado;

	public EstudioComplementario(Long id, String estudioSolicitado) {
		super();
		this.setId(id);
		this.setEstudioSolicitado(estudioSolicitado);
		this.setFechaIndicacion(new Date());
	}

	public EstudioComplementario(Date fecIndicacion, String estudioSolicitado, Date fechaResultado,
			String informeResultado) {
		super();
		this.setEstudioSolicitado(estudioSolicitado);
		this.setFechaIndicacion(fecIndicacion);
		this.setFechaResultado(fechaResultado);
		this.setInformeResultado(informeResultado);
	}

	public EstudioComplementario(String estudioSolicitado, Date fechaResultado, String informeResultado) {
		super();
		this.setEstudioSolicitado(estudioSolicitado);
		this.setFechaIndicacion(new Date());
		this.setFechaResultado(fechaResultado);
		this.setInformeResultado(informeResultado);
	}

	public EstudioComplementario(String estudioSolicitado) {
		super();
		this.setFechaIndicacion(new Date());
		this.setEstudioSolicitado(estudioSolicitado);

	}

	public EstudioComplementario() {
		super();
		this.setFechaIndicacion(new Date());
	}

	public Date getFechaIndicacion() {
		return fechaIndicacion;
	}

	public void setFechaIndicacion(Date fechaIndicacion) {
		this.fechaIndicacion = fechaIndicacion;
	}

	public Date getFechaResultado() {
		return fechaResultado;
	}

	public void setFechaResultado(Date fechaResultado) {
		this.fechaResultado = fechaResultado;
	}

	public String getInformeResultado() {
		return informeResultado;
	}

	public void setInformeResultado(String informeResultado) {
		this.informeResultado = informeResultado;
		this.setFechaResultado(new Date());
	}

	public String getEstudioSolicitado() {
		return estudioSolicitado;
	}

	public void setEstudioSolicitado(String estudioSolicitado) {
		this.estudioSolicitado = estudioSolicitado;
	}

	@Override
	public int compareTo(EstudioComplementario estudio) {
		return ObjectUtils.compare(this.getFechaResultado(), estudio.getFechaResultado());

	}

}
