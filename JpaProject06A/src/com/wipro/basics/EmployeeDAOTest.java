package com.wipro.basics;

import java.util.Date;

public class EmployeeDAOTest {

	public static void main(String[] args) {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		int id = 1000;
		String name[]={"Ram","Shyam","Sohan","Mohan","Tim","Sim","Gim","Bim"};
		for(int i= 0; i<name.length; i++,id++){
			employeeDAO.add(id, name[i], 9000*(i+1), new Date());
		}
		employeeDAO.delete(1002);
		employeeDAO.modify(1000);
		employeeDAO.find(1000);

		employeeDAO.findByName("MIKE");
	}

}
