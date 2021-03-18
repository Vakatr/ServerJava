package com.legist.myapp.dto;

public class AuthenticationRequestDto {
    private String name;
    private String password;

    public AuthenticationRequestDto() {
    }

    public AuthenticationRequestDto(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
