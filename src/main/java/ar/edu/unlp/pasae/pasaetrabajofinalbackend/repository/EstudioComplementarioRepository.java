package ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository;

import java.util.List;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.EstudioComplementario;


public interface EstudioComplementarioRepository extends GenericRepository<EstudioComplementario> {

	List<EstudioComplementario> findByInformeResultadoIsNull();

}
