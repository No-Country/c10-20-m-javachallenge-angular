package com.nocountryproject.Backend.service.dto;

import com.nocountryproject.Backend.persistence.entity.Role;
import lombok.Data;

@Data
public class UserInDTO {

    private String name;
    private String lastname;
    private String dni;
    private String email;
    private String address;
    private String telephone;
    private String password;
}
