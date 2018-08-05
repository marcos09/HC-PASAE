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
		return new EgresoDTO(e.getId(),e.getDiagnosticoFinal(),e.getFecha());
	}

	@Override
	public Egreso toEntity(EgresoDTO dto) {
		return new Egreso(dto.getId(), dto.getDiagnosticoFinal());
	}

	@Override
	public List<EgresoDTO> toListDTO(List<Egreso> list) {
		List<EgresoDTO> lista = new ArrayList<EgresoDTO>();
		for (Egreso e : list) {
			lista.add(this.toDTO(e));
		}
		return lista;
	}

	@Override
	public Collection<EgresoDTO> toCollectionDTO(List<Egreso> list) {
		Collection<EgresoDTO> lista = new ArrayList<EgresoDTO>();
		for (Egreso e : list) {
			lista.add(this.toDTO(e));
		}
		return lista;
	}

	@Override
	public Set<Egreso> toListEntity(Set<EgresoDTO> list) {
		Set<Egreso> lista = new HashSet<Egreso>();
		for (EgresoDTO e : list) {
			lista.add(this.toEntity(e));
		}
		return lista;
	}

}
