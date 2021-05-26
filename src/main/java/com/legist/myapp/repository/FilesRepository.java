package com.legist.myapp.repository;

import com.legist.myapp.domain.Requests;
import com.legist.myapp.model.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilesRepository extends JpaRepository<FileInfo, Long> {
    @Query("select f from FileInfo f where f.key =?1")
    FileInfo findKey(String key);
}
