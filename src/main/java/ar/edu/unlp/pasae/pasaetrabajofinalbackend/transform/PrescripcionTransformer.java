package ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PrescripcionDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Prescripcion;

@Component
public class PrescripcionTransformer implements Transformer<Prescripcion, PrescripcionDTO> {

	@Autowired
	private MedicamentoTransformer transform;
	
	@Override
	public PrescripcionDTO toDTO(Prescripcion e) {
		return new PrescripcionDTO(e.getId(), e.getDatos(), e.getFechaIndicacion(), this.getTransform().toDTO(e.getMedicamento()), e.getFechaAdministracion());
	}
	

	@Override
	public Prescripcion toEntity(PrescripcionDTO dto) {
		return new Prescripcion(dto.getId(), dto.getDatos(), this.getTransform().toEntity(dto.getMedicamento()));
	}

	@Override
	public List<PrescripcionDTO> toListDTO(List<Prescripcion> list) {
		List<PrescripcionDTO> lista = new ArrayList<PrescripcionDTO>();
		for (Prescripcion p : list) {
			lista.add(this.toDTO(p));
		}
		return lista;
	}

	@Override
	public Collection<PrescripcionDTO> toCollectionDTO(List<Prescripcion> list) {
		Collection<PrescripcionDTO> lista = new ArrayList<PrescripcionDTO>();
		for (Prescripcion p : list) {
			lista.add(this.toDTO(p));
		}
		return lista;
	}

	@Override
	public Set<Prescripcion> toListEntity(Set<PrescripcionDTO> list) {
		Set<Prescripcion> lista = new HashSet<Prescripcion>();
		for (PrescripcionDTO p : list) {
			lista.add(this.toEntity(p));
		}
		return lista;
	}

	public Set<PrescripcionDTO> toSetDTO(Set<Prescripcion> prescripciones) {
		Set<PrescripcionDTO> lista = new HashSet<PrescripcionDTO>();
		for (Prescripcion p : prescripciones) {
			lista.add(this.toDTO(p));
		}
		return lista;
	}
	
	public Set<Prescripcion> toSet(Set<PrescripcionDTO> prescripcionesDTO) {
		Set<Prescripcion> lista = new HashSet<Prescripcion>();
		for (PrescripcionDTO p : prescripcionesDTO) {
			lista.add(this.toEntity(p));
		}
		return lista;
	}

	public MedicamentoTransformer getTransform() {
		return transform;
	}

	public void setTransform(MedicamentoTransformer transform) {
		this.transform = transform;
	}

	
}
