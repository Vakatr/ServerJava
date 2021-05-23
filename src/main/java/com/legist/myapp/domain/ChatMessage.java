package com.legist.myapp.domain;

import com.legist.myapp.dto.ChatMessageDto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Entity
@Table(name = "chatmessage")
public class ChatMessage {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "chat_id")
  private ChatRoom chatId;
  @Column(name = "sender_name")
  private String senderName;
  @Column(name = "recipient_name")
  private String recipientName;
  @NotBlank(message = "Пустое содержимое!")
  private String content;
  private LocalDateTime datemessage;
  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  private MessageStatus status;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "sender_id")
  private User senderId;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "recipient_id")
  private User recipientId;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public ChatRoom getChatId() {
    return chatId;
  }

  public void setChatId(ChatRoom chatId) {
    this.chatId = chatId;
  }

  public User getRecipientId() {
    return recipientId;
  }

  public void setRecipientId(User recipientId) {
    this.recipientId = recipientId;
  }


  public User getSenderId() {
    return senderId;
  }

  public void setSenderId(User senderId) {
    this.senderId = senderId;
  }

  public String getRecipientName() {
    return recipientName;
  }

  public void setRecipientName(String recipientName) {
    this.recipientName = recipientName;
  }

  public String getSenderName() {
    return senderName;
  }

  public void setSenderName(String senderName) {
    this.senderName = senderName;
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
}
