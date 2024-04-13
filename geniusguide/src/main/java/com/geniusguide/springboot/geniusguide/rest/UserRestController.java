package com.geniusguide.springboot.geniusguide.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.geniusguide.springboot.geniusguide.entity.User;
import com.geniusguide.springboot.geniusguide.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {

	private UserService userservice;
	
	@Autowired
	public UserRestController(UserService theuserservice) {
		userservice = theuserservice;
	}
	
	@GetMapping("/users")
	public List<User> findall(){
		return userservice.findAll();
	}
	
	
	@GetMapping("/users/{userid}")
	public User findbyid(@PathVariable int userid) {
		
		User theuser = userservice.findById(userid);
		
		if(theuser == null) {
			throw new RuntimeException("Employee id is not found "+ userid);
		}
		
		return theuser;
	}
	
	
	@PostMapping("/users")
	public User addUser(@RequestBody User theuser) {
		
		theuser.setId(0);
		
		User dbuser = userservice.save(theuser);
		
		return dbuser;
		
	}
	
	
	@PutMapping("/users")
	public User updateuser(@RequestBody User theuser) {
		
		User dbuser = userservice.save(theuser);
		
		return dbuser;
	}
	
	
	@DeleteMapping("/users/{userid}")
	public String deleteUser(@PathVariable int userid  ) {
		
		User theuser = userservice.findById(userid);
		
		if(theuser == null) {
			throw new RuntimeException("Userid is not found "+ userid);
		}
		
		userservice.delete(userid);
		
		return "Deleted User Id "+userid+"";
	}
	
	
	
	
	
	
}
