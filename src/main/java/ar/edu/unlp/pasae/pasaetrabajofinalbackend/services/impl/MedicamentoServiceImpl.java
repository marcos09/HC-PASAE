package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.MedicamentoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Medicamento;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.MedicamentoRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.MedicamentoService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.Transformer;

@Service
@Transactional

public class MedicamentoServiceImpl implements MedicamentoService {

	@Autowired
	private Transformer<Medicamento, MedicamentoDTO> transformer;
	
	@Autowired
	private MedicamentoRepository repository;
	
	@Override
	public List<MedicamentoDTO> list() {
		List<Medicamento> listMedicamentos = this.getRepository().findAll();
		return this.getTransformer().toListDTO(listMedicamentos);

	}
	
	@Override
	public MedicamentoDTO retrive(Long id) {
		Medicamento medicamento = this.getRepository().findById(id).get();
		return this.getTransformer().toDTO(medicamento);
	}

	public Transformer<Medicamento, MedicamentoDTO> getTransformer() {
		return transformer;
	}

	public void setTransformer(Transformer<Medicamento, MedicamentoDTO> transformer) {
		this.transformer = transformer;
	}

	public MedicamentoRepository getRepository() {
		return repository;
	}

	public void setRepository(MedicamentoRepository repository) {
		this.repository = repository;
	}
	
	
	

}