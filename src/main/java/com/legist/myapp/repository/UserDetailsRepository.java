package com.legist.myapp.repository;

import com.legist.myapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<User, String> {
    User findByName(String name);
}

