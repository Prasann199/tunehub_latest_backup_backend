package com.home.tunehub.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.tunehub.entity.User;
import com.home.tunehub.model.LoginData;
import com.home.tunehub.model.UserData;
import com.home.tunehub.repository.UserRepository;
import com.home.tunehub.service.UserService;

import jakarta.servlet.http.HttpSession;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void userRegister(UserData userData) {
		User user=new User();
		user.setId(userData.getId());
		user.setName(userData.getName());
		user.setEmail(userData.getEmail());
		user.setPassword(userData.getPassword());
		user.setGender(userData.getGender());
		user.setAddress(userData.getAddress());
		user.setPremium(userData.getIspremium());
		user.setRole(userData.getRole());
		
		userRepository.save(user);
		
	}

	@Override
	public String validate(LoginData loginData, HttpSession session) {
		String email=loginData.getEmail();
		User user=userRepository.findByEmail(email);

		if(user != null && user.getPassword().equals(loginData.getPassword())) {
			String role = user.getRole();
			session.setAttribute("user", user);
			if(role.equals("admin")) {
				return "adminhome";
			}else {
				boolean userstatus = user.getisPremium();
				if(userstatus==true) {
					return "customer";
				}else {
					return "membership";
				}
			}
		}else {
			
			return "login";
		}
	}

	@Override
	public User getUser(String mail) {
		return userRepository.findByEmail(mail);
		
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);
	}

	

}
