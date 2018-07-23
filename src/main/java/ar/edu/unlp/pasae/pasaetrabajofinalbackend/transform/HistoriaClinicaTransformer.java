package ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.HistoriaClinicaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.HistoriaClinica;

@Component
public class HistoriaClinicaTransformer implements Transformer<HistoriaClinica, HistoriaClinicaDTO> {

	public HistoriaClinicaTransformer() {
		// TODO Auto-generated constructor stub
	}
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
		// TODO Auto-generated method stub
		HistoriaClinicaDTO historiaDTO = new HistoriaClinicaDTO(this.getIngresoTransformer().toDTO(e.getIngreso()));
		historiaDTO.setEgreso(this.getEgresoTransformer().toDTO(e.getEgreso()));
		historiaDTO.setSeguimientos(this.getSeguimientoTransformer().toSetDTO(e.getSeguimientos()));
		return historiaDTO;
	}

	@Override
	public HistoriaClinica toEntity(HistoriaClinicaDTO dto) {
		// TODO Auto-generated method stub
		HistoriaClinica historia = new HistoriaClinica(this.getIngresoTransformer().toEntity(dto.getIngreso()));
		historia.setEgreso(this.getEgresoTransformer().toEntity(dto.getEgreso()));
		historia.setSeguimientos(this.getSeguimientoTransformer().toSet(dto.getSeguimientos()));
		return historia;
	}

	@Override
	public List<HistoriaClinicaDTO> toListDTO(List<HistoriaClinica> list) {
		// TODO Auto-generated method stub
		List<HistoriaClinicaDTO> lista = new ArrayList<HistoriaClinicaDTO>();
		for (HistoriaClinica hc : list) {
			lista.add(this.toDTO(hc));
		}
		return lista;
	}

	@Override
	public Collection<HistoriaClinicaDTO> toCollectionDTO(List<HistoriaClinica> list) {
		// TODO Auto-generated method stub
		Collection<HistoriaClinicaDTO> lista = new ArrayList<HistoriaClinicaDTO>();
		for (HistoriaClinica hc : list) {
			lista.add(this.toDTO(hc));
		}
		return lista;
	}

	@Override
	public Set<HistoriaClinica> toListEntity(Set<HistoriaClinicaDTO> list) {
		// TODO Auto-generated method stub
		Set<HistoriaClinica> lista = new HashSet<HistoriaClinica>();
		for (HistoriaClinicaDTO hc : list) {
			lista.add(this.toEntity(hc));
		}
		return lista;
	}

}
