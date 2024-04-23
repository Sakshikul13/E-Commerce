package com.geniusguide.springboot.geniusguide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	
	@GetMapping("/showLoginPage")
	public String getLoginPage() {
		
		return "login/plain-login";
	}
	
	
}
