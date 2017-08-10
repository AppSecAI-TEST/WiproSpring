package com.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dto.User;

public class UserRowMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setAge(rs.getInt("age"));
		user.setUser_login(rs.getString("user_login"));
		user.setUser_pass(rs.getString("user_pass"));
		
		return user;
	}

}
