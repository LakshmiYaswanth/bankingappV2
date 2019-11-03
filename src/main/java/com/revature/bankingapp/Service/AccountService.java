package com.revature.bankingapp.Service;

import com.revature.bankingapp.Exeception.DBExeception;
import com.revature.bankingapp.Exeception.ServiceExeception;
import com.revature.bankingapp.Exeception.ValidationExeception;
import com.revature.bankingapp.dao.AccountDAO;
import com.revature.bankingapp.model.Account;
import com.revature.bankingapp.model.User;
import com.revature.bankingapp.validations.AccountValidation;

public class AccountService {
	private AccountDAO accountDAO = new AccountDAO();
	AccountValidation accountvalidation;
	public void addAccount(int userId) throws ServiceExeception {

		User user = new User();
		user.setId(userId);

		Account account = new Account();
		account.setUser(user);
		account.setBalance(0);

		try {
			accountvalidation.CreatingAccount(account);
			accountDAO.insert(account);
		} catch (DBExeception e) {
			e.printStackTrace();
			throw new ServiceExeception(e.getMessage(), e);
		} catch (ValidationExeception e) {
			e.printStackTrace();
			throw new ServiceExeception(e.getMessage(), e);
		}
	}

	public void deposit(int accountId, int amount) throws ServiceExeception {

		try {
			Account findOne = accountDAO.findOne(accountId);
			accountvalidation.validateAccount(findOne);

			accountDAO.deposit(findOne, amount);
		} catch (DBExeception e) {
			e.printStackTrace();
			throw new ServiceExeception(e.getMessage(), e);
		} catch (ValidationExeception e) {
			e.printStackTrace();
			throw new ServiceExeception(e.getMessage(), e);
		}
	}

	public void withdraw(int accountId, int amount) throws ServiceExeception {

		try {
			Account findOne = accountDAO.findOne(accountId);
			accountvalidation.validateAccount(findOne);
			accountDAO.withdraw(findOne, amount);
		} catch (DBExeception e) {
			e.printStackTrace();
			throw new ServiceExeception(e.getMessage(), e);
		} catch (ValidationExeception e) {
			e.printStackTrace();
			throw new ServiceExeception(e.getMessage(), e);
		}
	}

	public void fundTransfer(int sourceAccountId, int destinationAccountId, int amount) throws ServiceExeception {

		try {
			Account sourceAccount = accountDAO.findOne(sourceAccountId);
			Account destinationAccount = accountDAO.findOne(destinationAccountId);

			accountvalidation.validateAccounts(sourceAccount, destinationAccount);
			accountDAO.withdraw(sourceAccount, amount);
			accountDAO.deposit(destinationAccount, amount);
		} catch (DBExeception e) {
			e.printStackTrace();
			throw new ServiceExeception(e.getMessage(), e);
		} catch (ValidationExeception e) {
			e.printStackTrace();
			throw new ServiceExeception(e.getMessage(), e);
		}
	}
}

