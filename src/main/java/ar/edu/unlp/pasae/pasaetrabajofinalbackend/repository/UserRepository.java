package ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
