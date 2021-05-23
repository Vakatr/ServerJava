package com.legist.myapp.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "news")
public class News {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @NotBlank(message = "Пожалуйста, заполните поле!")
  @Length(max = 256,  message = "Длинное название!")
  private String title;
  @NotBlank(message = "Пожалуйста, заполните поле!")
  @Length(max = 2048,  message = "Большая новость!")
  private String text;
  private LocalDateTime dateOfCreated;
  private LocalDateTime dateOfUpdated;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "id_author")
  private User idAuthor;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }


  public LocalDateTime getDateOfCreated() {
    return dateOfCreated;
  }

  public void setDateOfCreated(LocalDateTime dateOfCreated) {
    this.dateOfCreated = dateOfCreated;
  }


  public LocalDateTime getDateOfUpdated() {
    return dateOfUpdated;
  }

  public void setDateOfUpdated(LocalDateTime dateOfUpdated) {
    this.dateOfUpdated = dateOfUpdated;
  }


  public User getIdAuthor() {
    return idAuthor;
  }

  public void setIdAuthor(User idAuthor) {
    this.idAuthor = idAuthor;
  }

}
