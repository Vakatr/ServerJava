package com.legist.myapp.service;

import com.legist.myapp.domain.Message;
import com.legist.myapp.dto.MessageDto;

import java.util.List;

public interface MessageService {
    Message createMessage(MessageDto messageDto);
    List<MessageDto> getAllMessages();
    Message updateMessage(Message messageFromDb, Message message);
    void deleteMessage(Message message);
    MessageDto findById(Long id);
}
