package com.legist.myapp.service;

import com.legist.myapp.domain.ChatRoom;
import com.legist.myapp.dto.ChatRoomDto;
import com.legist.myapp.repository.ChatRoomRepository;
import com.legist.myapp.repository.UserDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final UserDetailsRepository userDetailsRepository;

    public ChatRoomService(ChatRoomRepository chatRoomRepository,
                           UserDetailsRepository userDetailsRepository) {
        this.chatRoomRepository = chatRoomRepository;
        this.userDetailsRepository = userDetailsRepository;
    }

    public ChatRoom createChatRoom(ChatRoomDto chatRoomDto) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setInitiatorId(userDetailsRepository.findByName(chatRoomDto.getInitiatorId().getName()));
        chatRoom.setRecipientId(userDetailsRepository.findByName(chatRoomDto.getRecipientId().getName()));
        return chatRoomRepository.save(chatRoom);
    }

    public List<ChatRoomDto> getListChatRoom(String id) {
        return chatRoomRepository.findChatRoomsById(id)
                .stream()
                .map(ChatRoomDto::fromChatRoom)
                .collect(Collectors.toList());
    }


    public void deleteChatRoom(ChatRoom chatRoom) {
        chatRoomRepository.deleteById(chatRoom.getId());
    }

    public ChatRoom findById(Long id) {
        return chatRoomRepository.findById(id);
    }

}
