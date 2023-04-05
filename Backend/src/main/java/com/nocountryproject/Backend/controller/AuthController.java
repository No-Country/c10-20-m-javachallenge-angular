package com.nocountryproject.Backend.controller;

import com.nocountryproject.Backend.security.jwt.JWTResponse;
import com.nocountryproject.Backend.service.AuthService;
import com.nocountryproject.Backend.service.dto.LoginUserDTO;
import com.nocountryproject.Backend.service.dto.UserInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Objects;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    private final AuthService authService;


    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/signin")
    public ResponseEntity<JWTResponse> signin (@RequestBody final LoginUserDTO dto){
        return ResponseEntity.ok(authService.signin(dto));
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<?> signup(@RequestBody final UserInDTO dto){
        if(Objects.isNull(authService.signup(dto))){
            return ResponseEntity.badRequest().body("Email ya registrado");
        }
        return ResponseEntity.ok("Cuenta creada exitosamente");
    }
}
