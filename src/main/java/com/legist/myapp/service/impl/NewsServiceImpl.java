package com.legist.myapp.service.impl;

import com.legist.myapp.domain.News;
import com.legist.myapp.dto.NewsDto;
import com.legist.myapp.exceptions.UserNotFoundException;
import com.legist.myapp.repository.NewsRepository;
import com.legist.myapp.repository.UserDetailsRepository;
import com.legist.myapp.service.NewsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;
    private final UserDetailsRepository userDetailsRepository;


    @Autowired
    public NewsServiceImpl(UserDetailsRepository userDetailsRepository,
                           NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public News createNew(NewsDto newsDto) {
        News news = new News();
        news.setIdAuthor(userDetailsRepository.findByName(newsDto.getAuthor().getName()));
        news.setDateOfCreated(LocalDateTime.now());
        news.setDateOfUpdated(LocalDateTime.now());
        news.setTitle(newsDto.getTitle());
        news.setText(newsDto.getText());;
        return newsRepository.save(news);
    }

    @Override
    public List<NewsDto> getAllNews() {
        return newsRepository.findAll()
                .stream()
                .map(NewsDto::fromNews)
                .collect(Collectors.toList());
    }

    @Override
    public News updateNew(News NewsFromDb, News news) {
        BeanUtils.copyProperties(news, NewsFromDb, "id","dateOfCreated","idAuthor");
        NewsFromDb.setDateOfUpdated(LocalDateTime.now());
        return newsRepository.save(NewsFromDb);
    }

    @Override
    public void deleteNew(News news) {
        newsRepository.deleteById(news.getId());
    }

    @Override
    public News findById(Long id) {
        return newsRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}
