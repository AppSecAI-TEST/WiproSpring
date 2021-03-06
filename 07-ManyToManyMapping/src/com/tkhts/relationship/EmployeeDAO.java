package com.tkhts.relationship;

import java.util.ArrayList;
import java.util.Collection;

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
		Employee shyam = new Employee();
		ram.setName("Shyam");
		ram.setSal(543543);
		Collection<Employee> empList = new ArrayList<Employee>();
		empList.add(ram);
		empList.add(shyam);
		Collection<Dept> deptList = new ArrayList<Dept>();
		Dept dept = new Dept();
		dept.setDeptName("IT");
		dept.setEmp(empList);
		deptList.add(dept);
		Dept dept2 = new Dept();
		dept2.setDeptName("Training");
		dept2.setEmp(empList);
		deptList.add(dept2);
		ram.setDept(deptList);
		shyam.setDept(deptList);
		
		em.persist(ram);
		em.persist(shyam);
		em.persist(dept);
		em.persist(dept2);
		
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
