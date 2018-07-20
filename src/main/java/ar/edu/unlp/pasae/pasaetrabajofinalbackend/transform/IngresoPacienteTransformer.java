package ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;

@Component
public class IngresoPacienteTransformer implements Transformer<IngresoPaciente, IngresoPacienteDTO> {


	@Override
	public IngresoPacienteDTO toDTO(IngresoPaciente ip) {
		// TODO Auto-generated method stub
		return new IngresoPacienteDTO(ip.getId(),ip.getMotivoConsulta(),ip.getEnfermedadActual(),ip.getDiagnosticoSintomatico(),ip.getDiagnosticoPresuntivo(),ip.getEstudiosComplementarios());
	}

	@Override
	public IngresoPaciente toEntity(IngresoPacienteDTO dto) {
		// TODO Auto-generated method stub
		return new IngresoPaciente(dto.getId(),dto.getMotivoConsulta(),dto.getEnfermedadActual(),dto.getDiagnosticoSintomatico(),dto.getDiagnosticoPresuntivo(),dto.getEstudiosComplementarios());
	}

	@Override
	public List<IngresoPacienteDTO> toListDTO(List<IngresoPaciente> list) {
		List<IngresoPacienteDTO> lista = new ArrayList<IngresoPacienteDTO>();
		for (IngresoPaciente p : list) {
			lista.add(this.toDTO(p));
		}
		return lista;
	}

	@Override
	public Collection<IngresoPacienteDTO> toCollectionDTO(List<IngresoPaciente> list) {
		Collection<IngresoPacienteDTO> lista = new ArrayList<IngresoPacienteDTO>();
		for (IngresoPaciente p : list) {
			lista.add(this.toDTO(p));
		}
		return lista;
	}

	@Override
	public Set<IngresoPaciente> toListEntity(Set<IngresoPacienteDTO> list) {
		Set<IngresoPaciente> lista = new HashSet<IngresoPaciente>();
		for (IngresoPacienteDTO p : list) {
			lista.add(this.toEntity(p));
		}
		return lista;
	}

	
	

}
