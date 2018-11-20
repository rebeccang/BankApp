package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.exceptions.InvalidInputException;
import com.capgemini.repository.RepositoryInterface;

public class ServiceImplementation implements ServiceInterface{
	private RepositoryInterface repository;
	
	public ServiceImplementation (RepositoryInterface repository) {
		this.repository=repository;
	}

	public Account createAccount(int accountNumber, String name, double amount)
			throws InvalidAccountNumberException, InsufficientOpeningBalanceException {
		Account account = new Account(accountNumber, name, amount);
		
		if (accountNumber <= 0 )  throw new InvalidAccountNumberException ("Input for account number cannot be less than or equal to zero");
		if (String.valueOf(accountNumber).length() <6 )  throw new InvalidAccountNumberException ("Input for account number must be more than 5 digits");
		
		if (amount<300) throw new InsufficientOpeningBalanceException ("Opening balance must be $300 or more.");
		
		repository.save(account);
		return account;
	}

	public Account depositAmount(int accountNumber, double amount) throws InvalidAccountNumberException, InsufficientBalanceException, InvalidInputException {
		
		if (accountNumber <= 0 )  throw new InvalidAccountNumberException ("Input for account number cannot be less than or equal to zero");
		if (String.valueOf(accountNumber).length() <6 )  throw new InvalidAccountNumberException ("Input for account number must be more than 5 digits");
		
		if(amount<0) throw new InvalidInputException ("Deposit amount cannot be negative");
		
		Account account = repository.findByAccountNumber(accountNumber);
		double balance= account.getAmount() + amount;
		
		account.setAmount(balance);
		
		repository.update(account);
		return account;
	}

	public Account withdrawAmount(int accountNumber, double amount)
			throws InvalidAccountNumberException, InsufficientBalanceException, InvalidInputException {
		
		if (accountNumber <= 0 )  throw new InvalidAccountNumberException ("Input for account number cannot be less than or equal to zero");
		if (String.valueOf(accountNumber).length() <6 )  throw new InvalidAccountNumberException ("Input for account number must be more than 5 digits");
		
		Account account = repository.findByAccountNumber(accountNumber);
		if( amount > account.getAmount()) throw new InsufficientBalanceException ("Insufficient balance to withdraw " +amount);
		if(amount<0) throw new InvalidInputException ("Withdrawal amount cannot be negative");
		
		double balance = account.getAmount()-amount;
		account.setAmount(balance);
		
		repository.update(account);
		return account;
	}

	public Account fundTransfer(int fromAccountNumber, int toAccountNumber, double amount)
			throws InvalidAccountNumberException, InsufficientBalanceException, InvalidInputException {
		
		if (fromAccountNumber <=0 || toAccountNumber <= 0)  throw new InvalidAccountNumberException ("Input for account number cannot be less than or equal to zero");
		if (String.valueOf(fromAccountNumber).length() <6 || String.valueOf(toAccountNumber).length() <6 )  throw new InvalidAccountNumberException ("Input for account number must be more than 5 digits");
		
		Account fromAccount = repository.findByAccountNumber(fromAccountNumber);
		Account toAccount = repository.findByAccountNumber(toAccountNumber);
		
		if (amount> fromAccount.getAmount()) throw new InsufficientBalanceException ("Insufficient balance to transfer " +amount);
		if(amount<0) throw new InvalidInputException ("Fund transfer amount cannot be negative");
		
		fromAccount.setAmount(fromAccount.getAmount()-amount);
		toAccount.setAmount(toAccount.getAmount()+amount);
		
		repository.update(fromAccount);
		repository.update(toAccount);
		return fromAccount;
	}

}
