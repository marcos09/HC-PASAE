package ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.EgresoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.HistoriaClinicaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Egreso;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.HistoriaClinica;

@Component
public class HistoriaClinicaTransformer implements Transformer<HistoriaClinica, HistoriaClinicaDTO> {

	@Autowired
	private IngresoPacienteTransformer ipTransformer;

	private IngresoPacienteTransformer getIngresoTransformer() {
		return ipTransformer;
	}

	@Autowired
	private EgresoTransformer egresoTransformer;

	private EgresoTransformer getEgresoTransformer() {
		return egresoTransformer;
	}

	@Autowired
	private SeguimientoTransformer seguimientoTransformer;

	private SeguimientoTransformer getSeguimientoTransformer() {
		return seguimientoTransformer;
	}

	@Override
	public HistoriaClinicaDTO toDTO(HistoriaClinica e) {
		HistoriaClinicaDTO historiaDTO = new HistoriaClinicaDTO(e.getId(),
				this.getIngresoTransformer().toDTO(e.getIngreso()));

		if (e.getEgreso() != null) {
			EgresoDTO eDTO = this.getEgresoTransformer().toDTO(e.getEgreso());
			historiaDTO.setEgreso(eDTO);
		}

		historiaDTO.setSeguimientos(this.getSeguimientoTransformer().toSetDTO(e.getSeguimientos()));
		return historiaDTO;
	}
	

	@Override
	public HistoriaClinica toEntity(HistoriaClinicaDTO dto) {
		HistoriaClinica historia = new HistoriaClinica(dto.getId(),
				this.getIngresoTransformer().toEntity(dto.getIngreso()));

		if (dto.getEgreso() != null) {
			Egreso e = this.getEgresoTransformer().toEntity(dto.getEgreso());
			historia.setEgreso(e);
		}
		historia.setSeguimientos(this.getSeguimientoTransformer().toSet(dto.getSeguimientos()));
		return historia;
	}

	@Override
	public List<HistoriaClinicaDTO> toListDTO(List<HistoriaClinica> list) {
		List<HistoriaClinicaDTO> lista = new ArrayList<HistoriaClinicaDTO>();
		for (HistoriaClinica hc : list) {
			lista.add(this.toDTO(hc));
		}
		return lista;
	}

	@Override
	public Collection<HistoriaClinicaDTO> toCollectionDTO(List<HistoriaClinica> list) {
		Collection<HistoriaClinicaDTO> lista = new ArrayList<HistoriaClinicaDTO>();
		for (HistoriaClinica hc : list) {
			lista.add(this.toDTO(hc));
		}
		return lista;
	}

	@Override
	public Set<HistoriaClinica> toListEntity(Set<HistoriaClinicaDTO> list) {
		Set<HistoriaClinica> lista = new HashSet<HistoriaClinica>();
		for (HistoriaClinicaDTO hc : list) {
			lista.add(this.toEntity(hc));
		}
		return lista;
	}

}
