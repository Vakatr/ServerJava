package com.legist.myapp.dto;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.legist.myapp.domain.*;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@JsonAutoDetect
public class MessageDto {
    private Long id;
    private String title;
    private String text;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateOfCrash;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updated;
    private String messageStatus;
    private double x;
    private double y;
    private String street1;
    private String street2;
    private String typeOfRoadObj;
    private Set<String> images;
    private Set<String> comments;
    private UserDto author;

    public Message toMessage() {
        Message message = new Message();
        message.setId(id);
        message.setTitle(title);
        message.setText(text);
        message.setDateOfCrash(dateOfCrash);
        message.setCreated(created);
        message.setUpdated(LocalDateTime.now());
        message.setMessageStatus(new MessageStatus(messageStatus));
        message.setX(x);
        message.setY(y);
        message.setStreet1(new Street(street1));
        message.setStreet2(new Street(street2));
        message.setTypeOfRoadObj(new TypeOfRoadObj(typeOfRoadObj));
        message.setImages(images.stream().map(Images::new).collect(Collectors.toSet()));
        message.setComments(comments.stream().map(Comments::new).collect(Collectors.toSet()));
        message.setAuthor(author.toUser());
        return message;
    }

    public static MessageDto fromMessage(Message message) {
        MessageDto messageDto = new MessageDto();
        messageDto.setId(message.getId());
        messageDto.setTitle(message.getTitle());
        messageDto.setText(message.getText());
        messageDto.setDateOfCrash(message.getDateOfCrash());
        messageDto.setCreated(message.getCreated());
        messageDto.setUpdated(message.getUpdated());
        messageDto.setMessageStatus(message.getMessageStatus().getName());
        messageDto.setX(message.getX());
        messageDto.setY(message.getY());
        messageDto.setStreet1(message.getStreet1().getName());
        messageDto.setStreet2(message.getStreet2().getName());
        messageDto.setTypeOfRoadObj(message.getTypeOfRoadObj().getName());
        messageDto.setImages(message.getImages().stream().map(Images::getPath).collect(Collectors.toSet()));
        messageDto.setComments(message.getComments().stream().map(Comments::getText).collect(Collectors.toSet()));
        messageDto.setAuthor(UserDto.fromUser(message.getAuthor()));
        return messageDto;
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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
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

  /*  public CarDto getCar1() {
        return car1;
    }

    public void setCar1(CarDto car1) {
        this.car1 = car1;
    }

    public CarDto getCar2() {
        return car2;
    }

    public void setCar2(CarDto car2) {
        this.car2 = car2;
    }*/

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getTypeOfRoadObj() {
        return typeOfRoadObj;
    }

    public void setTypeOfRoadObj(String typeOfRoadObj) {
        this.typeOfRoadObj = typeOfRoadObj;
    }

    public Set<String> getImages() {
        return images;
    }

    public void setImages(Set<String> images) {
        this.images = images;
    }

    public Set<String> getComments() {
        return comments;
    }

    public void setComments(Set<String> comments) {
        this.comments = comments;
    }

    public UserDto getAuthor() {
        return author;
    }

    public void setAuthor(UserDto author) {
        this.author = author;
    }
}
