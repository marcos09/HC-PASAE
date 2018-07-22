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
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserDTO toDTO(User u) {
		// TODO Auto-generated method stub
		return new UserDTO(u.getId(), u.getUsername(), u.getEmail(), u.getAuthorities());
	}

	@Override
	public User toEntity(UserDTO dto) {
		// TODO Auto-generated method stub
		return new User(dto.getId(), dto.getUsername(), dto.getEmail(), dto.getAuthorities());
	}

	@Override
	public List<UserDTO> toListDTO(List<User> list) {
		// TODO Auto-generated method stub
		List<UserDTO> lista = new ArrayList<UserDTO>();
		for (User u : list) {
			lista.add(this.toDTO(u));
		}
		return lista;
	}

	@Override
	public Collection<UserDTO> toCollectionDTO(List<User> list) {
		// TODO Auto-generated method stub
		Collection<UserDTO> lista = new ArrayList<UserDTO>();
		for (User u : list) {
			lista.add(this.toDTO(u));
		}
		return lista;
	}

	@Override
	public Set<User> toListEntity(Set<UserDTO> list) {
		// TODO Auto-generated method stub
		Set<User> lista = new HashSet<User>();
		for (UserDTO u : list) {
			lista.add(this.toEntity(u));
		}
		return lista;
	}

}
