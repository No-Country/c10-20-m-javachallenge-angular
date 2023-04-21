package com.nocountryproject.Backend.service;

import com.nocountryproject.Backend.mapper.UserInDTOToUser;
import com.nocountryproject.Backend.persistence.entity.User;
import com.nocountryproject.Backend.persistence.repository.UserRepository;
import com.nocountryproject.Backend.security.jwt.JWTProvider;
import com.nocountryproject.Backend.security.jwt.JWTResponse;
import com.nocountryproject.Backend.security.model.UserPrincipal;
import com.nocountryproject.Backend.service.dto.LoginUserDTO;
import com.nocountryproject.Backend.service.dto.UserInDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JWTProvider jwtProvider;
    private final UserInDTOToUser mapper;
    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    @Autowired
    public AuthService(AuthenticationManager authenticationManager, JWTProvider jwtProvider, UserInDTOToUser mapper, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public JWTResponse signin (LoginUserDTO dto){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
        return new JWTResponse(jwt, userPrincipal.getUsername(), userPrincipal.getAuthorities());
    }

    public User signup(UserInDTO dto){
        if(userRepository.existsByEmail(dto.getEmail())) return null;
        User user = mapper.map(dto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
