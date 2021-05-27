package com.legist.myapp.dto;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.legist.myapp.domain.Requests;
import com.legist.myapp.domain.RequestsSpecialist;

import java.time.LocalDateTime;


@JsonAutoDetect
public class RequestSpecialistDto {
    private Long id;
    private String request_text;
    private String decision;
    private String status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;
    private UserDto userId;
    private String file;

    public RequestsSpecialist toRequest() {
        RequestsSpecialist requestsSpecialist = new RequestsSpecialist();
        requestsSpecialist.setId(id);
        requestsSpecialist.setRequestText(request_text);
        requestsSpecialist.setFile(file);
        requestsSpecialist.setCreated(created);
        requestsSpecialist.setStatus(status);
        requestsSpecialist.setDecision(decision);
        requestsSpecialist.setUserId(userId.toUser());
        return requestsSpecialist;
    }

    public static RequestSpecialistDto fromRequest(RequestsSpecialist requestsSpecialist) {
        RequestSpecialistDto requestSpecialistDto = new RequestSpecialistDto();
        requestSpecialistDto.setId(requestsSpecialist.getId());
        requestSpecialistDto.setCreated(requestsSpecialist.getCreated());
        requestSpecialistDto.setRequest_text(requestsSpecialist.getRequestText());
        requestSpecialistDto.setDecision(requestsSpecialist.getDecision());
        requestSpecialistDto.setStatus(requestsSpecialist.getStatus());
        requestSpecialistDto.setFile(requestsSpecialist.getFile());
        requestSpecialistDto.setUserId(UserDto.fromUser(requestsSpecialist.getUserId()));
        return requestSpecialistDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequest_text() {
        return request_text;
    }

    public void setRequest_text(String request_text) {
        this.request_text = request_text;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public UserDto getUserId() {
        return userId;
    }

    public void setUserId(UserDto userId) {
        this.userId = userId;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
