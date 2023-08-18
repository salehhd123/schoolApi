package com.example.schoolapi.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Student {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "can not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String Fname;

    @NotEmpty(message = "can not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String Lname;

    //the student can not change his attend and grade only access by teacher;


    private Boolean attend=false;


    @Min(value = 0 , message = "can not be less than zero")
    @Column(columnDefinition = "float")
    private Double grade;

}
