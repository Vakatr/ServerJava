package com.legist.myapp.service.impl;

import com.legist.myapp.model.FileInfo;
import com.legist.myapp.repository.FilesRepository;
import com.legist.myapp.service.FileService;
import com.legist.myapp.util.UIDGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.apache.tomcat.jni.Shm.size;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    @Autowired
    private final Environment env;
    private final FilesRepository filesRepository;

    @Transactional(rollbackFor = {IOException.class})
    @Override
    public FileInfo upload(MultipartFile resource) throws IOException {
        String key = UUID.randomUUID().toString();
        FileInfo createdFile = new FileInfo();
        createdFile.setName(resource.getOriginalFilename());
        createdFile.setSize(resource.getSize());
        createdFile.setKey(key);
        createdFile.setUploadDate( LocalDate.now());

        createdFile = filesRepository.save(createdFile);
        uploadlocal(resource.getBytes(), key);

        return createdFile;
    }

    public void uploadlocal(byte[] resource, String keyName) throws IOException {
        Path path = Paths.get(env.getProperty("DIRECTORY_PATH.files"), keyName);
        Path file = Files.createFile(path);
        FileOutputStream stream = null;
        try {
            stream = new FileOutputStream(file.toString());
            stream.write(resource);
        } finally {
            stream.close();
        }
    }

    public Resource downloadlocal(String key) throws IOException {
        Path path = Paths.get(env.getProperty("DIRECTORY_PATH.files") + key);
        Resource resource = new UrlResource(path.toUri());
        if (resource.exists() || resource.isReadable()) {
            return resource;
        } else {
            throw new IOException();
        }
    }

    @Override
    public Resource download(String key) throws IOException {
        return downloadlocal(key);
    }

    @Transactional(readOnly = true)
    @Override
    public FileInfo findById(Long fileId) {
        return filesRepository.getOne(fileId);
    }


    @Override
    public FileInfo findByKey(String key) {
        return filesRepository.findKey(key);
    }

}