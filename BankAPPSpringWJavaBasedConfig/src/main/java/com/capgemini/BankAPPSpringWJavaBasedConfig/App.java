package com.capgemini.BankAPPSpringWJavaBasedConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.exceptions.InvalidInputException;
import com.capgemini.service.ServiceImplementation;
import com.capgemini.service.ServiceInterface;

public class App 
{
	public static void main( String[] args ) throws InvalidAccountNumberException, InsufficientBalanceException, InvalidInputException, InsufficientOpeningBalanceException
	{
		ApplicationContext context = new AnnotationConfigApplicationContext ();

		((AnnotationConfigApplicationContext) context).scan ("com.capgemini");
		((AnnotationConfigApplicationContext) context).refresh ();

		ServiceInterface service = context.getBean (ServiceImplementation.class);

		System.out.println (service.createAccount (123456,"Reb", 800));
		System.out.println (service.createAccount (12345677,"Hello", 400));
		System.out.println (service.depositAmount(123456, 300));
		System.out.println (service. withdrawAmount(123456, 100));
		System.out.println (service.fundTransfer (123456, 12345677, 400));
	}
}
