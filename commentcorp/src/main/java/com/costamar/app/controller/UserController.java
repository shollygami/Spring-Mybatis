package com.costamar.app.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.costamar.app.Manager.AccountManager;
import com.costamar.app.Manager.UserManager;
import com.costamar.app.Manager.UserManagerImp;
import com.costamar.app.bean.User;

@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserManager userManagerImp;
	
	@Autowired
	AccountManager accountManagerImp;
	
	
	@RequestMapping(value = "/home", method ={ RequestMethod.POST , RequestMethod.GET} )	
	public String InitialiceLogin(@RequestParam(value ="language", required=false) String lang, Model model,@Valid User user, BindingResult result, HttpSession session){
		
		if(lang != null){
			return "welcome";
		}else{
			if(!result.hasErrors()){			

				if(userManagerImp.ValidatorLogin(user)){
					session.setAttribute("loginUser", user);	
					
					// Funcionalidad
					model.addAttribute("accounts",accountManagerImp.getAccount()) ;
					
					
					logger.info("Iniciando sesion del usuario " + user.getLogin());
					
//					return "SearchlistCommentCorp"; 
					
					return "welcome"; 
					
				} else {
					result.addError(new ObjectError("err", "Credenciales incorrectas"));
					return "index";
				}
			} else {
				return "index";
			}
		}
		
	}
	
	
}
