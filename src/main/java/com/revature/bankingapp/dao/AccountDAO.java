package com.revature.bankingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankingapp.Exeception.DBExeception;
import com.revature.bankingapp.connectionUtill.ConnectionUtil;
import com.revature.bankingapp.model.Account;
import com.revature.bankingapp.model.User;


public class AccountDAO {
	public int insert(Account account) throws DBExeception {
		Connection con = null;
		PreparedStatement pst = null;
		int row=0;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "insert into account(user_id,balance) values ( ?,?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, account.getUser().getId());
			pst.setInt(2, account.getBalance());
			 row = pst.executeUpdate();
		} catch (SQLException e) {
			throw new DBExeception("Unable to insert the account details", e);
		} finally {
			ConnectionUtil.close(con, pst,null);
		}return row;
	}public int  deposit(Account account, int amount) throws DBExeception {
		Connection con = null;
		PreparedStatement pst = null;
		int row =0;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "update account set balance = balance + ? where id = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, amount);
			pst.setInt(2, account.getId());	
			 row = pst.executeUpdate();
		} catch (SQLException e) {
			throw new DBExeception("Unable to perform deposit", e);
		} finally {
			ConnectionUtil.close(con, pst,null);
		} return row;
	}
	
	public int withdraw(Account account, int amount) throws DBExeception {
		Connection con = null;
		PreparedStatement pst = null;
		int rows =0;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "update account set balance = balance - ? where id = ?";	
			pst = con.prepareStatement(sql);
			pst.setInt(1, amount);
			pst.setInt(2, account.getId());		
			
			rows = pst.executeUpdate();
			System.out.println("AccountDAO->withdraw-> rows updated:" + rows);
		} catch (SQLException e) {
			throw new DBExeception("Unable to perform withdraw", e);
		} finally {
			ConnectionUtil.close(con, pst,null);
		} return rows;
	}
	
	public void fundTransfer(Account account1, Account account2, int amount) throws DBExeception {
		withdraw(account1, amount);
		deposit(account2, amount);
	}
	
	public Account getUserAccount(int userId) throws DBExeception {
		Connection con = null;
		PreparedStatement pst = null;
		Account account = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select a.id as account_id,u.id as user_id, a.balance from account a, user u where a.user_id = u.id and a.user_id = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, userId);
			rs = pst.executeQuery();
			if (rs.next()) {

				User user = new User();
				user.setId(rs.getInt("user_id"));

				account = new Account();
				account.setId(rs.getInt("account_id"));
				account.setBalance(rs.getInt("balance"));
				account.setUser(user);
			}
		} catch (SQLException e) {
			throw new DBExeception("Unable to login Account", e);
		} finally {
			ConnectionUtil.close(con, pst, rs);
		}
		return account;
	}

	public Account findOne(int accountId) throws DBExeception {
		Connection con = null;
		PreparedStatement pst = null;
		Account account = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select a.id as account_id,u.id as user_id, a.balance from account a, user u where a.user_id = u.id and a.id = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, accountId);
			rs = pst.executeQuery();
			if (rs.next()) {

				User user = new User();
				user.setId(rs.getInt("user_id"));

				account = new Account();
				account.setId(rs.getInt("account_id"));
				account.setBalance(rs.getInt("balance"));
				account.setUser(user);
			}
		} catch (SQLException e) {
			throw new DBExeception("Unable to login Account", e);
		} finally {
			ConnectionUtil.close(con, pst, rs);
		}
		return account;
	}

	
	public List<Account> list() throws DBExeception {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Account> accounts = new ArrayList<Account>();
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select a.id as account_id,u.id as user_id, a.balance from account a, user u where a.user_id = u.id";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("user_id"));

				Account account = new Account();
				account.setId(rs.getInt("account_id"));
				account.setBalance(rs.getInt("balance"));
				account.setUser(user);

				accounts.add(account);
			}
		} catch (SQLException e) {
			throw new DBExeception("Unable to get all accounts", e);
		} finally {
			ConnectionUtil.close(con, pst, rs);
		}
		return accounts;
	}
}

