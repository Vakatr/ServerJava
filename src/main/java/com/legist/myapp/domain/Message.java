/*
package com.legist.myapp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "message")
public class Message extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Пожалйста, заполните поле!")
    @Length(max = 256,  message = "Многа букав!")
    private String title;

    @NotBlank(message = "Пожалйста, заполните поле!")
    @Length(max = 2048, message = "Многа букав!")
    private String text;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateOfCrash;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "message_status_id")
    private MessageStatus messageStatus;

    private double x;

    private double y;

    //    @NotBlank(message = "Пожалйста, заполните поле!")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car1_id")
    private Car car1;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car2_id")
    private Car car2;

    //    @NotBlank(message = "Пожалйста, заполните поле!")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "street1_id")
    private Street street1;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "street2_id")
    private Street street2;

    //    @NotBlank(message = "Пожалйста, заполните поле!")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "road_obj_id")
    private TypeOfRoadObj typeOfRoadObj;

    @OneToMany(mappedBy = "message", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Images> images;

    @OneToMany(mappedBy = "message", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Comments> comments;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public LocalDateTime getDateOfCrash() {
        return dateOfCrash;
    }

    public void setDateOfCrash(LocalDateTime dateOfCrash) {
        this.dateOfCrash = dateOfCrash;
    }

    public MessageStatus getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(MessageStatus messageStatus) {
        this.messageStatus = messageStatus;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Car getCar1() {
        return car1;
    }

    public void setCar1(Car car1) {
        this.car1 = car1;
    }

    public Car getCar2() {
        return car2;
    }

    public void setCar2(Car car2) {
        this.car2 = car2;
    }

    public Street getStreet1() {
        return street1;
    }

    public void setStreet1(Street street1) {
        this.street1 = street1;
    }

    public Street getStreet2() {
        return street2;
    }

    public void setStreet2(Street street2) {
        this.street2 = street2;
    }

    public TypeOfRoadObj getTypeOfRoadObj() {
        return typeOfRoadObj;
    }

    public void setTypeOfRoadObj(TypeOfRoadObj typeOfRoadObj) {
        this.typeOfRoadObj = typeOfRoadObj;
    }

    public Set<Images> getImages() {
        return images;
    }

    public void setImages(Set<Images> images) {
        this.images = images;
    }

    public Set<Comments> getComments() {
        return comments;
    }

    public void setComments(Set<Comments> comments) {
        this.comments = comments;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
*/
