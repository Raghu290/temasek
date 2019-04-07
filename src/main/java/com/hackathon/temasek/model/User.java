package com.hackathon.temasek.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User {

	@NotEmpty(message = "UserId must not be blank.")
	@Size(min = 4, max = 15, message = "UserId must be between 4 to 15 Characters.")
	private String userId;

	@NotEmpty(message = "Password must not be blank.")
	@Size(min = 8, max = 15, message = "Password must be between 8 to 15 Characters.")
	private String password;
	@NotEmpty(message = "Name must not be blank.")
	@Size(min = 4, max = 15, message = "Name must be between 4 to 15 Characters.")
	private String name;
	@NotEmpty(message = "City must not be blank.")
	private String city;
	@NotEmpty(message = "Email must not be blank.")
	@Email
	private String email;
	@NotEmpty(message = "PhoneNumber must not be blank.")
	@Size(min = 10, max = 10, message = "PhoneNumber must be 10 digits.")
	private String phone;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}




}
