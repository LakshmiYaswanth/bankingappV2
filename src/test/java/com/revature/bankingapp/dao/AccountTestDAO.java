package com.revature.bankingapp.dao;

import org.junit.Test;

import com.revature.bankingapp.Exeception.DBExeception;
import com.revature.bankingapp.model.Account;
import com.revature.bankingapp.model.User;
public class AccountTestDAO {
	 AccountDAO accountDAO = new AccountDAO();

	
	@Test
	public void testFundTransfer() {
    	int sourceAccountId = 1;
		int destinationAccountId = 5;
		int amount = 100;
		try {
			Account sourceAccount = accountDAO.findOne(sourceAccountId);
			Account destinationAccount = accountDAO.findOne(destinationAccountId);
			if (sourceAccount != null && destinationAccount !=null) {
				accountDAO.fundTransfer(sourceAccount, destinationAccount, amount);
			}
		} catch (DBExeception e) {
			e.printStackTrace();
		}
	}
     @Test
	public void testDeposit() {
		int accountId = 1;
		int amount = 100;
		try {
			Account account = accountDAO.findOne(accountId);
			if (account != null) {
				accountDAO.deposit(account, amount);
			}
		} catch (DBExeception e) {
			e.printStackTrace();
		}
	}
	
   @Test
	public void testWithdraw() {
		int accountId = 1;
		int amount = 100;
		try {
		Account account = accountDAO.findOne(accountId);
			if (account != null) {
				accountDAO.withdraw(account, amount);
			}
		} catch (DBExeception e) {
			e.printStackTrace();
		}
	}
@Test
	public void testAddAccount() {
		int userId = 1;
		Account account = new Account();

		User user = new User();
		user.setId(userId);
		account.setUser(user);
		account.setBalance(0);

		try {
			accountDAO.insert(account);
		} catch (DBExeception e) {
			e.printStackTrace();
		}
	}

}


