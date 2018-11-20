package com.capgemini.beans;

public class Account {
	private int accountNumber;
	private String name;
	private double amount;
	
	public Account(int accountNumber, String name, double amount) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.amount = amount;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", amount=" + amount + "]";
	}
	
	

}
