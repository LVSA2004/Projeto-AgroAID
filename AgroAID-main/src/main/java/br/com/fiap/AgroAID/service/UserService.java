package br.com.fiap.AgroAID.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.AgroAID.model.User;
import br.com.fiap.AgroAID.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository repository;

    public void saveUser(User user) {
    }
    
}
