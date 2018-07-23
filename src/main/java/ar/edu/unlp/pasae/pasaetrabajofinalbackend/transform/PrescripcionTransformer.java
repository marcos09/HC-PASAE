package ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PrescripcionDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Prescripcion;

@Component
public class PrescripcionTransformer implements Transformer<Prescripcion, PrescripcionDTO> {

	@Override
	public PrescripcionDTO toDTO(Prescripcion e) {
		// TODO Auto-generated method stub
		return new PrescripcionDTO(e.getDatos(), e.getFecha());
	}

	@Override
	public Prescripcion toEntity(PrescripcionDTO dto) {
		// TODO Auto-generated method stub
		return new Prescripcion(dto.getDatos(), dto.getFecha());
	}

	@Override
	public List<PrescripcionDTO> toListDTO(List<Prescripcion> list) {
		// TODO Auto-generated method stub
		List<PrescripcionDTO> lista = new ArrayList<PrescripcionDTO>();
		for (Prescripcion p : list) {
			lista.add(this.toDTO(p));
		}
		return lista;
	}

	@Override
	public Collection<PrescripcionDTO> toCollectionDTO(List<Prescripcion> list) {
		// TODO Auto-generated method stub
		Collection<PrescripcionDTO> lista = new ArrayList<PrescripcionDTO>();
		for (Prescripcion p : list) {
			lista.add(this.toDTO(p));
		}
		return lista;
	}

	@Override
	public Set<Prescripcion> toListEntity(Set<PrescripcionDTO> list) {
		// TODO Auto-generated method stub
		Set<Prescripcion> lista = new HashSet<Prescripcion>();
		for (PrescripcionDTO p : list) {
			lista.add(this.toEntity(p));
		}
		return lista;
	}

	public Set<PrescripcionDTO> toSetDTO(Set<Prescripcion> prescripciones) {
		// TODO Auto-generated method stub
		Set<PrescripcionDTO> lista = new HashSet<PrescripcionDTO>();
		for (Prescripcion p : prescripciones) {
			lista.add(this.toDTO(p));
		}
		return lista;
	}
	
	public Set<Prescripcion> toSet(Set<PrescripcionDTO> prescripcionesDTO) {
		// TODO Auto-generated method stub
		Set<Prescripcion> lista = new HashSet<Prescripcion>();
		for (PrescripcionDTO p : prescripcionesDTO) {
			lista.add(this.toEntity(p));
		}
		return lista;
	}

}
