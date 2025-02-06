package com.example.demo.course;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("course")
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // getting all the courses
    @GetMapping
    public List<Course> getCourses() {
        return this.courseService.getAllCourses();
    }

    // get a single course by id
    @GetMapping("{id}")
    public Course getCourseById(@PathVariable long id) {
        return this.courseService.getCourseById(id);
    }

    // adding a new course
    @PostMapping
    public Course addNewCourse(@RequestBody Course course) {
        return this.courseService.saveCourse(course);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateCourse(@PathVariable long id, @RequestBody Course course) {
        Optional<Course> optionalCourse = this.courseService.updateCourse(id, course);
        if(optionalCourse.isPresent()) {
            return ResponseEntity.ok(optionalCourse.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public void deleteCourseById(@PathVariable long id) {
        this.courseService.deleteCourseById(id);
    }
}
