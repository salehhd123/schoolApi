package com.example.schoolapi.Service;

import com.example.schoolapi.Api.ApiException;
import com.example.schoolapi.Model.Student;
import com.example.schoolapi.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

private final StudentRepository studentRepository;

public List<Student> getAll(){
    return studentRepository.findAll();
}

public void add(Student student){

    student.setFname(student.getFname());
    student.setLname(student.getLname());
    //the student can not change his attend and grade only access by teacher;
    studentRepository.save(student);
}

public void update(Integer id,Student student){
    Student student1= studentRepository.findStudentById(id);
    if (student1==null){
        throw new ApiException("wrong id");
    }
    student1.setFname(student.getFname());
    student1.setLname(student.getLname());
    //the student can not change his attend and grade only access by teacher;
    studentRepository.save(student1);
}

public void delete(Integer id){
    Student student = studentRepository.findStudentById(id);
    if (student==null){
        throw new ApiException("wrong id");
    }
    studentRepository.delete(student);
}


public double myGrade(Integer id){
    Student student = studentRepository.findStudentById(id);
    if (student==null){
        throw new ApiException("wrong id");
    }
    Double grade = student.getGrade();
    return grade;
}

}
