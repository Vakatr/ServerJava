package com.legist.myapp.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class PasswordChangeDto {
    private String password;
    private String confirmedPassword;

    public PasswordChangeDto() {
    }

    public PasswordChangeDto(String password, String confirmedPassword) {
        this.password = password;
        this.confirmedPassword = confirmedPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }
}
