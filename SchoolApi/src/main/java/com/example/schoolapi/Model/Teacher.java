package com.example.schoolapi.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Teacher {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "can not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String Fname;

    @NotEmpty(message = "can not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String Lname;

}
