package com.revature.bankingapp.validations;

import com.revature.bankingapp.Exeception.DBExeception;
import com.revature.bankingapp.Exeception.ValidationExeception;
import com.revature.bankingapp.dao.AccountDAO;
import com.revature.bankingapp.model.Account;

public class AccountValidation {

	private AccountDAO accountDAO = new AccountDAO();

	public String isAccountExists(int accountId) throws ValidationExeception {

		String isAccount = "closed";
		Account findOne;
		try {
			findOne = accountDAO.findOne(accountId);
			if (findOne != null) {
				isAccount = "opened";
			}
		} catch (DBExeception e) {
			e.printStackTrace();
			throw new ValidationExeception("Unable to find AccountId in db" + accountId);
		}
		return isAccount;

	}

	public  void validateAccounts(Account sourceAccount, Account destinationAccount) throws ValidationExeception {
		if (sourceAccount ==null) {
			throw new ValidationExeception("Source AccountId is invalid " + sourceAccount);
		}
		if (destinationAccount == null) {
			throw new ValidationExeception("Destination AccountId is invalid " + destinationAccount);
		}
	}

	public void validateAccount(Account account) throws ValidationExeception {
		if (account == null) {
			throw new ValidationExeception("Account is invalid " + account);
		}
	}
	
	public void Withdraw(Account account, int amount) throws ValidationExeception {
		if ( account.getBalance() < amount) {
			throw new ValidationExeception("Insufficient balance in account-" + account.getId());
		}
	}
	
	
	public void CreatingAccount(Account account) throws ValidationExeception {
		if ( account.getUser().getId() == null) {
			throw new ValidationExeception("Invalid UserId " + account);
		}
	}
}
