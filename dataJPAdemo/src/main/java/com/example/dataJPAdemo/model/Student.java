package com.example.dataJPAdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    private Integer rno;

    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "Gender cannot be blank")
    private String gender;
    @NotBlank(message = "Tech cannot be blank")
    private String tech;

    private String Email;
    private String Password;
}
