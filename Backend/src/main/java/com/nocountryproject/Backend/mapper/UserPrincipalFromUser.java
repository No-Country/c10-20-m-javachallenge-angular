package com.nocountryproject.Backend.mapper;

import com.nocountryproject.Backend.persistence.entity.User;
import com.nocountryproject.Backend.security.model.UserPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;


import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@Component
public class UserPrincipalFromUser implements IMapper<User, UserPrincipal>{

    @Override
    public UserPrincipal map(User in) {

        List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(in.getRole().name()));
        return UserPrincipal.builder()
                .id(in.getId())
                .email(in.getEmail())
                .password(in.getPassword())
                .authorities(authorities)
                .build();
    }
}
