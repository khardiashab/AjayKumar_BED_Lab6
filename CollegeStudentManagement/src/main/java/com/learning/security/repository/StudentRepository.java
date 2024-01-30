package com.learning.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.security.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    
}
