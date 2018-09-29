package ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.EgresoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.HistoriaClinicaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.SeguimientoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Egreso;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.HistoriaClinica;

@Component
public class HistoriaClinicaTransformer implements Transformer<HistoriaClinica, HistoriaClinicaDTO> {

	@Autowired
	private EgresoTransformer egresoTransformer;

	@Autowired
	private PacienteTransformer pacienteTransformer;
	
	public PacienteTransformer getPacienteTransformer() {
		return pacienteTransformer;
	}

	public void setPacienteTransformer(PacienteTransformer pacienteTransformer) {
		this.pacienteTransformer = pacienteTransformer;
	}

	public IngresoPacienteTransformer getIpTransformer() {
		return ipTransformer;
	}

	public void setIpTransformer(IngresoPacienteTransformer ipTransformer) {
		this.ipTransformer = ipTransformer;
	}

	public void setEgresoTransformer(EgresoTransformer egresoTransformer) {
		this.egresoTransformer = egresoTransformer;
	}

	public void setSeguimientoTransformer(SeguimientoTransformer seguimientoTransformer) {
		this.seguimientoTransformer = seguimientoTransformer;
	}

	@Autowired
	private IngresoPacienteTransformer ipTransformer;
	
	@Autowired
	private SeguimientoTransformer seguimientoTransformer;

	private IngresoPacienteTransformer getIngresoTransformer() {
		return ipTransformer;
	}

	private EgresoTransformer getEgresoTransformer() {
		return egresoTransformer;
	}


	private SeguimientoTransformer getSeguimientoTransformer() {
		return seguimientoTransformer;
	}

	@Override
	public HistoriaClinicaDTO toDTO(HistoriaClinica e) {
		HistoriaClinicaDTO historiaDTO = new HistoriaClinicaDTO(e.getId(),
				this.getIngresoTransformer().toDTO(e.getIngreso()));
		historiaDTO.setPacienteDTO(this.getPacienteTransformer().toDTO(e.getPaciente()));
		if (e.getEgreso() != null) {
			EgresoDTO eDTO = this.getEgresoTransformer().toDTO(e.getEgreso());
			historiaDTO.setEgreso(eDTO);
		}

		historiaDTO.setSeguimientos(this.getSeguimientoTransformer().toListDTO(e.getSeguimientos()));
		return historiaDTO;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public HistoriaClinica toEntity(HistoriaClinicaDTO dto) {
		HistoriaClinica historia = new HistoriaClinica(dto.getId(),
				this.getIngresoTransformer().toEntity(dto.getIngreso()));

		historia.setPaciente(this.getPacienteTransformer().toEntity(dto.getPacienteDTO()));
		if (dto.getEgreso() != null) {
			Egreso e = this.getEgresoTransformer().toEntity(dto.getEgreso());
			historia.setEgreso(e);
		}
		historia.setSeguimientos(this.getSeguimientoTransformer().toListEntity((Set<SeguimientoDTO>) dto.getSeguimientos()));
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
	public List<HistoriaClinica> toListEntity(Set<HistoriaClinicaDTO> list) {
		List<HistoriaClinica> lista = new ArrayList<HistoriaClinica>();
		for (HistoriaClinicaDTO hc : list) {
			lista.add(this.toEntity(hc));
		}
		return lista;
	}

}
