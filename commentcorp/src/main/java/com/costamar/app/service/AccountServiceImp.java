package com.costamar.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.costamar.app.DAO.AccountMapper;
import com.costamar.app.bean.Account;


@Transactional
@Service
public class AccountServiceImp implements AccountService {
	
	@Autowired
	AccountMapper accountMapper;

	public List<Account> getaccount() {
		return accountMapper.getAccount();
	}
	
}
