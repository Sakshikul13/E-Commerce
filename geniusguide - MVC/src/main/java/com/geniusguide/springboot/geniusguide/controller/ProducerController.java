package com.geniusguide.springboot.geniusguide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.geniusguide.springboot.geniusguide.entity.User;
import com.geniusguide.springboot.geniusguide.service.UserService;
@Controller
@RequestMapping("/producer")
public class ProducerController {

	private UserService userservice;
	
	@Autowired
	public ProducerController(UserService theuserservice) {
		userservice = theuserservice;
	}
	
	@GetMapping("/")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/list")
	public String ListCutomers(Model themodel) {
		
		List<User> customers = userservice.findAll();
		
		themodel.addAttribute("customers", customers);
		
		return "producer/listproducer";
	}
	
	
	@GetMapping("/addproducer")
	public String addCustomers(Model model) {
		
		User user = new User();
		
		model.addAttribute("customer", user);
		
		return "producer/addproducerForm";
	}
	
	@PostMapping("/processproducer")
	public String processCustomer(@ModelAttribute("customer")User user) {
		
//		String firstname = request.getParameter("first_name");
//		
//		String lastname = request.getParameter("last_name");
//		
//		String email = request.getParameter("email");
//		
//		String password = request.getParameter("password");
//		
//		User user = new User(firstname, lastname, email, password);
//		
		userservice.save(user);
//		
//		model.addAttribute("customer", user);
		
		return "redirect:/producer/list";
	}
	
	@GetMapping("/updateproducer")
	public String updateCustomer(@RequestParam("customerId") int theid, Model themodel) {
		User user = userservice.findById(theid);
		
		themodel.addAttribute("customer", user);
		
		return "producer/addproducerForm";	
	}
	
	@GetMapping("/deleteproducer")
	public String deleteCustomer(@RequestParam("customerId") int theid, Model themodel) {
		User user = userservice.findById(theid);
		
		if(user == null) {
			throw new RuntimeException("User id is not found"+ theid);
		}
		userservice.delete(theid);
		themodel.addAttribute("customer", user);
		return "redirect:/producer/list";	
	}
	
	
	@GetMapping("/leaders")
	public String showLeaders() {
		return "leaders";
	}
	
}
