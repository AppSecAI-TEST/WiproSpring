package com.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.Person;
import com.demo.exceptions.CommitException;
import com.demo.exceptions.RollbackException;

public class PersonDaoImpl {
 
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(Person person){
    	
        em.persist(person);
//        person.setName(person.getName()+" "+person.getSurname());
//        person.setSurname("");
//        em.persist(person);
        
//        saveAnother(person);

        
        
//        throw new RollbackException();
        // Step 2 Message
//        throw new CommitException();   
        // Setup 3 Debit
        // Setup 4 Accounting
    }
    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public void saveAnother(Person person) {
    	
    	Person anotherPerson = new Person();
    	anotherPerson.setName(person.getName());
    	anotherPerson.setSurname(person.getSurname());
    	
        em.persist(anotherPerson);   
//        throw new RollbackException();
        // Step 2 Message
//        throw new CommitException();   
        // Setup 3 Debit
        // Setup 4 Accounting
  
    }
     
    public List<Person>getAll() {
        return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }
}
