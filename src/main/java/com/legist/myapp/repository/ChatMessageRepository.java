package com.legist.myapp.repository;


import com.legist.myapp.domain.ChatMessage;
import com.legist.myapp.domain.ChatRoom;
import com.legist.myapp.domain.MessageStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatMessageRepository
        extends JpaRepository<ChatMessage, String> {

    long countBySenderIdAndRecipientIdAndStatus(
            String senderId, String recipientId, MessageStatus status);

    @Query("SELECT u FROM ChatMessage u WHERE u.chatId.id = ?1")
    List<ChatMessage> findByChatId(Long chatId);
}

