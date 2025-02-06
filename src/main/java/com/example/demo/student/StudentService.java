package com.example.demo.student;

import com.example.demo.course.Course;
import com.example.demo.course.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public List<StudentDTO> getAllStudents() {
        List<StudentDTO> studentDTOS = new ArrayList<>();
        List<Student> students = (List<Student>) this.studentRepository.findAll();
        for(Student student : students) {
            studentDTOS.add(new StudentDTO(student));
        }

        return studentDTOS;
    }

    public StudentDTO getStudentById(long id) {
        Optional<Student> optional = this.studentRepository.findById(id);
        if(optional.isPresent()) {
            return new StudentDTO(optional.get());
        } else {
            return null;
        }
    }

    public StudentDTO getStudentByName(String name) {
        Optional<Student> optional = this.studentRepository.findByName(name);
        if(optional.isPresent()) {
            return new StudentDTO(optional.get());
        } else {
            return null;
        }
    }

//    {
//        "name": "Test",
//        "email": "test",
//        "course": {
//            "id":1
//        }
//    }

    public StudentDTO createStudent(Student student) {
        if(student.getCourse() != null && student.getCourse().getId() > 0) {
            Course course = this.courseRepository.findById(student.getCourse().getId()).orElse(null);
            student.setCourse(course);
        }
        return new StudentDTO(this.studentRepository.save(student));
    }
}
