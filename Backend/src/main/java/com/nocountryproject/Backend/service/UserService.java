package com.nocountryproject.Backend.service;

import com.nocountryproject.Backend.exceptions.UserException;
import com.nocountryproject.Backend.mapper.UserInDTOToUser;
import com.nocountryproject.Backend.mapper.UserPrincipalFromUser;
import com.nocountryproject.Backend.persistence.entity.User;
import com.nocountryproject.Backend.persistence.repository.UserRepository;
import com.nocountryproject.Backend.service.dto.UserInDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final UserInDTOToUser mapper;

    private final UserPrincipalFromUser principalFromUser;

    @Autowired
    public UserService(UserRepository userRepository, UserInDTOToUser mapper, UserPrincipalFromUser principalFromUser) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.principalFromUser = principalFromUser;
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
    public User updateUser(UserInDTO userInDTO, Long id) {
        Optional<User> optionalUser = this.userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new UserException("USER NOT FOUND");
        } else {
            User user = optionalUser.get();

            user.setName(userInDTO.getName());
            user.setLastname(userInDTO.getLastname());
            user.setDni(userInDTO.getDni());
            user.setEmail(userInDTO.getEmail());
            user.setTelephone(userInDTO.getTelephone());
            user.setAddress(userInDTO.getAddress());

            //user.setPassword(userInDTO.getPassword());

            return this.userRepository.save(user);
        }
    }

    @Transactional
    public void deleteUser(Long id) {
        Optional <User> optionalUser = this.userRepository.findById(id);
        if (optionalUser.isEmpty()){
            throw new UserException("USER NOT FOUND");
        } else {
            this.userRepository.deleteById(id);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow( () -> new UserException("USER NOT FOUND"));
        return principalFromUser.map(user);
    }
}
