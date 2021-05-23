package com.legist.myapp.controller;

import com.legist.myapp.domain.News;
import com.legist.myapp.domain.User;
import com.legist.myapp.dto.NewsDto;
import com.legist.myapp.dto.UserDto;
import com.legist.myapp.repository.NewsRepository;
import com.legist.myapp.service.NewsService;
import com.legist.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/admin/")
public class AdminRestControllerV1 {

    private final UserService userService;
    private final NewsService newsService;
    private final NewsRepository newsRepository;

    @Autowired
    public AdminRestControllerV1(UserService userService,NewsService newsService,NewsRepository newsRepository) {
        this.userService = userService;
        this.newsService = newsService;
        this.newsRepository = newsRepository;
    }

    @GetMapping(value = "users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") String id) {
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        UserDto result = UserDto.fromUser(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
