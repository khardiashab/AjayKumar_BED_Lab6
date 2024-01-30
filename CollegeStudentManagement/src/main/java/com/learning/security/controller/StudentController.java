package com.learning.security.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.learning.security.entity.Student;
import com.learning.security.service.StudentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/list")
    public ModelAndView showList() {
        ModelAndView model = new ModelAndView();
        model.addObject("Students", studentService.findAll());
        model.setViewName("list-student");
        return model;
    }

    @GetMapping("/showFormForUpdate")
    public ModelAndView showFormForUpdate(@RequestParam int studentId) {
        ModelAndView model = new ModelAndView();
        model.addObject("Student", studentService.findById(studentId));
        model.setViewName("student-form");
        return model;
    }

    @GetMapping("/showFormForAdd")
    public ModelAndView showFormForAdd() {
        ModelAndView model = new ModelAndView();
        model.addObject("Student", new Student());
        model.setViewName("student-form");
        return model;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Student student) {
        studentService.save(student);
        return "redirect:/student/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int studentId) {
        studentService.deleteById(studentId);
        return "redirect:/student/list";
    }

    @GetMapping("/403")
    public ModelAndView accessDeniedPage(Principal user) {
        ModelAndView model = new ModelAndView();
        if (user != null) {
            model.addObject("msg", "Hi! " + user.getName() + " you don't have access this page!");
        } else {
            model.addObject("msg", "You are not a valid user.");
        }
        model.setViewName("403");
        return model;
    }

}
