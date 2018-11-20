package com.capgemini.BankAPP;

import java.util.HashMap;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.exceptions.InvalidInputException;
import com.capgemini.repository.RepositoryImplementation;
import com.capgemini.repository.RepositoryInterface;
import com.capgemini.service.ServiceImplementation;
import com.capgemini.service.ServiceInterface;

public class MainApp 
{
    public static void main( String[] args ) throws InvalidAccountNumberException, InsufficientOpeningBalanceException, InsufficientBalanceException, InvalidInputException
    {
    	HashMap<Integer, Account> accountList = new HashMap<Integer, Account>();
    	RepositoryInterface repository = new RepositoryImplementation(accountList);
    	ServiceInterface service = new ServiceImplementation(repository);
    	
    	System.out.println(service.createAccount(123456, "Reb", 400.00));
    	System.out.println(service.createAccount(12345677, "hello", 800.00));
    	System.out.println(service.depositAmount(123456, 400.00));
    	System.out.println(service.withdrawAmount(12345677, 200.00));
    	System.out.println(service.fundTransfer(123456, 12345677, 400.00));

    	
    }
}
