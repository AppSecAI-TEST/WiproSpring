package com.demo;

import java.util.List;

import javax.sql.DataSource;

import com.dto.User;

public interface UserDAO {
	void setDatasource(DataSource dataSource);
	void insertUser(User user);
	void insertUser_Template(User user);
	User getUser(int id);
	List<User> listAllUsers();
	void deleteUser(int id);
	void updateUser(int id, int age);
}
