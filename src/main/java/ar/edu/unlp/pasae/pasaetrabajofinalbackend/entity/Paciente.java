package ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Paciente extends GenericPersistentClass {

	@NotNull(message = "El dni no puede ser nulo o vacío")
	@Positive
	@Max(value = 99999999)
	private int dni;
	@NotNull(message = "Debe indicar si posee o no obra social")
	private boolean obraSocial;
	private String obraSocialNombre;
	private Long numeroAfiliado;
	@NotEmpty(message = "El nombre no puede ser nulo o vacío")
	private String nombre;
	@NotEmpty(message = "El apellido no puede ser nulo o vacío")
	private String apellido;
	@NotEmpty(message = "El domicilio no puede ser nulo o vacío")
	private String domicilio;
	@NotEmpty(message = "El telefono no puede ser nulo o vacío")
	private String numeroTelefono;

	public Paciente() {
		super();
	}

	public Paciente(int dni, boolean obraSocial, String obraSocialNombre, Long numeroAfiliado, String nombre,
			String apellido, String domicilio, String numeroTelefono) {
		super();
		this.setDni(dni);
		this.setObraSocial(obraSocial);
		this.setObraSocialNombre(obraSocialNombre);
		this.setNumeroAfiliado(numeroAfiliado);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDomicilio(domicilio);
		this.setNumeroTelefono(numeroTelefono);
	}

	public Paciente(Long id, int dni, boolean obraSocial, String obraSocialNombre, Long numeroAfiliado, String nombre,
			String apellido, String domicilio, String numeroTelefono) {
		super();
		this.setId(id);
		this.setDni(dni);
		this.setObraSocial(obraSocial);
		this.setObraSocialNombre(obraSocialNombre);
		this.setNumeroAfiliado(numeroAfiliado);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDomicilio(domicilio);
		this.setNumeroTelefono(numeroTelefono);
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public boolean isObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(boolean obraSocial) {
		this.obraSocial = obraSocial;
	}

	public String getObraSocialNombre() {
		return obraSocialNombre;
	}

	public void setObraSocialNombre(String obraSocialNombre) {
		this.obraSocialNombre = obraSocialNombre;
	}

	public Long getNumeroAfiliado() {
		return numeroAfiliado;
	}

	public void setNumeroAfiliado(Long numeroAfiliado) {
		this.numeroAfiliado = numeroAfiliado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

}
