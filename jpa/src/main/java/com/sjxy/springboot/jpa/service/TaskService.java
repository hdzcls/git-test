package com.sjxy.springboot.jpa.service;


import com.sjxy.springboot.jpa.dao.TaskDao;
import com.sjxy.springboot.jpa.pojo.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskDao taskDao;


    public List<Task> findAll(){
        return taskDao.findAll();
    }
    public Optional<Task> findById(Integer id){
        return taskDao.findById(id);
    }
    public void deleteById(Integer id){
        taskDao.deleteById(id);
    }
    public void updateTask(Task task){
        taskDao.save(task);
    }
    public void addTask(Task task){
        taskDao.save(task);
    }


}
