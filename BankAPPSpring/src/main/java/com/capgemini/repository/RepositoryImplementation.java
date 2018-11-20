package com.capgemini.repository;

import java.util.Map;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;

public class RepositoryImplementation implements RepositoryInterface{
	private Map<Integer, Account> accounts;

	public RepositoryImplementation (Map<Integer, Account> accounts){

		this.accounts=accounts;

	}

	public Account save(Account account) throws InvalidAccountNumberException {

		if (account == null) throw new InvalidAccountNumberException("Account cannot be null");

		if (account.getAccountNumber() <= 0 )  throw new InvalidAccountNumberException ("Input for account number cannot be less than or equal to zero");
		if (String.valueOf(account.getAccountNumber()).length() <6 )  throw new InvalidAccountNumberException ("Input for account number must be more than 5 digits");

		accounts.put(account.getAccountNumber(), account);
		return account;
	}

	public Account update(Account account) throws InvalidAccountNumberException, InsufficientBalanceException {
		if (account == null) throw new InvalidAccountNumberException("Account cannot be null");

		if (account.getAccountNumber() <= 0 )  throw new InvalidAccountNumberException ("Input for account number cannot be less than or equal to zero");
		if (String.valueOf(account.getAccountNumber()).length() <6 )  throw new InvalidAccountNumberException ("Input for account number must be more than 5 digits");

		accounts.replace(account.getAccountNumber(), account);
		return account;
	}

	public Account findByAccountNumber(int accountNumber) throws InvalidAccountNumberException {
		if (accountNumber <= 0 )  throw new InvalidAccountNumberException ("Input for account number cannot be less than or equal to zero");
		if (String.valueOf(accountNumber).length() <6 )  throw new InvalidAccountNumberException ("Input for account number must be more than 5 digits");
		
		Account account =accounts.get(accountNumber);

		return account;
	}

}
