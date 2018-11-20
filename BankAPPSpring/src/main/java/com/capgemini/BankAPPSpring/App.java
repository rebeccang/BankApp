package com.capgemini.BankAPPSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.exceptions.InvalidInputException;
import com.capgemini.service.*;

public class App 
{
    public static void main( String[] args ) throws InvalidAccountNumberException, InsufficientOpeningBalanceException, InsufficientBalanceException, InvalidInputException
    {
    	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
    	
    	ServiceInterface service = (ServiceInterface) applicationContext.getBean("service");
    	Account a = (Account) applicationContext.getBean("account1");
    	Account b = (Account) applicationContext.getBean("account2");
    	
    	System.out.println(service.createAccount(a.getAccountNumber(), a.getName(), a.getAmount()));
    	System.out.println(service.createAccount(b.getAccountNumber(), b.getName(), b.getAmount()));
    	System.out.println(service.depositAmount(a.getAccountNumber(), 400.00));
    	System.out.println(service.withdrawAmount(a.getAccountNumber(), 200.00));
    	System.out.println(service.fundTransfer(a.getAccountNumber(), b.getAccountNumber(), 400.00));
    
    }
}
