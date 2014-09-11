package com.costamar.app.Manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.costamar.app.bean.User;
import com.costamar.app.service.UserService;


@Component
public class UserManagerImp implements UserManager {
	

	@Autowired
	UserService userServiceImp;
	
	public boolean ValidatorLogin(User user){
			
		Integer validator= 0;
		
		validator = userServiceImp.ValidatorLogin(user.getLogin(), user.getPass());
		
		return validator == 1 ? true : false ;
		
	}
	
	
}
