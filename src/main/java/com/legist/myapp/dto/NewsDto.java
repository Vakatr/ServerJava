package com.legist.myapp.dto;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.legist.myapp.domain.*;
import com.legist.myapp.service.impl.UserServiceImpl;

import java.time.LocalDateTime;


@JsonAutoDetect
public class NewsDto {
    private Long id;
    private String title;
    private String text;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateOfCreated;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateOfUpdated;
    private UserDto author;
    private String file;

    public News toNews() {
        News news = new News();
        news.setId(id);
        news.setTitle(title);
        news.setText(text);
        news.setDateOfCreated(dateOfCreated);
        news.setDateOfUpdated(LocalDateTime.now());
        news.setIdAuthor(author.toUser());
        news.setFile(file);
        return news;
    }

    public static NewsDto fromNews(News news) {
        NewsDto newsDto = new NewsDto();
        newsDto.setId(news.getId());
        newsDto.setTitle(news.getTitle());
        newsDto.setText(news.getText());
        newsDto.setDateOfCreated(news.getDateOfCreated());
        newsDto.setDateOfUpdated(news.getDateOfUpdated());
        newsDto.setAuthor(UserDto.fromUser(news.getIdAuthor()));
        newsDto.setFile(news.getFile());
        return newsDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDateOfCreated() {
        return dateOfCreated;
    }

    public void setDateOfCreated(LocalDateTime dateOfCreated) {
        this.dateOfCreated = dateOfCreated;
    }

    public LocalDateTime getUpdated() {
        return dateOfUpdated;
    }

    public void setDateOfUpdated(LocalDateTime dateOfUpdated) {
        this.dateOfUpdated = dateOfUpdated;
    }


    public UserDto getAuthor() {
        return author;
    }

    public void setAuthor(UserDto author) {
        this.author = author;
    }

    public LocalDateTime getDateOfUpdated() {
        return dateOfUpdated;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
