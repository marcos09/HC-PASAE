package ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PatologiaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Patologia;

@Component
public class PatologiaTransformer implements Transformer<Patologia, PatologiaDTO> {

	@Override
	public PatologiaDTO toDTO(Patologia e) {
		return new PatologiaDTO(e.getId(), e.getNombre(), e.getOtroDato());
	}

	@Override
	public Patologia toEntity(PatologiaDTO dto) {
		return new Patologia(dto.getId(), dto.getNombre(), dto.getOtroDato());
	}

	@Override
	public List<PatologiaDTO> toListDTO(List<Patologia> list) {
		List<PatologiaDTO> lista = new ArrayList<PatologiaDTO>();
		for (Patologia p : list) {
			lista.add(this.toDTO(p));
		}
		return lista;
	}

	@Override
	public Collection<PatologiaDTO> toCollectionDTO(List<Patologia> list) {
		Collection<PatologiaDTO> lista = new ArrayList<PatologiaDTO>();
		for (Patologia p : list) {
			lista.add(this.toDTO(p));
		}
		return lista;
	}

	@Override
	public List<Patologia> toListEntity(Set<PatologiaDTO> list) {
		List<Patologia> lista = new ArrayList<Patologia>();
		for (PatologiaDTO p : list) {
			lista.add(this.toEntity(p));
		}
		return lista;
	}

	public Set<PatologiaDTO> toSetDTO(Set<Patologia> list) {
		Set<PatologiaDTO> lista = new HashSet<PatologiaDTO>();
		for (Patologia p : list) {
			lista.add(this.toDTO(p));
		}
		return lista;
	}

}
