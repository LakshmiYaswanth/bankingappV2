package com.revature.bankingapp.TestConnectionUtill;

import java.sql.Connection;

import com.revature.bankingapp.connectionUtill.ConnectionUtil;

public class TestConnection {
	public static void main(String[] args) {
		Connection connection = ConnectionUtil.getConnection();
		System.out.println(connection);
	}

}
