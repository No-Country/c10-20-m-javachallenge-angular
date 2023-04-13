package com.nocountryproject.Backend.controller;

import com.nocountryproject.Backend.exceptions.UserException;
import com.nocountryproject.Backend.persistence.entity.User;
import com.nocountryproject.Backend.service.UserService;
import com.nocountryproject.Backend.service.dto.UserInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody UserInDTO userInDTO){
        return this.userService.createUser(userInDTO);
    }

    @GetMapping
    public List<User> findAll(){
        return this.userService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws UserException {
        this.userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody UserInDTO userInDTO, @PathVariable Long id) throws UserException {
        return this.userService.updateUser(userInDTO, id);
    }

    @GetMapping("/{email}")
    public User findByEmail(@PathVariable String email) {
        return this.userService.findByEmail(email);
    }
}
