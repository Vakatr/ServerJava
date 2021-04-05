package com.legist.myapp.service.impl;

import com.legist.myapp.domain.Role;
import com.legist.myapp.domain.Status;
import com.legist.myapp.domain.User;
import com.legist.myapp.dto.GuestDto;
import com.legist.myapp.dto.MessageDto;
import com.legist.myapp.dto.UserDto;
import com.legist.myapp.exceptions.UserNotFoundException;
import com.legist.myapp.repository.RoleRepository;
import com.legist.myapp.repository.UserDetailsRepository;
import com.legist.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserDetailsRepository userDetailsRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDetailsRepository userDetailsRepository,
                           RoleRepository roleRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.userDetailsRepository = userDetailsRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(GuestDto guestDto) {
        User user = guestDto.toUser();
        if (user.getName().length()<3) {return null;}
        Role role = roleRepository.findByName("USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);
        user.setCreated(LocalDateTime.now());
        user.setLastVisit(LocalDateTime.now());
        user.setUpdated(LocalDateTime.now());
        return userDetailsRepository.save(user);
    }

    @Override
    public List<UserDto> getAll(String filter) {
        List<UserDto> ListUsers = null;
        if (filter == "all") {
            ListUsers = userDetailsRepository.findAll()
                    .stream()
                    .map(UserDto::fromUser)
                    .collect(Collectors.toList());
        }
        else if (filter == "legists") {
            ListUsers = userDetailsRepository
                    .findByLegists()
                    .stream()
                    .map(UserDto::fromUser)
                    .collect(Collectors.toList());
        }
        return ListUsers;
    }

    @Override
    public User findByName(String name) {
        return userDetailsRepository.findByName(name);
    }

    @Override
    public User findById(String id) {
        return userDetailsRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void delete(String id) {
        userDetailsRepository.deleteById(id);
    }

    @Override
    public boolean save(User user) {
        userDetailsRepository.save(user);
        return true;
    }

}
