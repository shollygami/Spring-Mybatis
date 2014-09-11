package com.costamar.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.costamar.app.DAO.UserMapper;


@Transactional
@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	UserMapper userMapper;

	public Integer ValidatorLogin(String login, String pass) {
		return userMapper.valiatorLogin(login, pass);
	}	
}