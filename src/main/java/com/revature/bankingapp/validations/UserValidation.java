package com.revature.bankingapp.validations;

import com.revature.bankingapp.Exeception.ValidationExeception;
import com.revature.bankingapp.model.User;

public class UserValidation {
	public  void insert(User user) throws ValidationExeception {
		if (user.getName() == null) {
			throw new ValidationExeception("Invalid Name");
		}
		if (user.getEmail() == null) {
			throw new ValidationExeception("Invalid Email");
		}
		if (user.getPassword() == null) {
			throw new ValidationExeception("Invalid Password");
		}
	}
	
	public  void login(String email, String password) throws ValidationExeception {
		
		if (email == null) {
			throw new ValidationExeception("Invalid Email");
		}
		if (password == null) {
			throw new ValidationExeception("Invalid Password");
		}
	}
}


