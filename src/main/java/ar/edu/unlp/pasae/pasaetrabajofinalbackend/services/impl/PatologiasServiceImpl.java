package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.GenericDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PatologiaDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.Patologia;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.GenericRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.PatologiasRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.PatologiasService;

@Service
public class PatologiasServiceImpl extends GenericServiceImpl implements PatologiasService{

	
	@Autowired
	private PatologiasRepository repository;

	@Override
	public void update(GenericDTO patologia) {
		repository.save(this.getGenericTransform().getPatologia((PatologiaDTO) patologia));
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

	public GenericRepository<Patologia, Long> getRepository() {
		return (GenericRepository<Patologia, Long>) repository;
	}

	public void setRepository(PatologiasRepository repository) {
		this.repository = repository;
	}

}