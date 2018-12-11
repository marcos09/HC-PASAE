package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

import java.util.List;

public class EstudiosDivididosDTO {
	
	private List<EstudioComplementarioDTO> estudiosFinalizados;
	private List<EstudioComplementarioDTO> estudiosPendientes;
	
	
	public EstudiosDivididosDTO(List<EstudioComplementarioDTO> estudiosFinalizados,
			List<EstudioComplementarioDTO> estudiosPendientes) {
		super();
		this.setEstudiosFinalizados(estudiosFinalizados);
		this.setEstudiosPendientes(estudiosPendientes);
	}
	
	public List<EstudioComplementarioDTO> getEstudiosFinalizados() {
		return estudiosFinalizados;
	}
	public void setEstudiosFinalizados(List<EstudioComplementarioDTO> estudiosFinalizados) {
		this.estudiosFinalizados = estudiosFinalizados;
	}
	public List<EstudioComplementarioDTO> getEstudiosPendientes() {
		return estudiosPendientes;
	}
	public void setEstudiosPendientes(List<EstudioComplementarioDTO> estudiosPendientes) {
		this.estudiosPendientes = estudiosPendientes;
	}
	
	
	
	
}
