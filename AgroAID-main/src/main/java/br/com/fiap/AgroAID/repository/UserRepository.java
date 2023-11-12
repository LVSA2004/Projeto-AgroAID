package br.com.fiap.AgroAID.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.AgroAID.model.User;

public interface UserRepository extends JpaRepository<User, String> {

    
}
