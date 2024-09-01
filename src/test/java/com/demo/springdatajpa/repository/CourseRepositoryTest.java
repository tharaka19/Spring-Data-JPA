package com.demo.springdatajpa.repository;

import com.demo.springdatajpa.entity.Course;
import com.demo.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courseList = courseRepository.findAll();

        System.out.println("course list = " + courseList);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Malsha")
                .lastName("Kamal")
                .build();

        Course course = Course.builder()
                .title("Phython")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }
}