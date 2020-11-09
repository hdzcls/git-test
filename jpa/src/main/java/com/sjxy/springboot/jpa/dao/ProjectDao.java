package com.sjxy.springboot.jpa.dao;

import com.sjxy.springboot.jpa.pojo.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDao extends JpaRepository<Project,Integer> {
}
