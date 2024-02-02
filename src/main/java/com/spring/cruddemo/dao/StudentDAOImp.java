package com.spring.cruddemo.dao;

import com.spring.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


// supports component scanning and translate JDBC exceptions
@Repository
public class StudentDAOImp implements StudentDAO{

//    define field for entity manager
    private EntityManager entityManager;

//    inject entity manager using constructor injection

    @Autowired
    public StudentDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //    implement save method
    @Override
    @Transactional  // from the spring framework
    public void save(Student theStudent) {
        entityManager.persist((theStudent)); // this will save the student to the database
    }
}
