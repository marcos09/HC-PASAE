package ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity;

import java.util.Collection;

public interface Revision {

	public Collection<Prescripcion> getPrescripciones();
	public Collection<EstudioComplementario> getEstudiosComplementarios();
	
}
