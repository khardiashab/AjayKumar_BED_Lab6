package com.learning.security.service;

import java.util.List;

import com.learning.security.entity.Student;

public interface StudentService {

    Student findById(int userId);

    List<Student> findAll();

    void deleteById(int studentId);

    void save(Student student);

}