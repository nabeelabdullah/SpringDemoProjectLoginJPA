package com.LoginDemoProject.Logics;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LoginDemoProject.Entity.LoginTable;
import com.LoginDemoProject.repository.LoginRepo;

@Service // scope singleton by default  or use @scope 
public class Account {

	@Autowired
	private LoginRepo loginRepo;

	public ResultMaker doLogin(String email, String password, HttpServletRequest request) {
		HashMap<String, Object> result = new HashMap<>();

		try {

			LoginTable loginTable = loginRepo.findByEmail(email);

			if (loginTable != null) {
				
				if (loginTable.getPassword().equals(password)) // here we can
																// use SHA
																// algorithm for encrypt password
				{

					HttpSession session = request.getSession(true);

					// here we consider login for web app so use session for
					// authentication

					session.setAttribute("userId", loginTable.getUserId());

					result.put("response", "success");

					result.put("userId", loginTable.getUserId());

					// here we can generate a token for authentication

					loginTable.setLastLogin((new java.sql.Timestamp((new Date()).getTime())));

					loginRepo.save(loginTable);

				} else {
					result.put("response", "passwordInCurrect");
				}

			} else {
				result.put("response", "notExist");

			}

		} catch (Exception er) {

			er.printStackTrace();

			result.put("response", "failed");

		}

		return new ResultMaker(result);
	}

}
