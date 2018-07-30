package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

public class PacienteDTO extends GenericDTOImpl{

	private int dni;
	private boolean obraSocial;
	private String obraSocialNombre;
	private Long numeroAfiliado;
	private String nombre;
	private String apellido;
	private String domicilio;
	private int numeroTelefono;
	
	public PacienteDTO() {
		super();
	}
	
	public PacienteDTO(int dni, boolean obraSocial, String obraSocialNombre, Long numeroAfiliado, String nombre,
			String apellido, String domicilio, int numeroTelefono) {
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
	
	public PacienteDTO(Long id, int dni, boolean obraSocial, String obraSocialNombre, Long numeroAfiliado, String nombre,
			String apellido, String domicilio, int numeroTelefono) {
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
	public int getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	

}
