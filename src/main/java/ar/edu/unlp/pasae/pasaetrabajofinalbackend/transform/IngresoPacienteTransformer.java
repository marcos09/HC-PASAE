package ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform;

import java.util.ArrayList;
import java.util.Collection;
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

	@Autowired
	private PatologiaTransformer patologiaTransformer;

	public PatologiaTransformer getPatologiaTransformer() {
		return patologiaTransformer;
	}

	public EstudioComplementarioTransformer getEstudioTransformer() {
		return estudioTransformer;
	}

	public PrescripcionTransformer getPrescripcionTransformer() {
		return prescripcionTransformer;
	}

	@Override
	public IngresoPacienteDTO toDTO(IngresoPaciente ip) {
		IngresoPacienteDTO ingresoDTO = new IngresoPacienteDTO(ip.getId(), ip.getMotivoConsulta(),
				ip.getEnfermedadActual(), this.getPatologiaTransformer().toDTO(ip.getDiagnosticoSintomatico()),
				this.getPatologiaTransformer().toDTO(ip.getDiagnosticoPresuntivo()),
				this.getEstudioTransformer().toSetDTO(ip.getEstudiosComplementarios()),
				this.getPrescripcionTransformer().toSetDTO(ip.getPrescripciones()), ip.getAntecedentesEnfermedad(),
				ip.getAntecedentesPersonales(), ip.getExamenFisico(), ip.getFechaIngreso());
		return ingresoDTO;
	}

	@Override
	public IngresoPaciente toEntity(IngresoPacienteDTO dto) {
		// TODO Auto-generated method stub
		return new IngresoPaciente(dto.getId(), dto.getMotivoConsulta(), dto.getEnfermedadActual(),
				this.getPatologiaTransformer().toEntity(dto.getDiagnosticoSintomatico()),
				this.getPatologiaTransformer().toEntity(dto.getDiagnosticoPresuntivo()),
				this.getEstudioTransformer().toSet(dto.getEstudiosComplementariosDTO()),
				this.getPrescripcionTransformer().toSet(dto.getPrescripcionesDTO()), dto.getAntecedentesEnfermedad(),
				dto.getAntecedentesPersonales(), dto.getExamenFisico());
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
	public List<IngresoPaciente> toListEntity(Set<IngresoPacienteDTO> list) {
		List<IngresoPaciente> lista = new ArrayList<IngresoPaciente>();
		for (IngresoPacienteDTO p : list) {
			lista.add(this.toEntity(p));
		}
		return lista;
	}

}
