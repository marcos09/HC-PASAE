package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.GenericDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PatologiaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Patologia;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.GenericRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.PatologiasRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.PatologiasService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.Transform;

@Service
public class PatologiasServiceImpl extends GenericServiceImpl implements PatologiasService{

	
	@Autowired
	private PatologiasRepository repository;

	@Override
	public void create(GenericDTO persistentDTO) {

		repository.save(this.getGenericTransform().getPatologia((PatologiaDTO) persistentDTO));
	}

	@Override
	public void update(GenericDTO patologia) {
		repository.save(this.getGenericTransform().getPatologia((PatologiaDTO) patologia));
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}


	@Override
	public GenericDTO retrive(Long id) {
		Optional<Patologia> patologia = repository.findById(id);
		if(patologia.isPresent()) {
			return this.getGenericTransform().getPatologiaDTO(patologia.get());
		}
		return null;
	}

	@Override
	public List<GenericDTO> list() {
		 List<Patologia> ingresos = repository.findAll();
		 
		 List<GenericDTO> list = new ArrayList<GenericDTO>();
		 Iterator<Patologia> it = ingresos.iterator();
		 while(it.hasNext()) {
			 Patologia patologia = (Patologia) it.next();
			 PatologiaDTO patologiaDTO = this.getGenericTransform().getPatologiaDTO(patologia);
			 list.add((GenericDTO) patologiaDTO);
		 }
		 return list;
	}

	public GenericRepository getRepository() {
		return (GenericRepository) repository;
	}

	public void setRepository(PatologiasRepository repository) {
		this.repository = repository;
	}

}