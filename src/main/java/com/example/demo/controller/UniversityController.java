package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.service.UniversityService;

@RestController
@RequestMapping("/university")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return universityService.saveStudent(student);
    }

    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course) {
        return universityService.saveCourse(course);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return universityService.getAllStudents();
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return universityService.getAllCourses();
    }

    @PostMapping("/enroll")
    public void enrollStudentInCourse(@RequestParam Long studentId, @RequestParam Long courseId) {
        universityService.enrollStudentInCourse(studentId, courseId);
    }
}
