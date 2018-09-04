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

		if (e.getFather() == null) {
			if (e.getChilds().size() > 0) {
				return new PatologiaDTO(e.getId(), e.getNombre(), e.getOtroDato());
			} else {
				return new PatologiaDTO(e.getId(), e.getNombre(), e.getOtroDato(), this.toSetDTO(e.getChilds()));
			}
		} else {
			if (e.getChilds().size() > 0) {
				return new PatologiaDTO(e.getId(), e.getNombre(), e.getOtroDato(), this.toDTO(e.getFather()));
			} else {
				return new PatologiaDTO(e.getId(), e.getNombre(), e.getOtroDato(), this.toDTO(e.getFather()),
						this.toSetDTO(e.getChilds()));
			}
		}

	}

	@Override
	public Patologia toEntity(PatologiaDTO dto) {

		if (dto.getFather() == null) {
			if (dto.getChilds() == null) {
				return new Patologia(dto.getId(), dto.getNombre(), dto.getOtroDato());
			} else {
				return new Patologia(dto.getId(), dto.getNombre(), dto.getOtroDato(),
						this.toListEntity(dto.getChilds()));
			}
		} else {
			if (dto.getChilds() == null) {
				return new Patologia(dto.getId(), dto.getNombre(), dto.getOtroDato(), this.toEntity(dto.getFather()));
			} else {
				return new Patologia(dto.getId(), this.toEntity(dto.getFather()), this.toListEntity(dto.getChilds()),
						dto.getNombre(), dto.getOtroDato());
			}
		}

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
	public Set<Patologia> toListEntity(Set<PatologiaDTO> list) {
		Set<Patologia> lista = new HashSet<Patologia>();
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
