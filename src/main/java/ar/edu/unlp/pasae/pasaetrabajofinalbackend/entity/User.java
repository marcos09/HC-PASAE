package ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class User extends GenericPersistentClass{

	@NotEmpty(message = "El nombre de usuario no puede ser nulo o vacío")
	private String username;
	@NotEmpty(message = "El email no puede ser nulo o vacío")
	private String email;
	@NotNull
	public String authorities;
	
	public User() {
		super();
	}
	
	public User(Long id,String username,String email,String authorities) {
		super();
		this.setId(id);
		this.setEmail(email);
		this.setUsername(username);
		this.setAuthorities(authorities);
	}

	public User(String username,String email) {
		super();
		this.setEmail(email);;
		this.setUsername(username);
	}

	private void setUsername(String username) {
		this.username = username;
	}


	private void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
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
