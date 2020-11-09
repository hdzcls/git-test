package com.sjxy.springboot.jpa.pojo;

import javax.persistence.*;

@Entity(name = "task")

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private String starTime;
    @Column
    private String endTime;
    @OneToOne(targetEntity = Person.class)
    @JoinColumn(name = "personId",referencedColumnName = "id")
    private Person person;
    @ManyToOne(targetEntity = Project.class)
    @JoinColumn(name = "projectId",referencedColumnName = "id")
    private Project project;

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", starTime='" + starTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", person=" + person +
                ", project=" + project +
                '}';
    }

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



    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
