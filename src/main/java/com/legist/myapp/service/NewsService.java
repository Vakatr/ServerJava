package com.legist.myapp.service;

import com.legist.myapp.domain.News;
import com.legist.myapp.dto.NewsDto;

import java.util.List;

public interface NewsService {
    News createNew(NewsDto newsDto);
    List<NewsDto> getAllNews();
    News updateNew(News NewsFromDb, News news);
    void deleteNew(News news);
    News findById(Long id);
}
