package com.costamar.app.Manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.costamar.app.bean.Account;
import com.costamar.app.service.AccountService;



@Component
public class AccountManagerImp implements AccountManager {

	
	@Autowired
	AccountService accountService;
	
	public List<Account> getAccount(){		
		
		return accountService.getaccount() ;
		
	}
	
}
