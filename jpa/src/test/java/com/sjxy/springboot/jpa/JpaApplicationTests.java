package com.sjxy.springboot.jpa;

import com.sjxy.springboot.jpa.dao.PersonDao;
import com.sjxy.springboot.jpa.dao.ProjectDao;
import com.sjxy.springboot.jpa.pojo.Person;
import com.sjxy.springboot.jpa.pojo.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
class JpaApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("数据库表的初始化");
    }
    @Autowired
    PersonDao personDao;
    @Autowired
    ProjectDao projectDao;
    @Transactional
    @Test
    public void testAddPerson(){
        Project project=projectDao.getOne(6);
        Person person=personDao.getOne(1);

        project.getPersons().remove(person);
        projectDao.save(project);

    } @Test
    public void testAddProject(){
        Person person=new Person();
        person.setName("张三");
        Person person1=new Person();
        person.setName("李四");
        Project project=new Project();
        project.setName("CRM");
        project.getPersons().add(person);
        project.getPersons().add(person1);
        personDao.save(person);
        personDao.save(person1);



        projectDao.save(project);
        System.out.println(personDao.findById(1).toString());

    }
    @Test
    public void findAll(){

    }

}
