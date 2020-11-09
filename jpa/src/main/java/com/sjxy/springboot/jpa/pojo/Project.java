package com.sjxy.springboot.jpa.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String starTime;
    @Column
    private String endTime;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "personAndProject",uniqueConstraints ={@UniqueConstraint(columnNames ={"personId","projectId"} )},
    joinColumns = {@JoinColumn(name = "projectId",referencedColumnName = "id")},
            inverseJoinColumns={@JoinColumn(name = "personId",referencedColumnName = "id")})
    private List<Person> persons=new ArrayList<>();

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

    public String getStarTime() {
        return starTime;
    }

    public void setStarTime(String starTime) {
        this.starTime = starTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
