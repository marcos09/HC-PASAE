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
		// TODO Auto-generated constructor stub
	}

	@Override
	public PatologiaDTO toDTO(Patologia e) {
		// TODO Auto-generated method stub
		return new PatologiaDTO(e.getNombre(),e.getOtroDato(),this.toDTO(e.getFather()),this.toSetDTO(e.getChilds()));
	}

	@Override
	public Patologia toEntity(PatologiaDTO dto) {
		// TODO Auto-generated method stub
		return new Patologia(dto.getId(),this.toEntity(dto.getFather()),this.toListEntity(dto.getChilds()),dto.getNombre(),dto.getOtroDato());
	}

	@Override
	public List<PatologiaDTO> toListDTO(List<Patologia> list) {
		// TODO Auto-generated method stub
		List<PatologiaDTO> lista = new ArrayList<PatologiaDTO>();
		for (Patologia p : list) {
			lista.add(this.toDTO(p));
		}
		return lista;
	}

	@Override
	public Collection<PatologiaDTO> toCollectionDTO(List<Patologia> list) {
		// TODO Auto-generated method stub
		Collection<PatologiaDTO> lista = new ArrayList<PatologiaDTO>();
		for (Patologia p : list) {
			lista.add(this.toDTO(p));
		}
		return lista;
	}

	@Override
	public Set<Patologia> toListEntity(Set<PatologiaDTO> list) {
		// TODO Auto-generated method stub
		Set<Patologia> lista = new HashSet<Patologia>();
		for (PatologiaDTO p : list) {
			lista.add(this.toEntity(p));
		}
		return lista;
	}

	public Set<PatologiaDTO> toSetDTO(Set<Patologia> list) {
		// TODO Auto-generated method stub
		Set<PatologiaDTO> lista = new HashSet<PatologiaDTO>();
		for (Patologia p : list) {
			lista.add(this.toDTO(p));
		}
		return lista;
	}
	

}
