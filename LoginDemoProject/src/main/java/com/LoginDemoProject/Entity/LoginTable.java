package com.LoginDemoProject.Entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="login")
public class LoginTable {
	
	@Id
	@Column(name="userId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userId;
	
	@Column(name="email",unique=true,nullable=false)
	private String email;
	
	@Column(name="password",nullable=false)
	private String password;
	
	@Column(name="lastLogIn")
	private Timestamp lastLogin;

	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	
	

}
