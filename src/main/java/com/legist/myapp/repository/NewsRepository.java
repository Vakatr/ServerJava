package com.legist.myapp.repository;

import com.legist.myapp.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
    void deleteById(Long id);
}
