package ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;

@Component
public class IngresoPacienteTransformer implements Transformer<IngresoPaciente, IngresoPacienteDTO> {

	@Autowired
	private EstudioComplementarioTransformer estudioTransformer;

	@Autowired
	private PrescripcionTransformer prescripcionTransformer;

	public EstudioComplementarioTransformer getEstudioTransformer() {
		return estudioTransformer;
	}

	public PrescripcionTransformer getPrescripcionTransformer() {
		return prescripcionTransformer;
	}

	@Override
	public IngresoPacienteDTO toDTO(IngresoPaciente ip) {
		IngresoPacienteDTO ingresoDTO = new IngresoPacienteDTO(ip.getId(), ip.getMotivoConsulta(),
				ip.getEnfermedadActual(), ip.getDiagnosticoSintomatico(), ip.getDiagnosticoPresuntivo(),
				this.getEstudioTransformer().toSetDTO(ip.getEstudiosComplementarios()),
				this.getPrescripcionTransformer().toSetDTO(ip.getPrescripciones()));
		return ingresoDTO;
	}

	@Override
	public IngresoPaciente toEntity(IngresoPacienteDTO dto) {
		// TODO Auto-generated method stub
		return new IngresoPaciente(dto.getId(), dto.getMotivoConsulta(), dto.getEnfermedadActual(),
				dto.getDiagnosticoSintomatico(), dto.getDiagnosticoPresuntivo(),
				this.getEstudioTransformer().toSet(dto.getEstudiosComplementarios()),
				this.getPrescripcionTransformer().toSet(dto.getPrescripciones()));
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
