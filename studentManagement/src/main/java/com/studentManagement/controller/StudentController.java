package com.studentManagement.controller;

import com.studentManagement.entity.Student;
import com.studentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/v2")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
   public ResponseEntity<Student>getStudentById(@PathVariable Long id) {
        Student studentById = studentService.getStudentById(id);
        return ResponseEntity.ok(studentById);
    }

    @PostMapping
    Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student student1 = studentService.updateStudent(id, student);
        return ResponseEntity.ok(student1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }


}
