package br.com.fiap.AgroAID.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.AgroAID.model.Dialog;
import br.com.fiap.AgroAID.repository.DialogRepository;

@Service
public class DialogService {
    

    @Autowired
    DialogRepository repository;

    public Dialog save(String title){

        Dialog dialog = new Dialog();

        dialog.setTitle(title);

        repository.save(dialog);

        return dialog;
    }

    public List<Dialog> findAll(){

        return repository.findAll();
    }

}
