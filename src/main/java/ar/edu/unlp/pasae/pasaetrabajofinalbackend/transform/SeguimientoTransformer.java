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
		// TODO Auto-generated method stub
		SeguimientoDTO seguimientoDTO = new SeguimientoDTO();
		seguimientoDTO.setFecha(e.getFecha());
		seguimientoDTO.setResultado(e.getResultado());
		seguimientoDTO
				.setEstudiosComplementariosDTO(this.getEstudioTransformer().toSetDTO(e.getEstudiosComplementarios()));
		seguimientoDTO.setPrescripcionesDTO(this.getPrescripcionTransformer().toSetDTO(e.getPrescripciones()));
		return seguimientoDTO;
	}

	@Override
	public Seguimiento toEntity(SeguimientoDTO dto) {
		// TODO Auto-generated method stub
		Seguimiento seguimiento = new Seguimiento();
		seguimiento.setFecha(dto.getFecha());
		seguimiento.setResultado(dto.getResultado());
		seguimiento.setPrescripciones(this.getPrescripcionTransformer().toSet(dto.getPrescripcionesDTO()));
		seguimiento.setEstudiosComplementarios(this.getEstudioTransformer().toSet(dto.getEstudiosComplementariosDTO()));
		return seguimiento;
	}

	@Override
	public List<SeguimientoDTO> toListDTO(List<Seguimiento> list) {
		// TODO Auto-generated method stub
		List<SeguimientoDTO> lista = new ArrayList<SeguimientoDTO>();
		for (Seguimiento e : list) {
			lista.add(this.toDTO(e));
		}
		return lista;
	}

	@Override
	public Collection<SeguimientoDTO> toCollectionDTO(List<Seguimiento> list) {
		// TODO Auto-generated method stub
		Collection<SeguimientoDTO> lista = new ArrayList<SeguimientoDTO>();
		for (Seguimiento e : list) {
			lista.add(this.toDTO(e));
		}
		return lista;
	}

	@Override
	public Set<Seguimiento> toListEntity(Set<SeguimientoDTO> list) {
		// TODO Auto-generated method stub
		Set<Seguimiento> lista = new HashSet<Seguimiento>();
		for (SeguimientoDTO e : list) {
			lista.add(this.toEntity(e));
		}
		return lista;
	}

	public Set<SeguimientoDTO> toSetDTO(Set<Seguimiento> seguimientos) {
		// TODO Auto-generated method stub
		Set<SeguimientoDTO> lista = new HashSet<SeguimientoDTO>();
		for (Seguimiento e : seguimientos) {
			lista.add(this.toDTO(e));
		}
		return lista;
	}

	public Set<Seguimiento> toSet(Set<SeguimientoDTO> seguimientosDTO) {
		// TODO Auto-generated method stub
		Set<Seguimiento> lista = new HashSet<Seguimiento>();
		for (SeguimientoDTO e : seguimientosDTO) {
			lista.add(this.toEntity(e));
		}
		return lista;
	}

}
