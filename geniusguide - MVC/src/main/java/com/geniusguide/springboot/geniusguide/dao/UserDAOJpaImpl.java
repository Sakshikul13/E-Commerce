package com.geniusguide.springboot.geniusguide.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.geniusguide.springboot.geniusguide.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class UserDAOJpaImpl implements UserDAO{
	
	private EntityManager entitymanager;
	
	@Autowired
	public UserDAOJpaImpl(EntityManager theentitymanager) {
		entitymanager = theentitymanager;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		
		TypedQuery<User> thequery = entitymanager.createQuery("from User", User.class);
		
		List<User> users = thequery.getResultList();
		
		return users;
	}

	@Override
	public User findById(int id) {
		
		User dbuser = entitymanager.find(User.class, id);
		
		return dbuser;
	}

	@Override
	public User save(User theuser) {
		// TODO Auto-generated method stub
		User dbuser = entitymanager.merge(theuser);
		return dbuser;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		User dbuser = entitymanager.find(User.class, id);
		
		if(dbuser == null) {
//			throw new RuntimeException("The User id "+id+"Not Found");
		}
		
		entitymanager.remove(dbuser);
	}
}
