package com.legist.myapp.dto;

import com.legist.myapp.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GuestDto {
    private String name;
    private String firstName;
    private String lastName;
    private String userPic;
    private String email;
    private String gender;
    private String locale;
    //@JsonIgnore
    private String password;

    public User toUser(){
        User user = new User();
        user.setName(name);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserPic(userPic);
        user.setEmail(email);
        user.setGender(gender);
        user.setLocale(locale);
        user.setPassword(password);
        return user;
    }

    public static GuestDto fromUser(User user) {
        GuestDto guestDto = new GuestDto();
        guestDto.setName(user.getName());
        guestDto.setFirstName(user.getFirstName());
        guestDto.setLastName(user.getLastName());
        guestDto.setUserPic(user.getUserPic());
        guestDto.setEmail(user.getEmail());
        guestDto.setGender(user.getGender());
        guestDto.setLocale(user.getLocale());
        guestDto.setPassword(user.getPassword());
        return guestDto;
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

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
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

    //@JsonIgnore
    public String getPassword() {
        return password;
    }

    //@JsonIgnore
    public void setPassword(String password) {
        this.password = password;
    }

}
