package com.fooddeliveryapp.dao;

import java.util.List;

import com.fooddeliveryapp.model.User;

public interface UserDao {
	void addUser(User user);
	User getUser(int userid);
	void updateUser(User user);
	void deleteUser(int userId);
	List<User> getAllUsers();
}
