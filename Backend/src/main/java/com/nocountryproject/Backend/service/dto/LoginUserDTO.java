package com.nocountryproject.Backend.service.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserDTO {
    private String email;
    private String password;
}
