package com.legist.myapp.repository;

import com.legist.myapp.domain.MessageStatus;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface MessageStatusesRepository extends Repository<MessageStatus, Long> {
    Set<MessageStatus> findAll();

    MessageStatus findById(Long id);
}
