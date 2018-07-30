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

	public PatologiaTransformer() {
	}

	@Override
	public PatologiaDTO toDTO(Patologia e) {
		if(e != null)
			return new PatologiaDTO(e.getNombre(),e.getOtroDato(),this.toDTO(e.getFather()),this.toSetDTO(e.getChilds()));
		return null;
	}

	@Override
	public Patologia toEntity(PatologiaDTO dto) {
		if(dto != null)
			return new Patologia(dto.getId(),this.toEntity(dto.getFather()),this.toListEntity(dto.getChilds()),dto.getNombre(),dto.getOtroDato());
		return null;
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