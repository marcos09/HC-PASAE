package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services;

import java.util.List;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.MedicamentoDTO;

public interface MedicamentoService  {
	MedicamentoDTO retrive(Long id);
	List<MedicamentoDTO> list();

}
