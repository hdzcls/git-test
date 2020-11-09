package com.sjxy.springboot.jpa.service;


import com.sjxy.springboot.jpa.dao.ProjectDao;
import com.sjxy.springboot.jpa.pojo.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectDao projectDao;
    public List<Project> finAll(){
        return projectDao.findAll();
    }
    public void deleteById(Integer id){
        projectDao.deleteById(id);
    }
    public void addProject(Project project){
        projectDao.save(project);

    }
    public Optional<Project> findById(Integer id){
        return projectDao.findById(id);
    }
    public void updateProject(Project project){
        projectDao.save(project);
    }
}
