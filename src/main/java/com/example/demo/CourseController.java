package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
