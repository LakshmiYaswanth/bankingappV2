package com.revature.bankingapp.Exeception;

public class ServiceExeception extends Exception{
	public ServiceExeception(String message) {
		super(message);
		
	}
	public ServiceExeception(String message,Throwable throwable) {
		super(message,throwable);
	}
}
