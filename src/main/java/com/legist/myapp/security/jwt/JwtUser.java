package com.legist.myapp.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;

public class JwtUser implements UserDetails {

    private final String id;
    private final String username;
    private final String firstName;
    private final String lastName;
    private final String userPic;
    private final String password;
    private final String email;
    private final String gender;
    private final String locale;
    private final boolean enabled;
    private final LocalDateTime lastPasswordResetDate;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtUser(String id,
                   String username,
                   String firstName,
                   String lastName,
                   String userPic,
                   String password,
                   String email,
                   String gender,
                   String locale,
                   boolean enabled,
                   LocalDateTime lastPasswordResetDate,
                   Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userPic = userPic;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.locale = locale;
        this.enabled = enabled;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.authorities = authorities;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserPic() {
        return userPic;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getLocale() {
        return locale;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @JsonIgnore
    public LocalDateTime getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
