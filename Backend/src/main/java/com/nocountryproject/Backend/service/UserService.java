package com.nocountryproject.Backend.service;

import com.nocountryproject.Backend.exceptions.MyException;
import com.nocountryproject.Backend.mapper.UserInDTOToUser;
import com.nocountryproject.Backend.persistence.entity.User;
import com.nocountryproject.Backend.persistence.repository.UserRepository;
import com.nocountryproject.Backend.service.dto.UserInDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserInDTOToUser mapper;


    public UserService(UserRepository userRepository, UserInDTOToUser mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Transactional
    public User createUser(UserInDTO userInDTO){
        User user = mapper.map(userInDTO);
        return this.userRepository.save(user);
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Transactional
    public void updateUser(Long id) throws MyException {
        Optional<User> optionalUser = this.userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new MyException("El usuario no existe");
        }/* else {
            this.userRepository.updateUser(id);
        }*/
    }

    @Transactional
    public void deleteUser(Long id) throws MyException{
        Optional <User> optionalUser = this.userRepository.findById(id);
        if (optionalUser.isEmpty()){
            throw new MyException("EL USUARIO NO EXISTE");
        } else {
            this.userRepository.deleteById(id);
        }
    }
}
