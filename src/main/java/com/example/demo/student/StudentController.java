package com.example.demo.student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return this.studentService.getAllStudents();
    }

    @GetMapping("{id}")
    public StudentDTO getStudentById(@PathVariable("id") long id) {
        return this.studentService.getStudentById(id);
    }

    @GetMapping("name/{name}")
    public StudentDTO getStudentByName(@PathVariable("name") String name) {
        return this.studentService.getStudentByName(name);
    }

    @PostMapping
    public StudentDTO addStudent(@RequestBody Student student) {
        return this.studentService.createStudent(student);
    }
}
