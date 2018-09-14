package ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.UserDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.User;

@Component
public class UserTransformer implements Transformer<User, UserDTO> {

	public UserTransformer() {
	}

	@Override
	public UserDTO toDTO(User u) {
		return new UserDTO(u.getId(), u.getUsername(), u.getEmail(), u.getAuthorities());
	}

	@Override
	public User toEntity(UserDTO dto) {
		return new User(dto.getId(), dto.getUsername(), dto.getEmail(), dto.getAuthorities());
	}

	@Override
	public List<UserDTO> toListDTO(List<User> list) {
		List<UserDTO> lista = new ArrayList<UserDTO>();
		for (User u : list) {
			lista.add(this.toDTO(u));
		}
		return lista;
	}

	@Override
	public Collection<UserDTO> toCollectionDTO(List<User> list) {
		Collection<UserDTO> lista = new ArrayList<UserDTO>();
		for (User u : list) {
			lista.add(this.toDTO(u));
		}
		return lista;
	}

	@Override
	public List<User> toListEntity(Set<UserDTO> list) {
		List<User> lista = new ArrayList<User>();
		for (UserDTO u : list) {
			lista.add(this.toEntity(u));
		}
		return lista;
	}

}
