package com.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.dto.User;

public class JdbcUserTemplate implements UserDAO {
	
	private DataSource datasource;
	public JdbcTemplate jdbcTemplateObject;
	
	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
		this.jdbcTemplateObject = new JdbcTemplate(this.datasource);
	}


	public void insertUser(User user) {
		String sql = "INSERT INTO USERS " + "(AGE, USER_LOGIN, USER_PASS) VALUES (?, ?, ?)";
		Connection conn = null;

		try {
			conn = datasource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getAge());
			ps.setString(2, user.getUser_login());
			ps.setString(3, user.getUser_pass());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("Could not close jdbc connection");
				}
			}
		}

	}
	
	
	public void insertUser_Template(User user) {
		final String SQL = "insert into USERS (USER_LOGIN, USER_PASS, AGE) values (?, ?, ?)";
		jdbcTemplateObject.update(SQL, user.getUser_login(), user.getUser_pass(), user.getAge());
	}

	public void deleteUser(int id) {
		String SQL = "delete from USERS where id = ?";
		int update = jdbcTemplateObject.update(SQL, id);
		System.out.println(update+" Record(s) deleted with ID = " + id );
	}

	public void updateUser(int id, int age) {
		String SQL = "update USERS set age = ? where id = ?";
		int update = jdbcTemplateObject.update(SQL, age, id);
		System.out.println(update+" Record(s) updated with ID = " + id );
	}

	public List<User> listAllUsers() {
		String SQL = "select * from USERS";
		List <User> users = jdbcTemplateObject.query(SQL, new UserRowMapper());
		return users;
	}

	public User getUser(int id){
		String SQL = "select * from USERS where id = ?";
		return jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new UserRowMapper());
	}

}
