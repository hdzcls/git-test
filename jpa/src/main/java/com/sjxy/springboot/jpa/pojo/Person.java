package com.sjxy.springboot.jpa.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private String school;
    @Column
    private String education;
    @Column
    private String gradTime;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "personAndProject",uniqueConstraints ={@UniqueConstraint(columnNames ={"personId","projectId"} )},
            joinColumns = {@JoinColumn(name = "personId",referencedColumnName = "id")},
            inverseJoinColumns={@JoinColumn(name = "projectId",referencedColumnName = "id")})
    @JsonIgnore
    private List<Project> projects=new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getGradTime() {
        return gradTime;
    }

    public void setGradTime(String gradTime) {
        this.gradTime = gradTime;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", school='" + school + '\'' +
                ", education='" + education + '\'' +
                ", gradTime='" + gradTime + '\'' +
                ", projects=" + projects +
                '}';
    }
}
