package com.geniusguide.springboot.geniusguide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geniusguide.springboot.geniusguide.dao.UserDAO;
import com.geniusguide.springboot.geniusguide.entity.User;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{

	private UserDAO userdao;
	
	@Autowired
	public UserServiceImpl(UserDAO theuserdao) {
		userdao = theuserdao;
	}
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userdao.findAll();
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userdao.findById(id);
	}

	@Transactional
	@Override
	public User save(User theuser) {
		// TODO Auto-generated method stub
		return userdao.save(theuser);
	}

	@Transactional
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		userdao.delete(id);
	}
}
