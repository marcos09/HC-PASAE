package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.GenericDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.GenericPersistentEntity;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.GenericService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.Transform;
@SuppressWarnings("unchecked")

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
	
	@Override
	public void delete(Long id) {
		this.getRepository().deleteById(id);
	}

	@Override
	public GenericDTO retrive(Long id) {
		Optional<GenericPersistentEntity> optionalEntity = this.getRepository().findById(id);
		if(optionalEntity.isPresent()) {
			return this.getGenericTransform().getEntityDTO(optionalEntity.get());
		}
		return null;
	}
	@Override
	public void create(GenericDTO persistentDTO) {
		this.getRepository().save(this.getGenericTransform().getEntity(persistentDTO));

	}

	@Override
	public void update(GenericDTO genericDTO) {
		this.create(genericDTO);
	}

	
	/*
	public List<GenericDTO> list(){
		//List<GenericPersistentClass> result = this.getRepository();
		return null;
	}
	
	*/
	

}
