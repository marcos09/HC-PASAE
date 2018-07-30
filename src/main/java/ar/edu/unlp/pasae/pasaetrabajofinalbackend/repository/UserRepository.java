package ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository;


import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.User;

public interface UserRepository extends GenericRepository<User>{

	User findByEmail(String email);

	User findByUsername(String username);
}
