package com.legist.myapp.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.legist.myapp.domain.ChatMessage;
import com.legist.myapp.domain.MessageStatus;

import java.time.LocalDateTime;

@JsonAutoDetect
public class ChatMessageDto {
  private Long id;
  private ChatRoomDto chatId;
  private String senderName;
  private String recipientName;
  private String content;
  private LocalDateTime datemessage;
  private MessageStatus status;
  private UserDto senderId;
  private UserDto recipientId;

  public ChatMessage toChatMessage() {
    ChatMessage chatMessage = new ChatMessage();
    chatMessage.setId(id);
    chatMessage.setChatId(chatId.toChatRoom());
    chatMessage.setContent(content);
    chatMessage.setDatemessage(datemessage);
    chatMessage.setStatus(status);
    chatMessage.setSenderName(senderName);
    chatMessage.setSenderId(senderId.toUser());
    chatMessage.setRecipientName(recipientName);
    chatMessage.setRecipientId(recipientId.toUser());
    return chatMessage;
  }

  public static ChatMessageDto fromChatMessage(ChatMessage chatMessage) {
    ChatMessageDto chatRoomDto = new ChatMessageDto();
    chatRoomDto.setId(chatMessage.getId());
    chatRoomDto.setChatId(ChatRoomDto.fromChatRoom(chatMessage.getChatId()));
    chatRoomDto.setContent(chatMessage.getContent());
    chatRoomDto.setDatemessage(chatMessage.getDatemessage());
    chatRoomDto.setStatus(chatMessage.getStatus());
    chatRoomDto.setSenderName(chatMessage.getSenderName());
    chatRoomDto.setRecipientName(chatMessage.getRecipientName());
    chatRoomDto.setSenderId(UserDto.fromUser(chatMessage.getSenderId()));
    chatRoomDto.setRecipientId(UserDto.fromUser(chatMessage.getRecipientId()));
    return chatRoomDto;
  }
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ChatRoomDto getChatId() {
    return chatId;
  }

  public void setChatId(ChatRoomDto chatId) {
    this.chatId = chatId;
  }

  public String getSenderName() {
    return senderName;
  }

  public void setSenderName(String senderName) {
    this.senderName = senderName;
  }

  public String getRecipientName() {
    return recipientName;
  }

  public void setRecipientName(String recipientName) {
    this.recipientName = recipientName;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public LocalDateTime getDatemessage() {
    return datemessage;
  }

  public void setDatemessage(LocalDateTime datemessage) {
    this.datemessage = datemessage;
  }

  public MessageStatus getStatus() {
    return status;
  }

  public void setStatus(MessageStatus status) {
    this.status = status;
  }

  public UserDto getRecipientId() {
    return recipientId;
  }

  public void setRecipientId(UserDto recipientId) {
    this.recipientId = recipientId;
  }

  public UserDto getSenderId() {
    return senderId;
  }

  public void setSenderId(UserDto senderId) {
    this.senderId = senderId;
  }
}
