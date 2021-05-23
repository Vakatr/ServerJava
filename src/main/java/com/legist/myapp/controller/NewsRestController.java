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
@RequestMapping(value = "/api/v1/news/")
public class NewsRestController {

    private final UserService userService;
    private final NewsService newsService;
    private final NewsRepository newsRepository;

    @Autowired
    public NewsRestController(UserService userService, NewsService newsService, NewsRepository newsRepository) {
        this.userService = userService;
        this.newsService = newsService;
        this.newsRepository = newsRepository;
    }

    @GetMapping(value = "/listnews")
    public ResponseEntity<List<NewsDto>> getAll() {
        List<NewsDto> result = newsService.getAllNews();
        return result.size() != 0 ? new ResponseEntity<>(result, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<NewsDto> create(@RequestBody NewsDto newsDto, @AuthenticationPrincipal Principal principal) {
        UserDto userDto = UserDto.fromUser(userService.findByName(principal.getName()));
        newsDto.setAuthor(userDto);
        newsDto = newsDto.fromNews(newsService.createNew(newsDto));
        return newsDto.getId() != null ? new ResponseEntity<>(newsDto, HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<NewsDto> update(@PathVariable("id") News newsFromDb,
                                             @RequestBody News news) {
        NewsDto result = NewsDto.fromNews(newsService.updateNew(newsFromDb, news));
        return result.getId() != null ? new ResponseEntity<NewsDto>(result, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        News news = newsRepository.getOne(id);
        newsRepository.delete(news);
        return new ResponseEntity(HttpStatus.OK);
    }
}
