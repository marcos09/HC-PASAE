package ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.MedicamentoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Medicamento;

@Component

public class MedicamentoTransformer implements Transformer<Medicamento, MedicamentoDTO> {

	@Override
	public MedicamentoDTO toDTO(Medicamento e) {
		return new MedicamentoDTO(e.getId(), e.getNombre(), e.getIndicaciones(), e.getContraindicaciones());
	}

	@Override
	public Medicamento toEntity(MedicamentoDTO dto) {
		return new Medicamento(dto.getId(), dto.getNombre(), dto.getIndicaciones(), dto.getContraindicaciones());
	}

	@Override
	public Collection<MedicamentoDTO> toCollectionDTO(List<Medicamento> list) {
		return null;
	}

	@Override
	public List<Medicamento> toListEntity(Set<MedicamentoDTO> list) {
		List<Medicamento> lista = new ArrayList<Medicamento>();
		for (MedicamentoDTO p : list) {
			lista.add(this.toEntity(p));
		}
		return lista;

	}

	@Override
	public List<MedicamentoDTO> toListDTO(List<Medicamento> list) {
		List<MedicamentoDTO> lista = new ArrayList<MedicamentoDTO>();
		for (Medicamento p : list) {
			lista.add(this.toDTO(p));
		}
		return lista;
	}

}
