package com.revature.bankingapp.model;

public class Account {
	Integer id ;
	User user ;
	Integer balance ;
	@Override
	public String toString() {
		return "Manager [id=" + id + ", user=" + user + ", balance=" + balance + "]";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
}
