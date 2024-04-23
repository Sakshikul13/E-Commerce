package com.geniusguide.springboot.geniusguide.service;

import java.util.List;

import com.geniusguide.springboot.geniusguide.entity.User;

public interface UserService {

	public List<User> findAll();
	
	User findById(int id);
	
	User save(User theuser);
	
	void delete(int id);
}
