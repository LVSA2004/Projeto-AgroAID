package br.com.fiap.AgroAID.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.AgroAID.model.Clima;
import net.aksingh.owmjapis.model.CurrentWeather;


public interface ClimaRepository extends JpaRepository<Clima, Long>{

    void save(CurrentWeather dados);

   
    
}
