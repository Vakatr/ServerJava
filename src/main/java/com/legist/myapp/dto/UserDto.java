package com.legist.myapp.dto;

import com.legist.myapp.domain.Role;
import com.legist.myapp.domain.Status;
import com.legist.myapp.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private String id;
    private String name;
    private String firstName;
    private String lastName;
    private String aboutSelf;
    private String email;
    private String gender;
    private String locale;
    private Status status;
    private LocalDateTime lastVisit;
    private List<String> roles;

    public User toUser(){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAboutSelf(aboutSelf);
        user.setEmail(email);
        user.setGender(gender);
        user.setLocale(locale);
        user.setStatus(status);
        user.setLastVisit(lastVisit);
        user.setRoles(roles.stream().map(Role::new).collect(Collectors.toList()));
        return user;
    }

    public static UserDto fromUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setAboutSelf(user.getAboutSelf());
        userDto.setEmail(user.getEmail());
        userDto.setGender(user.getGender());
        userDto.setLocale(user.getLocale());
        userDto.setStatus(user.getStatus());
        userDto.setLastVisit(user.getLastVisit());
        userDto.setRoles(user.getRoles().stream().map(Role::getName).collect(Collectors.toList()));
        return userDto;
    }

    public UserDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAboutSelf() {
        return aboutSelf;
    }

    public void setAboutSelf(String aboutSelf) {
        this.aboutSelf = aboutSelf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(LocalDateTime lastVisit) {
        this.lastVisit = lastVisit;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
