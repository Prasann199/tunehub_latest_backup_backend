package com.home.tunehub.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	int id;
	String name;
	String email;
	String Password;
	String gender;
	String role;
	String address;
	boolean isPremium;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, String email, String password, String gender, String role, String address,
			boolean isPremium) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		Password = password;
		this.gender = gender;
		this.role = role;
		this.address = address;
		this.isPremium = isPremium;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean getisPremium() {
		return isPremium;
	}
	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", Password=" + Password + ", gender="
				+ gender + ", role=" + role + ", address=" + address + ", isPremium=" + isPremium + "]";
	}
	
	
}
