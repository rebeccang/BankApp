package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.exceptions.InvalidInputException;

public interface ServiceInterface {
	
	public Account createAccount(int accountNumber, String name, double amount) throws InvalidAccountNumberException, InsufficientOpeningBalanceException;
	public Account depositAmount(int accountNumber, double amount) throws InvalidAccountNumberException, InsufficientBalanceException, InvalidInputException;
	public Account withdrawAmount(int accountNumber, double amount) throws InvalidAccountNumberException, InsufficientBalanceException, InvalidInputException;
	public Account fundTransfer(int fromAccountNumber, int toAccountNumber, double amount) throws InvalidAccountNumberException, InsufficientBalanceException, InvalidInputException;
	
}
