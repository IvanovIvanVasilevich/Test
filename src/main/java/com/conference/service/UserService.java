package com.conference.service;

import java.util.List;

import com.conference.entity.User;

public interface UserService {
	
	User getUser(String login);
	List<User> findAllUsers();	
	void saveUser(User user);	
	void updateUser(User user);
	void deleteUser(String login);

}
