package com.learning.security.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "student_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Student(String firstName, String lastName, String course, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.country = country;
    }

    private String firstName;
    private String lastName;
    private String course;
    private String country;
}
