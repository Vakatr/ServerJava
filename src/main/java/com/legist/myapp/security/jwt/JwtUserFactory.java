package com.legist.myapp.security.jwt;

import com.legist.myapp.domain.Role;
import com.legist.myapp.domain.Status;
import com.legist.myapp.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {
    public JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getName(),
                user.getFirstName(),
                user.getLastName(),
                user.getAboutSelf(),
                user.getPassword(),
                user.getEmail(),
                user.getGender(),
                user.getLocale(),
                user.getStatus() == Status.ACTIVE,
                user.getUpdated(),
                mapToGrantedAuthorities(user.getRoles())
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
        return userRoles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
