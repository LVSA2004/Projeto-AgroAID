package br.com.fiap.AgroAID.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.AgroAID.model.Clima;
import br.com.fiap.AgroAID.repository.ClimaRepository;

@Service
public class ClimaService {
    
    @Autowired
    ClimaRepository repository;

    public List<Clima> findAll(){
        return repository.findAll();
    }

    public boolean delete(Long id) {
        var task = repository.findById(id);
        if(task.isEmpty()) return false;

        repository.deleteById(id);
        return true;
    }

    public void save(Clima request) {
        repository.save(request);
    }

  
    
}
