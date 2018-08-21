package ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Paciente;

@Component
public class PacienteTransformer implements Transformer<Paciente, PacienteDTO> {

	@Override
	public PacienteDTO toDTO(Paciente paciente) {
		return new PacienteDTO(paciente.getId(), paciente.getDni(), paciente.isObraSocial(),
				paciente.getObraSocialNombre(), paciente.getNumeroAfiliado(), paciente.getNombre(),
				paciente.getApellido(), paciente.getDomicilio(), paciente.getNumeroTelefono());
	}

	@Override
	public Paciente toEntity(PacienteDTO dto) {
		return new Paciente(dto.getId(), dto.getDni(), dto.isObraSocial(), dto.getObraSocialNombre(),
				dto.getNumeroAfiliado(), dto.getNombre(), dto.getApellido(), dto.getDomicilio(),
				dto.getNumeroTelefono());

	}

	@Override
	public List<PacienteDTO> toListDTO(List<Paciente> list) {
		List<PacienteDTO> lista = new ArrayList<PacienteDTO>();
		for (Paciente p : list) {
			lista.add(this.toDTO(p));
		}
		return lista;
	}

	@Override
	public Collection<PacienteDTO> toCollectionDTO(List<Paciente> list) {
		return (Collection<PacienteDTO>) this.toListDTO(list);
	}

	@Override
	public Set<Paciente> toListEntity(Set<PacienteDTO> list) {
		Set<Paciente> lista = new HashSet<Paciente>();
		for (PacienteDTO p : list) {
			lista.add(this.toEntity(p));
		}
		return lista;

	}

}
