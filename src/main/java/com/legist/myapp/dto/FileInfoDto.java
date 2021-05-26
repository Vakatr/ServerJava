package com.legist.myapp.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.time.LocalDate;

@JsonAutoDetect
public class FileInfoDto {
    private Long id;
    private String name;
    private Long size;
    private String key;
    private LocalDate uploadDate;

    public FileInfoDto() {
    }

    public FileInfoDto(Long id, String name, Long size, String key, LocalDate uploadDate) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.key = key;
        this.uploadDate = uploadDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public LocalDate getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDate uploadDate) {
        this.uploadDate = uploadDate;
    }
}
