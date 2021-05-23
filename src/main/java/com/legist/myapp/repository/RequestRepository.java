package com.legist.myapp.repository;


import com.legist.myapp.domain.Requests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequestRepository extends JpaRepository<Requests, Long> {
    void deleteById(Long id);
    @Query( "select r from Requests r where r.userId.id =?1" )
    List<Requests> findUserRequests(String id);
    @Query( "select r from Requests r where r.userSpecialistId.id =?1" )
    List<Requests> findLegistRequests(String id);
}
