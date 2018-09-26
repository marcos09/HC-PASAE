package ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface GenericRepository<T> extends JpaRepository<T,Long>, PagingAndSortingRepository<T, Long> {
	
}
