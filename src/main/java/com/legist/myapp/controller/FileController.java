package com.legist.myapp.controller;

import com.legist.myapp.dto.FileInfoDto;
import com.legist.myapp.model.FileInfo;
import com.legist.myapp.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/file/")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<FileInfoDto> upload(@RequestParam(value = "file") MultipartFile attachment) {
        try {
            var File = fileService.upload(attachment);
            FileInfoDto fileInfoDto = new FileInfoDto();
            fileInfoDto.setId(File.getId());
            fileInfoDto.setSize(File.getSize());
            fileInfoDto.setName(File.getName());
            fileInfoDto.setUploadDate(File.getUploadDate());
            fileInfoDto.setKey(File.getKey());
            return File != null ? new ResponseEntity<>(fileInfoDto, HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> download(@PathVariable("id") Long id) {
        try {
            FileInfo foundFile = fileService.findById(id);
            Resource resource = fileService.download(foundFile.getKey());
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=" + foundFile.getName())
                    .body(resource);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(path = "/{key}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> downloadKey(@PathVariable("key") String key) {
        try {
            FileInfo foundFile = fileService.findByKey(key);
            if (foundFile==null) { return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
            Resource resource = fileService.download(foundFile.getKey());
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=" + foundFile.getName())
                    .body(resource);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

