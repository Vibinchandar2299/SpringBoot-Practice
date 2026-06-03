package com.example.dataJPAdemo.Repository;
import com.example.dataJPAdemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface StudentRepository extends JpaRepository<Student,Integer>{
    List<Student> findByGenderAndTech(String gender, String tech);

    List<Student> findByTech(String tech);

    @Query(nativeQuery = true, value="SELECT * FROM Student  WHERE gender = :gender AND tech = :tech")
    List<Student> findByGenAndTech(@Param("gender") String gender, @Param("tech") String tech);
}

