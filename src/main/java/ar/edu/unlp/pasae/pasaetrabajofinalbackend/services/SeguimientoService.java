package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.SeguimientoDTO;

public interface SeguimientoService extends GenericService {
	SeguimientoDTO retrive(Long id);

}
