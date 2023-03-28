package com.nocountryproject.Backend.persistence.service;

import com.nocountryproject.Backend.persistence.entity.Role;
import com.nocountryproject.Backend.persistence.entity.User;
import com.nocountryproject.Backend.persistence.repository.UserRepository;
import com.nocountryproyect.Backend.exceptions.MyException;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Transactional
    public void registerUser(String name, String lastname, Long dni, String email, String address, String telephone, String password) throws MyException{
        
        User user = new User();
       
        user.setName(name);
        user.setLastname(lastname);
        user.setDni(dni);
        user.setEmail(email);
        user.setAddress(address);
        user.setTelephone(telephone);
        user.setPassword(password);
        user.setRole(Role.USER);
        
        userRepository.save(user);
    }
    
    public List<User> userList(){
        
        List<User> users = new ArrayList();
        users = userRepository.findAll();
        
        return users;
    }

    @Transactional
    public void editUser(String name, String lastname, Long dni, String email, String address, String telephone, String password) throws MyException{
        
        Optional<User> answer = userRepository.findById(dni);
        
        if (answer.isPresent()) {
            User user = new User();
            
            user.setName(name);
            user.setLastname(lastname);
            user.setDni(dni);
            user.setEmail(email);
            user.setTelephone(telephone);
            user.setPassword(password);
            
            userRepository.save(user);
        }
    }
    
    
}
