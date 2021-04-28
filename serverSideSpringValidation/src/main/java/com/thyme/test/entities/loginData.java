package com.thyme.test.entities;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class loginData {
	
	@NotBlank(message="User name can not be empty!!")
	@Size(min=3,max=12,message="User name must be between 3 to 12 characters")
	private String userName;
	
	
	private String email;
	public loginData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "loginData [userName=" + userName + ", email=" + email + "]";
	}
	public loginData(
			@NotBlank(message = "User name can not be empty!!") @Size(min = 3, max = 12, message = "User name must be between 3 to 12 characters") String userName,
			String email) {
		super();
		this.userName = userName;
		this.email = email;
	}
	
	
}
