package com.legist.myapp.dto;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.legist.myapp.domain.Requests;

import java.time.LocalDateTime;


@JsonAutoDetect
public class RequestDto {
    private Long id;
    private String request_text;
    private String decision;
    private Long status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime meeting_time;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;
    private UserDto userId;
    private UserDto userSpecialistId;
    private String file;

    public Requests toRequest() {
        Requests requests = new Requests();
        requests.setId(id);
        requests.setRequesttext(request_text);
        requests.setMeetingtime(meeting_time);
        requests.setCreated(created);
        requests.setStatus(status);
        requests.setDecision(decision);
        requests.setUserId(userId.toUser());
        requests.setUserSpecialistId(userSpecialistId.toUser());
        requests.setFile(file);
        return requests;
    }

    public static RequestDto fromRequest(Requests requests) {
        RequestDto requestDto = new RequestDto();
        requestDto.setId(requests.getId());
        requestDto.setCreated(requests.getCreated());
        requestDto.setRequest_text(requests.getRequesttext());
        requestDto.setDecision(requests.getDecision());
        requestDto.setStatus(requests.getStatus());
        requestDto.setMeeting_time(requests.getMeetingtime());
        requestDto.setUserId(UserDto.fromUser(requests.getUserId()));
        requestDto.setUserSpecialistId(UserDto.fromUser(requests.getUserSpecialistId()));
        requestDto.setFile(requests.getFile());
        return requestDto;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
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

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public LocalDateTime getMeeting_time() {
        return meeting_time;
    }

    public void setMeeting_time(LocalDateTime meeting_time) {
        this.meeting_time = meeting_time;
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

    public UserDto getUserSpecialistId() {
        return userSpecialistId;
    }

    public void setUserSpecialistId(UserDto userSpecialistId) {
        this.userSpecialistId = userSpecialistId;
    }
}
