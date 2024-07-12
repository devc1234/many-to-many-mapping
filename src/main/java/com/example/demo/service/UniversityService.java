package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repositories.CourseRepository;
import com.example.demo.repositories.StudentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UniversityService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void enrollStudentInCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));

        student.getCourses().add(course);
        course.getClass().getComponentType();

        studentRepository.save(student);
        courseRepository.save(course);
    }
}
