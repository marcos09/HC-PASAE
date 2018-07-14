package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.IngresoPacienteDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.exception.BaseException;



public interface IngresoPacienteService{
	
	
	void create(IngresoPacienteDTO persistentDTO); 
	void update(IngresoPacienteDTO persistentDTO);
	void delete(Long id); 
	IngresoPacienteDTO retrive(Long id);
	List<IngresoPacienteDTO> list();
	
	//Prueba para ver si funciona el aspecto que convierte las excepciones no manejadas
	//void thowException() throws BaseException;

}