package com.learning.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.security.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    public Optional<User> findByUsername(String username);
}
