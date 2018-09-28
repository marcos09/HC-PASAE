package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.SeguimientoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Seguimiento;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.SeguimientoRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.SeguimientoService;


@Service
public class SeguimientoServiceImpl extends GenericServiceImpl<SeguimientoRepository, Seguimiento, SeguimientoDTO> implements SeguimientoService{

	public SeguimientoDTO retrive(Long id) {
		Optional<Seguimiento> optional = this.getRepository().findById(id);
		if(optional.isPresent()) {
			Seguimiento s = optional.get();
			return this.getTransformer().toDTO(s);
		}
		return null;
	}
}
