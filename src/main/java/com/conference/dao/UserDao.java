package com.conference.dao;

import java.util.List;

import com.conference.entity.User;

public interface UserDao {

	User getUser(String login);
	List<User> findAllUsers();
	void save(User user);
	void deleteUser(String  login);
}
