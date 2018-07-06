package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.GenericDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.exception.BaseException;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.GenericRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.IngresoPacienteRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.IngresoPacienteService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.Transform;

@Service
public class IngresoPacienteServiceImpl extends GenericServiceImpl implements IngresoPacienteService{
	
	@Autowired
	private IngresoPacienteRepository repository;

	@Autowired
	private Transform genericTransform;
	
	public IngresoPacienteRepository getRepository() {
		return repository;
	}
	
	
	public IngresoPacienteServiceImpl() {
		super();
	}

	public void setRepository(IngresoPacienteRepository repository) {
		this.repository = repository;
	}

	@Override
	public void create(GenericDTO persistentDTO) {
		
		repository.save(this.getGenericTransform().getIngresoPaciente((IngresoPacienteDTO) persistentDTO));
	}

	@Override
	public void update(GenericDTO person) {
		repository.save(this.getGenericTransform().getIngresoPaciente((IngresoPacienteDTO) person));
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public GenericDTO retrive(Long id) {
		Optional<IngresoPaciente> ingreso = repository.findById(id);
		if(ingreso.isPresent()) {
			return genericTransform.getIngresoPacienteDTO(ingreso.get());
		}
		return null;
	}

	@Override
	public List<GenericDTO> list() {
		 List<IngresoPaciente> ingresos = repository.findAll();
		 
		 List<GenericDTO> list = new ArrayList<GenericDTO>();
		 Iterator<IngresoPaciente> it = ingresos.iterator();
		 while(it.hasNext()) {
			 IngresoPaciente ingreso = (IngresoPaciente) it.next();
			 IngresoPacienteDTO ingresoDTO = this.getGenericTransform().getIngresoPacienteDTO(ingreso);
			 list.add(ingresoDTO);
		 }
		 return list;
	}

	public Transform getGenericTransform() {
		return genericTransform;
	}

	public void setGenericTransform(Transform genericTransform) {
		this.genericTransform = genericTransform;
	}
	
	//Prueba para ver si funciona el aspecto que convierte las excepciones no manejadas
//	@Override
//	public void thowException() throws BaseException {
//		throw new RuntimeException("Excepción runtime");
//	}

	
}
