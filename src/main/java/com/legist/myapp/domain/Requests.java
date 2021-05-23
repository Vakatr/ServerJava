package com.legist.myapp.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Set;
@Entity
@Table(name = "requests")
public class Requests {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Length(max = 2048,  message = "Длинное обращение!")
  @Column(name = "request_text")
  private String requesttext;
  private String decision;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime created;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  @Column(name = "meeting_time")
  private LocalDateTime meetingtime;
  private long status;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id")
  private User userId;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_specialist_id")
  private User userSpecialistId;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getRequesttext() {
    return requesttext;
  }

  public void setRequesttext(String requesttext) {
    this.requesttext = requesttext;
  }

  public String getDecision() {
    return decision;
  }

  public void setDecision(String decision) {
    this.decision = decision;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public LocalDateTime getMeetingtime() {
    return meetingtime;
  }

  public void setMeetingtime(LocalDateTime meetingtime) {
    this.meetingtime = meetingtime;
  }

  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }

  public User getUserId() {
    return userId;
  }

  public void setUserId(User userId) {
    this.userId = userId;
  }

  public User getUserSpecialistId() {
    return userSpecialistId;
  }

  public void setUserSpecialistId(User userSpecialistId) {
    this.userSpecialistId = userSpecialistId;
  }
}
