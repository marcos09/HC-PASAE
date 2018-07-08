package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.GenericDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.GenericPersistentClass;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.GenericService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.Transform;

public abstract class GenericServiceImpl implements GenericService {
	
	@Autowired
	private Transform genericTransform;
	
	public Transform getGenericTransform() {
		return genericTransform;
	}

	public void setGenericTransform(Transform genericTransform) {
		this.genericTransform = genericTransform;
	}

	/*
	@Override
	public void create(PersonDTO person) {
		Person persistentEntityModel = new (person.getId(), person.getSurname(), person.getName(), person.getPhoneNumber());
		
		repository.save(personModel);
	}
	*/
	
	
	/*
	public List<GenericDTO> list(){
		//List<GenericPersistentClass> result = this.getRepository();
		return null;
	}
	
	*/
	

}
