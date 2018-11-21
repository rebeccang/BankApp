package com.capgemini.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.capgemini.beans.Account;
import com.capgemini.repository.RepositoryImplementation;
import com.capgemini.repository.RepositoryInterface;
import com.capgemini.service.ServiceImplementation;


@Configuration
public class MyConfiguration {
	
	
	@Bean
	@Qualifier ("map")
	public Map <String, Account> map ()
	{
		return new HashMap <String, Account> ();
	}

}
