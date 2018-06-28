package ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class User extends GenericPersistentClass {

	@Id   @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "El nombre de usuario no puede ser nulo o vacío")
	private String username;
	@NotEmpty(message = "La password no puede ser nula o vacía")
	private String password;
	@NotEmpty(message = "El email no puede ser nulo o vacío")
	private String email;
	@NotNull
	public String authorities;
	
	public User() {
		super();
	}

	
	
	public User(Long id,String username,String password,String email,String authorities) {
		super();
		this.setId(id);
		this.setEmail(email);
		this.setPassword(password);
		this.setUsername(username);
		this.setAuthorities(authorities);
	}

	public User(String username,String password,String email) {
		super();
		this.setEmail(email);;
		this.setPassword(password);
		this.setUsername(username);
	}

	private void setId(Long id) {
		this.id = id;
	}

	private void setUsername(String username) {
		this.username = username;
	}

	private void setPassword(String password) {
		this.password = password;
	}

	private void setEmail(String email) {
		this.email = email;
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

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

}
