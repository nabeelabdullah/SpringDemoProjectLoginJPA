package com.LoginDemoProject;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.LoginDemoProject.Logics.Account;
import com.LoginDemoProject.Logics.ResultMaker;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	
	@Autowired
	private Account account;
	
	@RequestMapping(value="/login",method=RequestMethod.POST,produces= "application/json")
	public ResultMaker doLogin(
			@RequestParam(value="email") String email,
			@RequestParam(value="password") String password,
			HttpServletRequest request
			)
	{
		
	return	account.doLogin(email, password, request);
		
	}
	
}
