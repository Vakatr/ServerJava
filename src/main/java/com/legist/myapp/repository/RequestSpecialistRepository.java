package com.legist.myapp.repository;


import com.legist.myapp.domain.RequestsSpecialist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequestSpecialistRepository extends JpaRepository<RequestsSpecialist, Long> {
    void deleteById(Long id);
    @Query( "select r from RequestsSpecialist r where r.userId.id =?1" )
    List<RequestsSpecialist> findUserRequestsSpecialist(String id);
}
