package com.nocountryproject.Backend.mapper;

import com.nocountryproject.Backend.persistence.entity.Role;
import com.nocountryproject.Backend.persistence.entity.User;
import com.nocountryproject.Backend.service.dto.UserInDTO;
import org.springframework.stereotype.Component;

@Component
public class UserInDTOToUser implements IMapper<UserInDTO, User>{

    @Override
    public User map(UserInDTO in){

        User user = new User();

        user.setRole(Role.USER);
        user.setName(in.getName());
        user.setLastname(in.getLastname());
        user.setDni(in.getDni());
        user.setEmail(in.getEmail());
        user.setAddress(in.getAddress());
        user.setTelephone(in.getTelephone());
        user.setPassword(in.getPassword());

        return user;
    }
}
