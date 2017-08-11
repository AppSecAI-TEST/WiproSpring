package com.wipro.basics;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.xml.namespace.QName;

public class EmployeeDAO {

	EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("mypersistanceunit");

//	persist
	public void add(int id, String name, double salary, Date joiningDate) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Employee ram = new Employee();
		ram.setId(id);
		ram.setName(name);
		ram.setSalary(salary);
		ram.setJoiningDate(joiningDate);

		em.persist(ram);
		transaction.commit();
		em.close();
	}

//	remove
	public void delete(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		Employee emp = em.find(Employee.class, id);
		transaction.begin();
		System.out.println("Emp Going to Delete " + emp);
		em.remove(emp);
		transaction.commit();
		em.close();
		System.out.println("Record Deleted...");
	}

//	merge
	public void modify(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		Employee emp = em.find(Employee.class, id);
		System.out.println("Before Modification Object is " + emp);
		transaction.begin();
		emp.setName("MIKE King");
		em.merge(emp);
		transaction.commit();
		em.close();
		System.out.println("Record Modified...");
	}

//	find
	public void find(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Employee emp = em.find(Employee.class, id);
		if (emp != null) {
			System.out.println("Emp Object " + emp);
		} else {
			System.out.println("Not Found.......");
		}
		transaction.commit();
		em.close();
	}

	// custome query
	public void findByName(String empname) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		Query query = em.createQuery("select e from Employee as e where e.name = ?")
							.setParameter(1,empname);
		List<Employee> list = query.getResultList();
		if (list != null) {
			System.out.println("found : " + list);
			for (Employee emp : list) {
				emp.setName("Mark");
				em.merge(emp);
			}
		} else {
			System.out.println("not found");
		}

		em.close();
	}

}
