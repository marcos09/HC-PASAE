package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserDTO extends GenericDTOImpl{

	private Long id;
	@NotEmpty(message = "El nombre de usuario no puede ser nulo o vacío")
	private String username;
	@NotEmpty(message = "La password no puede ser nula o vacía")
	private String password;
	@NotEmpty(message = "El email no puede ser nulo o vacío")
	private String email;
	@NotNull
	public String authorities;
	
	public UserDTO() {
		super();
	}
	
	public UserDTO(Long id,String username,String password,String email,String authorities) {
		super();
		this.setId(id);
		this.setEmail(email);
		this.setPassword(password);
		this.setUsername(username);
		this.setAuthorities(authorities);
	}

	public UserDTO(String username,String password,String email) {
		super();
		this.setEmail(email);;
		this.setPassword(password);
		this.setUsername(username);
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

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	
	
}
