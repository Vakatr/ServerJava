package com.legist.myapp.repository;


import com.legist.myapp.domain.ChatRoom;
import com.legist.myapp.domain.User;
import com.legist.myapp.dto.ChatRoomDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, String> {
    ChatRoom findById(Long id);
    void deleteById(Long id);
    @Query("SELECT u FROM ChatRoom u WHERE u.initiatorId.id = ?1 or u.recipientId.id = ?1")
    List<ChatRoom> findChatRoomsById(String id);
}
