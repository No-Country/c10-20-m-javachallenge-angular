package com.nocountryproject.Backend.persistence.repository;

import com.nocountryproject.Backend.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
