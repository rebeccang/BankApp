package com.capgemini.repository;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.*;

public interface RepositoryInterface {
	public Account save(Account account) throws InvalidAccountNumberException;
	public Account update (Account account) throws InvalidAccountNumberException, InsufficientBalanceException;
	public Account findByAccountNumber(int accountNumber) throws InvalidAccountNumberException;

}
