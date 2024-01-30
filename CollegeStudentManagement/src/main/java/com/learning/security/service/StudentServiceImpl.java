package com.learning.security.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.security.entity.Student;
import com.learning.security.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student findById(int userId) {
        return studentRepository.findById(userId).get();
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteById(int studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }
}