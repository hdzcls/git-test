package com.sjxy.springboot.jpa.controller;


import com.sjxy.springboot.jpa.dao.PersonDao;
import com.sjxy.springboot.jpa.dao.ProjectDao;
import com.sjxy.springboot.jpa.pojo.Person;
import com.sjxy.springboot.jpa.pojo.Project;
import com.sjxy.springboot.jpa.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class ProjectController {
    @Autowired
    PersonDao personDao;
    @Autowired
    ProjectDao projectDao;
//    @Autowired
//    private PersonAndProjectService personAndProjectService;
    @Autowired
    private ProjectService projectService;
//    @Autowired
//    private TaskService taskService;
    @GetMapping("/")
    public String index(){
    return "indexPage";
}
    @GetMapping("/project")
    public String hello(){
        return "projectPage";
    }
    @GetMapping("/findProject")
    @ResponseBody
    public List<Project> findAll(){
        System.out.println(projectService.finAll().toString());
        return projectService.finAll();
    }
    //查找成员
//    @GetMapping("/findPerson")
//    @ResponseBody
//    public List<Person> findByProjectId(Integer id){
//
//        return personAndProjectService.findByProjectId(id);
//    }
    @GetMapping("/deleteProject")
    @ResponseBody
    public boolean delete(Integer id){
//        taskService.deleteByProjectId(id);
//        personAndProjectService.deleteByProjectId(id);
        projectService.deleteById(id);
        return true;

    }
    @PostMapping("/addProject")
    public String addProject(Project project){
        projectService.addProject(project);
        return "redirect:/project";

    }
    @GetMapping("/deleteByPP")
    @ResponseBody
    public boolean deleteByPP(Integer personId){
        System.out.println(personId);
        Person person=personDao.getOne(personId);
        personDao.deleteById(personId);
        Person person1=new Person();

        person1.setName(person.getName());
        person1.setAge(person.getAge());
        person1.setEducation(person.getEducation());
        person1.setSchool(person.getSchool());
        person1.setGradTime(person.getGradTime());
        personDao.save(person1);
        return true;
    }
    @GetMapping("/addNumber")
    @ResponseBody
    public Boolean add(Integer personId,Integer projectId){

        System.out.println(personId);
        System.out.println(projectId);
        Person person = personDao.getOne(personId);
        Project project = projectDao.getOne(projectId);
        project.getPersons().add(person);

        projectDao.save(project);

        return true;


    }
    @GetMapping("/findPById")
    @ResponseBody
    public Optional<Project> findById(Integer id){

        return projectService.findById(id);
    }
    @PostMapping("/updateProject")
    public String updateProject(Project project){
        projectService.updateProject(project);
        return "redirect:/project";
    }
}
