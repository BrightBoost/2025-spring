package com.example.demo.student;

public class StudentDTO {
    private long id;
    private String name;
    private String email;
    private int age;

    private long courseId;

    public StudentDTO() {
    }

    public StudentDTO(Student student) {
        this.id = student.getId();
        if(student.getCourse() != null && student.getCourse().getId() > 0) {
            this.courseId = student.getCourse().getId();
        }
        this.age = student.getAge();
        this.email = student.getEmail();
        this.name = student.getName();
    }

    public StudentDTO(long id, String name, String email, int age, long courseId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.courseId = courseId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }
}
