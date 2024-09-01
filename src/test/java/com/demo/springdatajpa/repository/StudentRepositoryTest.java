package com.demo.springdatajpa.repository;

import com.demo.springdatajpa.entity.Guardian;
import com.demo.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("tharaka@gmail.com")
                .firstName("Shehan")
                .lastName("Tharaka")
                //.guardianName("Pasan")
                //.guardianEmail("pasan@gmail.com")
                //.guardianMobile("111111111")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Pasan")
                .email("pasan@gmail.com")
                .mobile("111111111")
                .build();

        Student student = Student.builder()
                .emailId("tharaka@gmail.com")
                .firstName("Shehan")
                .lastName("Tharaka")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> studentList = studentRepository.findAll();

        System.out.println("student list = " + studentList);
    }

    @Test
    public void findByFirstName(){
        List<Student> studentList = studentRepository.findByFirstName("Shehan");

        System.out.println("student list = " + studentList);
    }

    @Test
    public void findByFirstNameContaining(){
        List<Student> studentList = studentRepository.findByFirstNameContaining("She");

        System.out.println("student list = " + studentList);
    }

    @Test
    public void findByFirstNameNotNull(){
        List<Student> studentList = studentRepository.findByFirstNameNotNull();

        System.out.println("student list = " + studentList);
    }

    @Test
    public void findByGuardianName(){
        List<Student> studentList = studentRepository.findByGuardianName("Pasan");

        System.out.println("student list = " + studentList);
    }

    @Test
    public void findByFirstNameAndLastName(){
        Student student = studentRepository.findByFirstNameAndLastName("Shehan", "Tharaka");

        System.out.println("student = " + student);
    }

    @Test
    public void getStudentByEmailId(){
        Student student = studentRepository.getStudentByEmailId("tharaka@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void getStudentFistNameByEmailId(){
        String studentFirstName = studentRepository.getStudentFistNameByEmailId("tharaka@gmail.com");

        System.out.println("student first name= " + studentFirstName);
    }

    @Test
    public void getStudentByEmailIdNative(){
        Student student = studentRepository.getStudentByEmailIdNative("tharaka@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void getStudentByEmailIdNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailIdNativeNamedParam("tharaka@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmailId(){
        studentRepository.updateStudentNameByEmailId("Shehan", "tharaka@gmail.com");
    }

}