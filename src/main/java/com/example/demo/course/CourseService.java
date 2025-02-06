package com.example.demo.course;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // add a course (create)
    public Course saveCourse(Course course) {
        return this.courseRepository.save(course);
    }

    // getting all courses (read)
    public List<Course> getAllCourses() {
        return (List<Course>) this.courseRepository.findAll();
    }

    // get course by id (read)
    public Course getCourseById(long id) {
        Optional<Course> optionalCourse = this.courseRepository.findById(id);
        if(optionalCourse.isPresent()) {
            return optionalCourse.get();
        } else {
            return null;
        }
    }

    // update course
    public Optional<Course> updateCourse(long id, Course updatedCourse) {
        Optional<Course> existingCourse = this.courseRepository.findById(id);
        if(existingCourse.isPresent()) {
            Course course = existingCourse.get();
            course.setAvgGrade(updatedCourse.getAvgGrade());
            course.setName(updatedCourse.getName());
            course.setDescription(updatedCourse.getDescription());
            return Optional.of(this.courseRepository.save(course));
        } else {
            return Optional.empty();
        }
    }

    // delete course
    public void deleteCourseById(long id) {
        this.courseRepository.deleteById(id);
    }

}
