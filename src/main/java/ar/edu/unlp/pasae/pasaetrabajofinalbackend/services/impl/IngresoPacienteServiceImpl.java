package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.GenericDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.IngresoPaciente;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.GenericRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.IngresoPacienteRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.IngresoPacienteService;

@Service
public class IngresoPacienteServiceImpl extends GenericServiceImpl implements IngresoPacienteService{
	
	@Autowired
	private IngresoPacienteRepository repository;

	
	public GenericRepository<IngresoPaciente, Long> getRepository() {
		return (GenericRepository<IngresoPaciente, Long>) repository;
	}
	
	
	public IngresoPacienteServiceImpl() {
		super();
	}

	public void setRepository(IngresoPacienteRepository repository) {
		this.repository = repository;
	}


	@Override
	public void update(GenericDTO person) {
		repository.save(this.getGenericTransform().getIngresoPaciente((IngresoPacienteDTO) person));
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
	
	//Prueba para ver si funciona el aspecto que convierte las excepciones no manejadas
//	@Override
//	public void thowException() throws BaseException {
//		throw new RuntimeException("Excepción runtime");
//	}

	
}
