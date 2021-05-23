package com.legist.myapp.service;

import com.amr.chatservice.exception.ResourceNotFoundException;
import com.legist.myapp.domain.ChatMessage;
import com.legist.myapp.dto.ChatMessageDto;
import com.legist.myapp.domain.MessageStatus;
import com.legist.myapp.repository.ChatMessageRepository;
import com.legist.myapp.repository.UserDetailsRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatMessageService {
     private final ChatMessageRepository repository;
     private final ChatRoomService chatRoomService;
     private final UserDetailsRepository userDetailsRepository;

    public ChatMessageService(ChatMessageRepository repository, ChatRoomService chatRoomService, UserDetailsRepository userDetailsRepository) {
        this.repository = repository;
        this.chatRoomService = chatRoomService;
        this.userDetailsRepository = userDetailsRepository;
    }


    public ChatMessage createChatMessage(ChatMessageDto chatMessageDto) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setChatId(chatMessageDto.getChatId().toChatRoom());
        chatMessage.setContent(chatMessageDto.getContent());
        chatMessage.setRecipientName(chatMessageDto.getRecipientName());
        chatMessage.setSenderName(chatMessageDto.getSenderName());
        chatMessage.setDatemessage(LocalDateTime.now());
        chatMessage.setRecipientId(userDetailsRepository.findByName(chatMessageDto.getRecipientId().getName()));
        chatMessage.setSenderId(userDetailsRepository.findByName(chatMessageDto.getSenderId().getName()));
        chatMessage.setStatus(MessageStatus.RECEIVED);
        repository.save(chatMessage);
        return chatMessage;
    }

/*    public long countNewMessages(String senderId, String recipientId) {

        return repository.countBySenderIdAndRecipientIdAndStatus(
                senderId, recipientId, MessageStatus.RECEIVED);
    }*/

    public List<ChatMessageDto> findChatMessages(Long id) {
        updateStatuses(id, MessageStatus.DELIVERED);
        return repository.findByChatId(id)
                .stream()
                .map(ChatMessageDto::fromChatMessage)
                .collect(Collectors.toList());
    }

    public ChatMessage findById(String id) {
        return repository
                .findById(id)
                .map(chatMessage -> {
                    chatMessage.setStatus(MessageStatus.DELIVERED);
                    return repository.save(chatMessage);
                })
                .orElseThrow(() ->
                        new ResourceNotFoundException("can't find message (" + id + ")"));
    }

    public void updateStatuses(Long id, MessageStatus status) {
        List<ChatMessage> messages =
                repository.findByChatId(id);
        for (ChatMessage message:messages) {
            message.setStatus(status);
        }
        repository.saveAll(messages);

    }
}
