package com.example.demo.student;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return (List<Student>) this.studentRepository.findAll();
    }

    public Student getStudentById(long id) {
        Optional<Student> optional = this.studentRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    public Student getStudentByName(String name) {
        Optional<Student> optional = this.studentRepository.findByName(name);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    public Student createStudent(Student student) {
        return this.studentRepository.save(student);
    }
}
