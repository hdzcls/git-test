package com.sjxy.springboot.jpa.controller;


import com.sjxy.springboot.jpa.bean.TaskVO;
import com.sjxy.springboot.jpa.dao.PersonDao;
import com.sjxy.springboot.jpa.dao.ProjectDao;
import com.sjxy.springboot.jpa.pojo.Person;
import com.sjxy.springboot.jpa.pojo.Project;
import com.sjxy.springboot.jpa.pojo.Task;
import com.sjxy.springboot.jpa.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class TaskController {
    @Autowired
    PersonDao personDao;
    @Autowired
    ProjectDao projectDao;
    @Autowired
    private TaskService taskService;
    @GetMapping("/task")
    public String page(){
        return "taskPage";
    }
    @GetMapping("/findAllTask")
    @ResponseBody
    public List<Task> findAll(){
        return taskService.findAll();
    }
    @GetMapping("/findByTaskId")
    @ResponseBody
    public Optional<Task> findbyId(Integer id){
        return taskService.findById(id);
    }
    @GetMapping("/deleteTask")
    @ResponseBody
    public boolean deleteById(Integer id){
        taskService.deleteById(id);
        return true;
    }
    @PostMapping("/addTask")
    public String add(TaskVO taskVO){
        Task task=new Task();
        task.setName(taskVO.getName());
        task.setStarTime(taskVO.getStarTime());
        task.setEndTime(taskVO.getEndTime());
        Person person=personDao.getOne(taskVO.getPrincipalId());
        task.setPerson(person);
        Project project=projectDao.getOne(taskVO.getProjectId());
        task.setProject(project);

        taskService.addTask(task);
        return "redirect:/task";
    }
    @PostMapping("/updateTask")
    public String update(Task task){
        taskService.updateTask(task);
        return "redirect:/task";
    }

}
