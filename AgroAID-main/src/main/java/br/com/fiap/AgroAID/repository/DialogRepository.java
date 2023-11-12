package br.com.fiap.AgroAID.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.AgroAID.model.Dialog;

public interface DialogRepository extends JpaRepository<Dialog, Long> {
    
}
