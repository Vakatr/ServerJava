package com.legist.myapp.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "chatroom")
public class ChatRoom {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "initiator_id")
  private User initiatorId;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "recipient_id")
  private User recipientId;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public User getInitiatorId() {
    return initiatorId;
  }

  public void setInitiatorId(User initiatorId) {
    this.initiatorId = initiatorId;
  }


  public User getRecipientId() {
    return recipientId;
  }

  public void setRecipientId(User recipientId) {
    this.recipientId = recipientId;
  }

}
