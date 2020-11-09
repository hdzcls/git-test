package com.sjxy.springboot.jpa.dao;

import com.sjxy.springboot.jpa.pojo.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDao extends JpaRepository<Person,Integer> {
}
