package com.sjxy.springboot.jpa.dao;

import com.sjxy.springboot.jpa.pojo.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDao extends JpaRepository<Task,Integer> {
}
