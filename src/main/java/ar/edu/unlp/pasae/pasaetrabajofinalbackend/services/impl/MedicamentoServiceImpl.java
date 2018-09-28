package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.MedicamentoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Medicamento;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.MedicamentoRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.MedicamentoService;

@Service
@Transactional

public class MedicamentoServiceImpl extends GenericServiceImpl<MedicamentoRepository, Medicamento, MedicamentoDTO> implements MedicamentoService {

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

	@Override
	public MedicamentoDTO create(MedicamentoDTO medicamentoDTO) {
		Medicamento medicamento = this.getTransformer().toEntity(medicamentoDTO);
		return this.getTransformer().toDTO(this.getRepository().save(medicamento));
	}
	/*
	public Iterable<MedicamentoDTO> medicamentosByPage(int pageNumber, int pageSize){
	      PageRequest pageRequest = new PageRequest(pageNumber,pageSize);
	      Iterable<Medicamento> res = this.getRepository().findAll(pageRequest);
	      
	      // return  this.getTransformer().toCollectionDTO(res);
	      return null;
	   }
	*/
	
}
