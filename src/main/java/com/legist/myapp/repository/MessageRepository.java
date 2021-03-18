package com.legist.myapp.repository;

import com.legist.myapp.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
    void deleteById(Long id);
}
