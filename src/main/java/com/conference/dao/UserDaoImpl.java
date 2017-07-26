package com.conference.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import com.conference.entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	
	@PersistenceContext
	private EntityManager emf;

	@Override
	public User getUser(String login) {
		// TODO Auto-generated method stub
		if (!login.isEmpty()) 
		return (User) emf.createQuery("select c from User c where c.login= :login").setParameter("login", login).getSingleResult();	
		else
		return null;
	}

	@Override
	public List<User> findAllUsers() {
			
		List<User> users = (List<User>) emf.createQuery("select c from User c").getResultList();	
		
		// No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
		// Uncomment below lines for eagerly fetching of userProfiles if you want.
		/*
		for(User user : users){
			Hibernate.initialize(user.getUserProfiles());
		}*/
		return users;
	}

	@Override
	public void save(User user) {
		emf.persist(user);
		
	}

	@Override
	public void deleteUser(String login) {
		emf.createQuery("delete c from User c where c.login= :login").setParameter("login", login);
		
	}

}
