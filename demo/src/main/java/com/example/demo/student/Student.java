package com.example.demo.student;

import jakarta.persistence.*;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Student")
@Table(name = "student", uniqueConstraints = {@UniqueConstraint(name = "student_email_unique", columnNames = "email")})
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "student_sequence")

    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;
    @Column(name = "email", nullable = false, columnDefinition = "TEXT", unique = true)
    private String email;
    @Column(name = "dob")
    private LocalDate dob;
    @Column(name = "age", nullable = false)
    private Integer age;

    public Student(){};
    public Student(
     Long id,
     String name,
     String email,
     LocalDate dob,
     Integer age){
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }

    public Student(
            String name,
            String email,
            LocalDate dob,
            Integer age){
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}