package com.tap.DAO;

import java.util.List;

import com.tap.Model.User;

public interface UserDAO {
	void addUser(User user);
	User getUser(int userId);
	int UpdateUser(User user);
	
	int deleteUser(int userId);
	List<User> getAllUsers();
}
