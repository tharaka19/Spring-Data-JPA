package com.demo.springdatajpa.repository;

import com.demo.springdatajpa.entity.Course;
import com.demo.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Course courseJava = Course.builder()
                .title("Java")
                .credit(7)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Nimal")
                .lastName("Silva")
                //.courses(List.of(courseDBA, courseJava))
                .build();

        teacherRepository.save(teacher);
    }

    @Test
    public void printAllTeachers(){
        List<Teacher> teacherList = teacherRepository.findAll();

        System.out.println("teacher list = " + teacherList);
    }

}