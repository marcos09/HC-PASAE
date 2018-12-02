package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.GenericDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.GenericPersistentEntity;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.GenericRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.GenericService;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.transform.Transformer;

public abstract class GenericServiceImpl<T extends GenericRepository<entityType> , entityType extends GenericPersistentEntity, dtoType extends GenericDTO> implements GenericService{

	@Autowired
	private Transformer<entityType, dtoType> transformer;
	
	@Autowired
	private T repository;
	
	protected T getRepository() {
		return repository;
	}

	protected void setRepository(T repository) {
		this.repository = repository;
	}

	public boolean existsById(Long id) {
		return this.getRepository().existsById(id);
	}
	
	protected Transformer<entityType, dtoType> getTransformer() {
		return transformer;
	}

	protected void setTransformer(Transformer<entityType, dtoType> transformer) {
		this.transformer = transformer;
	}

	protected GenericServiceImpl() {
		super();
	}

	
	

}
