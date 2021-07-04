package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.security.JWTToken;
import com.example.demo.security.User;

@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	private JWTToken JWTToken;

	
	@PostMapping("/login")
	public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		
		String token = JWTToken.createBearerToken(username);
		User user = new User();
		user.setUsername(username);
		user.setToken(token);		
		return user;
		
	}

}
