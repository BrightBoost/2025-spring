package com.example.demo.course;

public class CourseDTO {
    private long id;
    private String name;
    private String description;
    private double avgGrade;


    public CourseDTO(Course course) {
        this.id = course.getId();
        this.avgGrade = course.getAvgGrade();
        this.name = course.getName();
        this.description = course.getDescription();
    }
    public CourseDTO() {
    }

    public CourseDTO(long id, String name, String description, double avgGrade) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.avgGrade = avgGrade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }
}
