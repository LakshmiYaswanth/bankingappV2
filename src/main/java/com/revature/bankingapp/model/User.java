package com.revature.bankingapp.model;

public class User {
	Integer id;
	String name;
	String SSN;
	Integer PhoneNo;
	String email;
	String password;
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", SSN=" + SSN + ", PhoneNo=" + PhoneNo + ", email=" + email
				+ ", password=" + password + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public Integer getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(Integer phoneNo) {
		PhoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
