package com.home.tunehub.service;

import com.home.tunehub.entity.User;
import com.home.tunehub.model.LoginData;
import com.home.tunehub.model.UserData;

import jakarta.servlet.http.HttpSession;

public interface UserService {

	void userRegister(UserData userData);

	String validate(LoginData loginData, HttpSession session);

	User getUser(String mail);

	void updateUser(User user);

	

}
