package com.fooddeliveryapp.model;

import java.sql.Date;

public class User {

	private int userId;
	private String name;
	private String username;
	private String password;
	private String email;
	private int phone;
	private String address;
	private String role;
	private Date createdDate;
	private Date billingDate;
	
	public User() {
		
	}

	public User(int userId, String name, String username, String password, String email, int phone, String address,
			String role) {
		super();
		this.userId = userId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "User " + userId + ", " + name + ", " + username + ", " + password
				+ ", " + email + ", " + phone + ", " + address + ", " + role + ", " + createdDate + ", " + billingDate
				+ "";
	}
	
	
}
