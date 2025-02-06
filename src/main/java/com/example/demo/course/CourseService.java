package com.example.demo.course;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // add a course (create)
    public CourseDTO saveCourse(Course course) {
        return new CourseDTO(this.courseRepository.save(course));
    }

    // getting all courses (read)
    public List<CourseDTO> getAllCourses() {
        List<CourseDTO> courseDTOS = new ArrayList<>();
        List<Course> courses = (List<Course>) this.courseRepository.findAll();

        for(Course course : courses) {
            courseDTOS.add(new CourseDTO(course));
        }
        return courseDTOS;
    }

    // get course by id (read)
    public CourseDTO getCourseById(long id) {
        Optional<Course> optionalCourse = this.courseRepository.findById(id);
        if(optionalCourse.isPresent()) {
            return new CourseDTO(optionalCourse.get());
        } else {
            return null;
        }
    }

    // update course
    public Optional<CourseDTO> updateCourse(long id, Course updatedCourse) {
        Optional<Course> existingCourse = this.courseRepository.findById(id);
        if(existingCourse.isPresent()) {
            Course course = existingCourse.get();
            course.setAvgGrade(updatedCourse.getAvgGrade());
            course.setName(updatedCourse.getName());
            course.setDescription(updatedCourse.getDescription());
            return Optional.of(new CourseDTO(this.courseRepository.save(course)));
        } else {
            return Optional.empty();
        }
    }

    // delete course
    public void deleteCourseById(long id) {
        this.courseRepository.deleteById(id);
    }

}
