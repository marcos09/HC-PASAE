package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;


import javax.validation.constraints.NotEmpty;

public class UserDTO implements GenericDTO{

	private Long id;
	@NotEmpty(message = "El nombre de usuario no puede ser nulo o vacío")
	private String username;
	@NotEmpty(message = "La password no puede ser nula o vacía")
	private String password;
	@NotEmpty(message = "El email no puede ser nulo o vacío")
	private String email;
	
	public UserDTO() {
		super();
	}
	
	public UserDTO(Long id,String username,String password,String email) {
		super();
		this.setId(id);
		this.setEmail(email);;
		this.setPassword(password);;
		this.setUsername(username);;
	}

	public UserDTO(String username,String password,String email) {
		super();
		this.setEmail(email);;
		this.setPassword(password);;
		this.setUsername(username);;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
