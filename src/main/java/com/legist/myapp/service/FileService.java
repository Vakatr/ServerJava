package com.legist.myapp.service;

import com.legist.myapp.model.FileInfo;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    FileInfo upload(MultipartFile resource) throws IOException;
    Resource download(String key) throws IOException;
    FileInfo findByKey(String key);
    FileInfo findById(Long fileId);
}
