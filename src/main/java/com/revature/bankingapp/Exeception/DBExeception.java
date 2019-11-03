package com.revature.bankingapp.Exeception;

public class DBExeception extends Exception {
	public DBExeception(String message ,Throwable throwable) {
		super(message,throwable);
	}

}
