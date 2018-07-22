package ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.EstudioComplementarioDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.EstudioComplementario;

public class EstudioComplementarioTransformer implements Transformer<EstudioComplementario, EstudioComplementarioDTO> {

	@Override
	public EstudioComplementarioDTO toDTO(EstudioComplementario e) {
		// TODO Auto-generated method stub
		return new EstudioComplementarioDTO(e.getFechaRealizacion(), e.getFechaResultado(), e.getInformeResultado());
	}

	@Override
	public EstudioComplementario toEntity(EstudioComplementarioDTO dto) {
		// TODO Auto-generated method stub
		return new EstudioComplementario(dto.getFechaRealizacion(), dto.getFechaResultado(), dto.getInformeResultado());
	}

	@Override
	public List<EstudioComplementarioDTO> toListDTO(List<EstudioComplementario> list) {
		// TODO Auto-generated method stub
		List<EstudioComplementarioDTO> lista = new ArrayList<EstudioComplementarioDTO>();
		for (EstudioComplementario e : list) {
			lista.add(this.toDTO(e));
		}
		return lista;
	}

	@Override
	public Collection<EstudioComplementarioDTO> toCollectionDTO(List<EstudioComplementario> list) {
		// TODO Auto-generated method stub
		Collection<EstudioComplementarioDTO> lista = new ArrayList<EstudioComplementarioDTO>();
		for (EstudioComplementario e : list) {
			lista.add(this.toDTO(e));
		}
		return lista;
	}

	@Override
	public Set<EstudioComplementario> toListEntity(Set<EstudioComplementarioDTO> list) {
		// TODO Auto-generated method stub
		Set<EstudioComplementario> lista = new HashSet<EstudioComplementario>();
		for (EstudioComplementarioDTO e : list) {
			lista.add(this.toEntity(e));
		}
		return lista;
	}

	public Set<EstudioComplementarioDTO> toSetDTO(Set<EstudioComplementario> estudiosComplementarios) {
		// TODO Auto-generated method stub
		Set<EstudioComplementarioDTO> lista = new HashSet<EstudioComplementarioDTO>();
		for (EstudioComplementario e : estudiosComplementarios) {
			lista.add(this.toDTO(e));
		}
		return lista;
	}
	
	public Set<EstudioComplementario> toSet(Set<EstudioComplementarioDTO> estudiosComplementarios) {
		// TODO Auto-generated method stub
		Set<EstudioComplementario> lista = new HashSet<EstudioComplementario>();
		for (EstudioComplementarioDTO e : estudiosComplementarios) {
			lista.add(this.toEntity(e));
		}
		return lista;
	}

}
