package com.example.schoolapi.Controller;

import com.example.schoolapi.Api.ApiResponse;
import com.example.schoolapi.Model.Student;
import com.example.schoolapi.Model.Teacher;
import com.example.schoolapi.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teacher/api/v1")
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.status(200).body(teacherService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Teacher teacher){
        teacherService.add(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid Teacher teacher){
        teacherService.update(id,teacher);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        teacherService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));
    }


    @PutMapping("/attend/{id}")
    public ResponseEntity attendStudent(@PathVariable Integer id){
        teacherService.attendStudent(id);
        return ResponseEntity.status(200).body(new ApiResponse("student attended"));
    }

    @GetMapping("/allAttended")
    public ResponseEntity allAttended(){
        return ResponseEntity.status(200).body(teacherService.allAttend());
    }

    @PostMapping("/submitStudentGrade/{id}/{grade}")
    public ResponseEntity submitStudentGrade(@PathVariable Integer id,@PathVariable Double grade){
        teacherService.submitStudentGrade(id,grade);
        return ResponseEntity.status(200).body(new ApiResponse("the grade added"));
    }

    @GetMapping("/avgMarks")
    public ResponseEntity gradeAvg(){
        return ResponseEntity.status(200).body(teacherService.gradeAvg());
    }

    @GetMapping("/higherStudentGrade")
    public ResponseEntity higherStudentGrade(){
        return ResponseEntity.status(200).body(teacherService.higherStudentGrade());
    }

    @GetMapping("/lowerStudentGrade")
    public ResponseEntity lowerStudentGrade(){
        return ResponseEntity.status(200).body(teacherService.lowerStudentGrade());
    }

    @GetMapping("/orderByGrade")
    public ResponseEntity orderByGrade(){
        return ResponseEntity.status(200).body(teacherService.orderByGrade());
    }

    @GetMapping("/findStudentById/{id}")
    public ResponseEntity findStudentById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.findStudentById(id));
    }

    @GetMapping("/findStudentByName/{Fname}/{Lname}")
    public ResponseEntity findStudentById(@PathVariable String Fname,@PathVariable String Lname){
        return ResponseEntity.status(200).body(teacherService.findStudentByName(Fname, Lname));
    }

}
