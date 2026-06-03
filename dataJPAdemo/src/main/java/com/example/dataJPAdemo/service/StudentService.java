package com.example.dataJPAdemo.service;

import com.example.dataJPAdemo.DTO.StudentDTO;
import com.example.dataJPAdemo.Repository.StudentRepository;
import com.example.dataJPAdemo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository r;

    public List<Student> getAllStudents() {
        return r.findAll();
    }
    public void addStudent(Student s) {
        r.save(s);
    }
    public Student getStudentByRollNo(int rno) {
        return r.findById(rno).orElse(null);

    }
    public void deleteStudent(int rno) {
        r.deleteById(rno);
    }
    public void updateStudent(int rno, Student std) {
           Student s = r.findById(rno).orElse(null);
           if(s!=null){
               s.setName(std.getName());
               s.setTech(std.getTech());
               r.save(s);
        }
    }
    public void deleteAllStudents() {
        r.deleteAll();
    }

    public List<Student> getStudentByGenderAndTech(String gender, String tech) {
        return r.findByGenderAndTech(gender, tech);
    }

    public List<Student> getStudentByTech(String tech) {
        return r.findByTech(tech);
    }
    public List<Student> getStudentByGenAndTech(String gender, String tech) {
        return r.findByGenderAndTech(gender, tech);
    }
    public List<StudentDTO> getAllStudentsDTO() {

        List<Student> students = r.findAll();

        return students.stream()
                .map(this::convertToDTO)
                .toList();
    }

    private StudentDTO convertToDTO(Student s1) {
        StudentDTO std = new StudentDTO();
        std.setRno(s1.getRno());
        std.setName(s1.getName());
        std.setGender(s1.getGender());
        std.setTech(s1.getTech());
        std.setEmail(s1.getEmail());
        std.setPassword(s1.getPassword());
        return std;
    }

    public StudentDTO getStudentDTO(int rno) {

        Student s1 = r.findById(rno)
                .orElseThrow();

        return convertToDTO(s1);
    }
    public StudentDTO addStudentDTO(StudentDTO std) {
       Student s2 = convertDTOToStudent(std);
       r.save(s2);
       return std;
    }
    public Student convertDTOToStudent(StudentDTO std1){
        Student s2 = new Student();
        s2.setRno(std1.getRno());
        s2.setName(std1.getName());
        s2.setGender(std1.getGender());
        s2.setTech(std1.getTech());
        s2.setEmail(std1.getEmail());
        s2.setPassword(std1.getPassword());
        return s2;
    }
       public Page<Student> getAllStudents(int page , int size){
        return r.findAll(
                PageRequest.of(page, size)
        );
       }
}



