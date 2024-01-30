package com.learning.security.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;

import com.learning.security.entity.Role;
import com.learning.security.entity.Student;
import com.learning.security.entity.User;
import com.learning.security.service.StudentService;
import com.learning.security.service.UserService;

import lombok.RequiredArgsConstructor;

@Configuration
@Transactional
@RequiredArgsConstructor
public class DataLoader {

    private final UserService userRepository;
    private final StudentService studentRepository;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void bootstrapUserData(ApplicationReadyEvent event) {

        Student[] students = {
                new Student("Ravi", "Kumar", "Computer Science", "India"),
                new Student("Priya", "Sharma", "Information Technology", "India"),
                new Student("Rahul", "Gupta", "Electronics and Communication Engineering", "India"),
                new Student("Neha", "Singh", "Mechanical Engineering", "India"),
                new Student("Aman", "Srivastava", "Civil Engineering", "India"),
                new Student("Aarti", "Verma", "Business Administration", "India"),
                new Student("Ankit", "Jain", "Commerce", "India"),
                new Student("Shivani", "Agarwal", "Arts", "India"),
                new Student("Deepak", "Pandey", "Science", "India"),
                new Student("Ritu", "Mishra", "Law", "India")
        };
        // Save student data to the database
        for (Student student : students) {
            studentRepository.save(student);
        }

        Role user = new Role("USER");
        Role admin = new Role("ADMIN");

        User ajay = new User("user", "8008");
        User vijay = new User("admin", "8008");
        ajay.addRole(user);
        vijay.addRole(admin);

        userRepository.save(ajay);
        userRepository.save(vijay);
    }
}
