package com.geniusguide.springboot.geniusguide.dao;

import java.util.List;

import com.geniusguide.springboot.geniusguide.entity.User;

public interface UserDAO {

	List<User> findAll();
	
	User findById(int id);
	
	User save(User theuser);
	
	void delete(int id);
	
}
