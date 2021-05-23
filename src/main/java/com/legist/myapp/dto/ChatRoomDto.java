package com.legist.myapp.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.legist.myapp.domain.*;
import java.time.LocalDateTime;

@JsonAutoDetect
public class ChatRoomDto {
  private Long id;
  private UserDto recipientId;
  private UserDto initiatorId;

  public ChatRoom toChatRoom() {
    ChatRoom chatRoom = new ChatRoom();
    chatRoom.setId(id);
    chatRoom.setInitiatorId(initiatorId.toUser());
    chatRoom.setRecipientId(recipientId.toUser());
    return chatRoom;
  }

  public static ChatRoomDto fromChatRoom(ChatRoom chatRoom) {
    ChatRoomDto chatRoomDto = new ChatRoomDto();
    chatRoomDto.setId(chatRoom.getId());
    chatRoomDto.setInitiatorId(UserDto.fromUser(chatRoom.getInitiatorId()));
    chatRoomDto.setRecipientId(UserDto.fromUser(chatRoom.getRecipientId()));
    return chatRoomDto;
  }
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UserDto getRecipientId() {
    return recipientId;
  }
  public void setRecipientId(UserDto recipientId) {
    this.recipientId = recipientId;
  }

  public UserDto getInitiatorId() {
    return initiatorId;
  }

  public void setInitiatorId(UserDto initiatorId) {
    this.initiatorId = initiatorId;
  }

}
