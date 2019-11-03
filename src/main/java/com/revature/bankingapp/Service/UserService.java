package com.revature.bankingapp.Service;

import java.util.ArrayList;
import java.util.List;

import com.revature.bankingapp.Exeception.DBExeception;
import com.revature.bankingapp.Exeception.ServiceExeception;
import com.revature.bankingapp.Exeception.ValidationExeception;
import com.revature.bankingapp.dao.UserDAO;
import com.revature.bankingapp.model.User;
import com.revature.bankingapp.validations.UserValidation;


public class UserService {
	
	private UserDAO userdao;
	private UserValidation validation;
	public int register(User user) throws ServiceExeception {
		int row =0;
		try {
			validation.insert(user);
			row=userdao.insert(user);
		}catch (ValidationExeception e) {
			throw new ServiceExeception(e.getMessage(), e);
		} catch (DBExeception e) {
			throw new ServiceExeception(e.getMessage(), e);
		}
		return row;
}
	public User userlogin(String email,String password) throws ServiceExeception{
		User user =null;
		try {
			validation.login(email, password);
			user=userdao.login(email, password);
		}catch (ValidationExeception e) {
			throw new ServiceExeception(e.getMessage(), e);
		} catch (DBExeception e) {
			throw new ServiceExeception(e.getMessage(), e);
		}return user;
	}
	public List<User> list() throws ServiceExeception{
		List<User> user=null;
		try {
			user=userdao.listUser();	
		}catch (DBExeception e) {
			throw new ServiceExeception(e.getMessage(), e);
		}return  user;
	}
}
