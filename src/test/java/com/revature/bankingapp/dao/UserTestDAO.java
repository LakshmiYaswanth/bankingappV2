package com.revature.bankingapp.dao;

import java.util.List;

import org.junit.Test;

import com.revature.bankingapp.Exeception.DBExeception;
import com.revature.bankingapp.model.User;

public class UserTestDAO {
 UserDAO userDAO = new UserDAO();
@Test
	public  void listUsers() {
		try {
			List<User> list = userDAO.listUser();
			for (User user : list) {
				System.out.println(user);
			}
		} catch (DBExeception e) {
			e.printStackTrace();
		}
	}
	@Test
	public  void login() {
		try {
			String email = "yaswanth@gmail.com";
			String password  ="pass123";
			User user = userDAO.login(email, password);
			System.out.println(user);
		} catch (DBExeception e) {
			e.printStackTrace();
		}
		
	}
@Test
	public  void registerUser() {
		String name = "yaswanth";
		String email = "yaswanth@gmail.com";
		String password = "pass123";
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		try {
			userDAO.insert(user);
		} catch (DBExeception e) {
			e.printStackTrace();
		}
	}
}


