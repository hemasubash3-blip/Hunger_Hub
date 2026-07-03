package com.tap.Model;

import java.sql.Timestamp;

public class User {
	private int userId;
	private String username;
	private String password;
	private String Email;
	private String Address;
	private String Role;
	private Timestamp CreateDate;
	private Timestamp LogicDate;
	
	public User(String userName2, String password2, String email2, String address2, String role2, Object object, Object object2) {
	}
	
	



	public User(String username, String password, String email, String address, String role, Timestamp createDate,
			Timestamp logicDate) {
		this.username = username;
		this.password = password;
		this.Email = email;
		this.Address = address;
		this.Role = role;
		this.CreateDate = createDate;
		this.LogicDate = logicDate;
		
	}





	





	public int getUserId() {
		return userId;
	}





	public void setUserId(int userId) {
		this.userId = userId;
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
		return Email;
	}





	public void setEmail(String email) {
		Email = email;
	}





	public String getAddress() {
		return Address;
	}





	public void setAddress(String address) {
		Address = address;
	}





	public String getRole() {
		return Role;
	}





	public void setRole(String role) {
		Role = role;
	}





	public Timestamp getCreateDate() {
		return CreateDate;
	}





	public void setCreateDate(Timestamp createDate) {
		CreateDate = createDate;
	}





	public Timestamp getLogicDate() {
		return LogicDate;
	}





	public void setLogicDate(Timestamp logicDate) {
		LogicDate = logicDate;
	}





	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", Email=" + Email
				+ ", Address=" + Address + ", Role=" + Role + ", CreateDate=" + CreateDate + ", LogicDate=" + LogicDate
				+ "]";
	}





	





	




	
}
	
		
	

	
