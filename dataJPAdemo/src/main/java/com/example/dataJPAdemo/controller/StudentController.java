package com.example.dataJPAdemo.controller;

import com.example.dataJPAdemo.DTO.StudentDTO;
import com.example.dataJPAdemo.model.Student;
import com.example.dataJPAdemo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@RestController
public class StudentController {

    @Autowired
    StudentService s;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return s.getAllStudents();
    }
    @PostMapping("/students")
    public String AddStudent(@Valid @RequestBody Student std) {
        s.addStudent(std);
        return "Student Added Successfully";
    }
    @GetMapping("/students/{rno}")
    public Student getStudentByRollNo(@PathVariable("rno") int rno) {
        return s.getStudentByRollNo(rno);
    }
    @PutMapping("/students/{rno}")
    public String updateStudent(@PathVariable("rno") int rno, @RequestBody Student std) {
        s.updateStudent(rno, std);
        return "Student Updated Successfully";
    }
    @DeleteMapping("/students/{rno}")
    public String deleteStudent(@PathVariable("rno") int rno) {
        s.deleteStudent(rno);
        return "Student Deleted Successfully";
    }
    @DeleteMapping("/students")
    public String deleteAllStudents() {
        s.deleteAllStudents();
        return "All Students Deleted Successfully";
    }
    @GetMapping("/students/custom")
    public List<Student> getStudentByGenderAndTech(@Param("gender") String gender, @Param("tech") String tech) {
        return s.getStudentByGenderAndTech(gender,tech);
    }
    @GetMapping("/students/technology/{tech}")
    public List<Student> getStudentByTech(@Param("tech") String tech) {
        return s.getStudentByTech(tech);
    }
    @PostMapping("/students/filter")
    public List<Student> getStudentByGenAndTech(@Param("gender") String gender, @Param("tech") String tech) {
        return s.getStudentByGenAndTech(gender,tech);
    }
    @GetMapping("/students/dto/{rno}")
    public StudentDTO getStudentDTO(@PathVariable int rno) {
        return s.getStudentDTO(rno);
    }
    @GetMapping("/students/dto")
    public List<StudentDTO> getAllStudentsDTO() {
        return s.getAllStudentsDTO();
    }
    @PostMapping("/students/dto")
    public StudentDTO addStudentDTO(@Valid @RequestBody StudentDTO std) {
        return s.addStudentDTO(std);
    }
    @GetMapping("students")
    public Page<Student> getAllStudents(@Param("page") int page, @Param("size") int size) {
        return s.getAllStudents(page, size);
    }
}



