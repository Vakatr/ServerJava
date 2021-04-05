package com.legist.myapp.repository;

import com.legist.myapp.domain.Role;
import com.legist.myapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDetailsRepository extends JpaRepository<User, String> {
    User findByName(String name);
    @Query( "select u from User u inner join u.roles r where r.id =3" )
    List<User> findByLegists();
}

