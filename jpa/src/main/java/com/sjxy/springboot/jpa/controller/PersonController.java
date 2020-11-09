package com.sjxy.springboot.jpa.controller;


import com.sjxy.springboot.jpa.pojo.Person;
import com.sjxy.springboot.jpa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;
//    @Autowired
//    private TaskService taskService;
//    @Autowired
//    private PersonAndProjectService personAndProjectService;
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Person> findAll(){
        return personService.findAll();
    }
    @RequestMapping("/hello")
    public String hello(){
        return "personPage";
    }
    @GetMapping("/delete")
    @ResponseBody
    public boolean deleteById(Integer id){
        System.out.println(id);
       // taskService.deleteByPrincipalId(id);
       // personAndProjectService.deleteByPersonId(id);
        personService.deleteById(id);

        return true;
    }
    @GetMapping("/findById")
    @ResponseBody
    public Optional<Person> findById(Integer id){
        return personService.findById(id);
    }
    @PostMapping("/update")
    public String update(Person person){
        personService.update(person);
        return "redirect:/hello";

    }
    @PostMapping("/add")
    public String addPerson(Person person){
        personService.addPerson(person);
        return "redirect:/hello";
    }
}
