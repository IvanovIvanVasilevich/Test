package com.conference.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.conference.dao.UserDao;
import com.conference.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
    public User getUser(String login) { 
        return userDao.getUser(login);
    }

	@Override
	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDao.save(user);
		
	}

	@Override
	public void updateUser(User user) {
		User entity = userDao.getUser(user.getLogin());
		if(entity!=null){
			entity.setPresentation(user.getPresentation());
			if(!user.getPassword().equals(entity.getPassword())){
				entity.setPassword(passwordEncoder.encode(user.getPassword()));
			}
			entity.setName(user.getName());
			entity.setRole(user.getRole());

		}
		
	}

	@Override
	public void deleteUser(String login) {
		userDao.deleteUser(login);
		
	}
	

}
