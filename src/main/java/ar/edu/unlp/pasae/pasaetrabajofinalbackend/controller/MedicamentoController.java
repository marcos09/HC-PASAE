package ar.edu.unlp.pasae.pasaetrabajofinalbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.MedicamentoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.MedicamentoService;

@RestController
@CrossOrigin
@RequestMapping("/medicamentos")
public class MedicamentoController {
	
	@Autowired
	private MedicamentoService medicamentoService;
	
	@GetMapping(path = "/list")
	public List<MedicamentoDTO> list() {
		List<MedicamentoDTO> medicamentos = this.getMedicamentoService().list();
		return medicamentos;
	}

	public MedicamentoService getMedicamentoService() {
		return medicamentoService;
	}

	public void setMedicamentoService(MedicamentoService medicamentoService) {
		this.medicamentoService = medicamentoService;
	}
	
	


}
