package com.legist.myapp.repository;

import com.legist.myapp.domain.TypeOfTransport;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface TypeOfTransportRepository extends Repository<TypeOfTransport, Long> {
    Set<TypeOfTransport> findAll();

    TypeOfTransport findById(Long id);

    Long findIdByName(String name);

    TypeOfTransport findByName(String name);
}
