package com.tkhts.relationship;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeDAO {
	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("mypersistanceunit");
     


	public void add()
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Employee ram = new Employee();
		ram.setName("RAM");
		ram.setSal(90909);
		Dept dept = new Dept();
		dept.setDeptName("IT");
		ram.setDept(dept);
		em.persist(ram);
		em.persist(dept);
		transaction.commit();
		em.close();

	}
	public void find(int id)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		//transaction.begin();
		//Employee emp = em.find( Employee.class,id);
		Employee emp = em.getReference(Employee.class, id);
		if(emp!=null){
			System.out.println("Emp Object "+emp);
		}
		else
		{
			System.out.println("Not Found.......");
		}
		//transaction.commit();
		em.close();
	}
	
}
