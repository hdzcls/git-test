package com.sjxy.springboot.jpa.service;




import com.sjxy.springboot.jpa.dao.PersonDao;
import com.sjxy.springboot.jpa.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;


    public List<Person> findAll(){
        System.out.println(personDao.findAll().toString());
        return personDao.findAll();
    }
    public Optional<Person> findById(Integer id){
        return personDao.findById(id);

    }

    public void deleteById(Integer id){

        personDao.deleteById(id);
    }
    public void update(Person person){

        personDao.save(person);
    }
    public void addPerson(Person person){
        personDao.save(person);
    }
}
