package com.home.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.home.tunehub.model.LoginData;
import com.home.tunehub.model.UserData;
import com.home.tunehub.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
//@CrossOrigin("*")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public String userRegister(@RequestBody UserData userData ) {
		userService.userRegister(userData);
		return "registered";
	}
	
	@PostMapping("/validate")
	public String validate(@RequestBody LoginData loginData, HttpSession session) {
	    String result = userService.validate(loginData, session);
	    if (result.equals("adminhome") || result.equals("customer") || result.equals("membership")) {
	        session.setAttribute("email", loginData.getEmail());
	    }
	    System.out.println("Session email set to: " + session.getAttribute("email")); // Check session email
	    return result;
	}
	

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
}
