package com.legist.myapp.controller;

import com.legist.myapp.domain.ChatMessage;
import com.legist.myapp.domain.MessageStatus;
import com.legist.myapp.dto.ChatMessageDto;
import com.legist.myapp.dto.ChatRoomDto;
import com.legist.myapp.dto.NewsDto;
import com.legist.myapp.dto.UserDto;
import com.legist.myapp.repository.ChatMessageRepository;
import com.legist.myapp.repository.ChatRoomRepository;
import com.legist.myapp.service.ChatMessageService;
import com.legist.myapp.service.ChatRoomService;
import com.legist.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/chat/")
public class ChatController {

    private final UserService userService;
    private final ChatRoomService chatRoomService;
    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageService chatMessageService;
    private final ChatMessageRepository chatMessageRepository;

    @Autowired
    public ChatController(UserService userService, ChatRoomService chatRoomService, ChatRoomRepository chatRoomRepository, ChatMessageService chatMessageService, ChatMessageRepository chatMessageRepository) {
        this.userService = userService;
        this.chatRoomService = chatRoomService;
        this.chatRoomRepository = chatRoomRepository;
        this.chatMessageService = chatMessageService;
        this.chatMessageRepository = chatMessageRepository;
    }

   /* @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessage chatMessage) {
        var chatId = ChatRoomService(chatMessage.getSenderId(), chatMessage.getRecipientId(), true);
        chatMessage.setChatId(chatId.get());

        ChatMessage saved = chatMessageService.save(chatMessage);
        messagingTemplate.convertAndSendToUser(
                chatMessage.getRecipientId(),"/queue/messages",
                new ChatNotification(
                        saved.getId(),
                        saved.getSenderId(),
                        saved.getSenderName()));
    }
*/
   /* @GetMapping("/chatrooms")
    public List<> countNewMessages(
            @PathVariable String senderId,
            @PathVariable String recipientId) {

        return ResponseEntity
                .ok(chatMessageService.countNewMessages(senderId, recipientId));
    }*/
   @GetMapping(value = "/chatrooms")
   public ResponseEntity<List<ChatRoomDto>> getCharRooms(@AuthenticationPrincipal Principal principal) {
       String name = principal.getName();
       UserDto userDto = UserDto.fromUser(userService.findByName(name));
       if (userDto.getName() == null) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       List<ChatRoomDto> result = chatRoomService.getListChatRoom(userDto.getId());
       return result.size() != 0 ? new ResponseEntity<>(result, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }

    @PostMapping("/chatroom/create/{RecipientName}")
    public ResponseEntity<ChatRoomDto> create(@PathVariable String RecipientName, @AuthenticationPrincipal Principal principal) {
        ChatRoomDto chatRoomDto = new ChatRoomDto();
        UserDto IniciatorUser = UserDto.fromUser(userService.findByName(principal.getName()));
        UserDto RecipientUser = UserDto.fromUser(userService.findByName(RecipientName));
        chatRoomDto.setInitiatorId(IniciatorUser);
        chatRoomDto.setRecipientId(RecipientUser);
        chatRoomDto = chatRoomDto.fromChatRoom(chatRoomService.createChatRoom(chatRoomDto));
        return chatRoomDto.getId() != null ? new ResponseEntity<>(chatRoomDto, HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/chatroom/{IdChat}")
    public ResponseEntity<List<ChatMessageDto>> getChatMessage (@PathVariable Long IdChat) {
       List<ChatMessageDto> result = chatMessageService.findChatMessages(IdChat);
       return result.size() != 0 ? new ResponseEntity<>(result, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

  /*  @GetMapping("/chatroom/{IdChat}")
    public ResponseEntity<List<ChatRoomDto>> CheckRoom (@AuthenticationPrincipal Principal principal){
    UserDto userDto = UserDto.fromUser(userService.findByName(principal.getName()));
    List<ChatRoomDto> result = chatRoomService.findChatMessages(IdChat);
        return result.size() != 0 ? new ResponseEntity<>(result, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }*/

    @PostMapping("/sendmessage")
    public ResponseEntity<ChatMessageDto> SendMessage(@RequestBody ChatMessageDto chatMessageDto, @AuthenticationPrincipal Principal principal) {
        UserDto userDto = UserDto.fromUser(userService.findByName(principal.getName()));
        UserDto RecipientUser = UserDto.fromUser(userService.findByName(chatMessageDto.getRecipientName()));
        chatMessageDto.setRecipientName(RecipientUser.getName());
        chatMessageDto.setRecipientId(RecipientUser);
        chatMessageDto.setSenderId(userDto);
        ChatRoomDto chatRoomDto = ChatRoomDto.fromChatRoom(chatRoomService.findById(chatMessageDto.getChatId().getId()));
        chatMessageDto.setChatId(chatRoomDto);
        chatMessageDto.setSenderName(userDto.getName());
        chatMessageDto.setDatemessage(LocalDateTime.now());
        chatMessageDto.setStatus(MessageStatus.RECEIVED);
        chatMessageDto = chatMessageDto.fromChatMessage(chatMessageService.createChatMessage(chatMessageDto));
        return chatMessageDto.getId() != null ? new ResponseEntity<>(chatMessageDto, HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
