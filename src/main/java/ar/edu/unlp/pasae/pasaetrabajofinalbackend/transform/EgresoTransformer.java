package ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.EgresoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Egreso;

@Component
public class EgresoTransformer implements Transformer<Egreso, EgresoDTO> {

	@Override
	public EgresoDTO toDTO(Egreso e) {
		// TODO Auto-generated method stub
		return new EgresoDTO(e.getId(),e.getDiagnosticoFinal(),e.getFecha());
	}

	@Override
	public Egreso toEntity(EgresoDTO dto) {
		// TODO Auto-generated method stub
		return new Egreso(dto.getId(), dto.getDiagnosticoFinal(), dto.getFecha());
	}

	@Override
	public List<EgresoDTO> toListDTO(List<Egreso> list) {
		// TODO Auto-generated method stub
		List<EgresoDTO> lista = new ArrayList<EgresoDTO>();
		for (Egreso e : list) {
			lista.add(this.toDTO(e));
		}
		return lista;
	}

	@Override
	public Collection<EgresoDTO> toCollectionDTO(List<Egreso> list) {
		// TODO Auto-generated method stub
		Collection<EgresoDTO> lista = new ArrayList<EgresoDTO>();
		for (Egreso e : list) {
			lista.add(this.toDTO(e));
		}
		return lista;
	}

	@Override
	public Set<Egreso> toListEntity(Set<EgresoDTO> list) {
		// TODO Auto-generated method stub
		Set<Egreso> lista = new HashSet<Egreso>();
		for (EgresoDTO e : list) {
			lista.add(this.toEntity(e));
		}
		return lista;
	}

}
