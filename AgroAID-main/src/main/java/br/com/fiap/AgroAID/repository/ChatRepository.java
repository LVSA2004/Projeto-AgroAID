package br.com.fiap.AgroAID.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.AgroAID.model.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    List<Chat> findChatByDialogId(Long id);
    
} 
