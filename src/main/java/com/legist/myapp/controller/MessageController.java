/*
package com.legist.myapp.controller;

import com.legist.myapp.domain.Comments;
import com.legist.myapp.domain.Message;
import com.legist.myapp.domain.Status;
import com.legist.myapp.dto.MessageDto;
import com.legist.myapp.dto.UserDto;
import com.legist.myapp.repository.CommentsRepository;
import com.legist.myapp.repository.MessageRepository;
import com.legist.myapp.repository.MessageStatusesRepository;
import com.legist.myapp.service.MessageService;
import com.legist.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/message/")
public class MessageController {

    private final MessageRepository messageRepository;
    private final MessageService messageService;
    private final CommentsRepository commentsRepository;
    private final UserService userService;
    private final MessageStatusesRepository messageStatusesRepository;

    @Autowired
    public MessageController(MessageRepository messageRepository, MessageService messageService, CommentsRepository commentsRepository, UserService userService, MessageStatusesRepository messageStatusesRepository) {
        this.messageRepository = messageRepository;
        this.messageService = messageService;
        this.commentsRepository = commentsRepository;
        this.userService = userService;
        this.messageStatusesRepository = messageStatusesRepository;
    }


    @GetMapping
    public ResponseEntity<List<MessageDto>> list() {

        List<MessageDto> result = messageService.getAllMessages();
        return result.size() != 0 ? new ResponseEntity<>(result, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDto> getOne(@PathVariable("id") Message message) {
        MessageDto result = MessageDto.fromMessage(message);
        return result.getId() != null ? new ResponseEntity<>(result, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create/")
    @PreAuthorize("hasAnyAuthority(\"ADMIN\", \"MODERATOR\", \"USER\")")
    public ResponseEntity<MessageDto> create(@RequestBody MessageDto messageDto, @AuthenticationPrincipal Principal principal) {
        UserDto userDto = UserDto.fromUser(userService.findByName(principal.getName()));
        messageDto.setAuthor(userDto);
        messageDto = MessageDto.fromMessage(messageService.createMessage(messageDto));
        return messageDto.getId() != null ? new ResponseEntity<>(messageDto, HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MODERATOR', 'USER')")
    public ResponseEntity<MessageDto> update(@PathVariable("id") Message messageFromDb,
                          @RequestBody Message message) {
        MessageDto result = MessageDto.fromMessage(messageService.updateMessage(messageFromDb, message));
        return result.getId() != null ? new ResponseEntity<>(result, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MODERATOR', 'USER')")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        Message message = messageRepository.getOne(id);
        message.setStatus(Status.DELETED);
        messageRepository.save(message);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping("addComment/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MODERATOR', 'USER')")
    public ResponseEntity<MessageDto> addComment(@PathVariable("id") Long id,
                                                 @RequestParam("text") String text,
                                                 @AuthenticationPrincipal Principal principal) {
        Message message = messageRepository.findById(id).get();
        Comments comments = new Comments(message, text, userService.findByName(principal.getName()));
        commentsRepository.save(comments);
        message.getComments().add(comments);
        messageRepository.save(message);
        return new ResponseEntity<>(MessageDto.fromMessage(message), HttpStatus.OK);
    }

    @RequestMapping("removeComment/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MODERATOR', 'USER')")
    public ResponseEntity<MessageDto> removeComment(@PathVariable("id") Comments comments) {
        commentsRepository.delete(comments);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("approveMessage/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MODERATOR')")
    public ResponseEntity<MessageDto> approveMessage(@PathVariable("id") Message message) {
        message.setMessageStatus(messageStatusesRepository.findById(3L));
        messageRepository.save(message);
        return new ResponseEntity<>(MessageDto.fromMessage(message), HttpStatus.OK);
    }

}

*/
