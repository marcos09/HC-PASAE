package ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.SeguimientoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Seguimiento;

@Component
public class SeguimientoTransformer implements Transformer<Seguimiento, SeguimientoDTO> {

	@Autowired
	private EstudioComplementarioTransformer ecTransformer;

	private EstudioComplementarioTransformer getEstudioTransformer() {
		return ecTransformer;
	}

	@Autowired
	private PrescripcionTransformer prescripcionTransformer;

	private PrescripcionTransformer getPrescripcionTransformer() {
		return prescripcionTransformer;
	}

	@Override
	public SeguimientoDTO toDTO(Seguimiento e) {
		return new SeguimientoDTO(e.getId(), e.getResultado(),
				this.getEstudioTransformer().toSetDTO(e.getEstudiosComplementarios()),
				this.getPrescripcionTransformer().toSetDTO(e.getPrescripciones()),e.getFecha());
	}

	@Override
	public Seguimiento toEntity(SeguimientoDTO dto) {
		return new Seguimiento(dto.getId(), dto.getResultado(),
				this.getEstudioTransformer().toSet(dto.getEstudiosComplementariosDTO()),
				this.getPrescripcionTransformer().toSet(dto.getPrescripcionesDTO()));

	}

	@Override
	public List<SeguimientoDTO> toListDTO(List<Seguimiento> list) {
		List<SeguimientoDTO> lista = new ArrayList<SeguimientoDTO>();
		for (Seguimiento e : list) {
			lista.add(this.toDTO(e));
		}
		return lista;
	}

	@Override
	public Collection<SeguimientoDTO> toCollectionDTO(List<Seguimiento> list) {
		Collection<SeguimientoDTO> lista = new ArrayList<SeguimientoDTO>();
		for (Seguimiento e : list) {
			lista.add(this.toDTO(e));
		}
		return lista;
	}

	@Override
	public List<Seguimiento> toListEntity(Set<SeguimientoDTO> list) {
		List<Seguimiento> lista = new ArrayList<Seguimiento>();
		for (SeguimientoDTO e : list) {
			lista.add(this.toEntity(e));
		}
		return lista;
	}

	public Set<SeguimientoDTO> toSetDTO(Set<Seguimiento> seguimientos) {
		Set<SeguimientoDTO> lista = new HashSet<SeguimientoDTO>();
		for (Seguimiento e : seguimientos) {
			lista.add(this.toDTO(e));
		}
		return lista;
	}

	public Set<Seguimiento> toSet(Set<SeguimientoDTO> seguimientosDTO) {
		Set<Seguimiento> lista = new HashSet<Seguimiento>();
		for (SeguimientoDTO e : seguimientosDTO) {
			lista.add(this.toEntity(e));
		}
		return lista;
	}

}
