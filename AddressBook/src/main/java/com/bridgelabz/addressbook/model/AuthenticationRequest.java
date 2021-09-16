package com.bridgelabz.addressbook.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {

	private String Username;
	private String password;
	
	public AuthenticationRequest() {}
	
	public AuthenticationRequest(String username, String password) {
		Username = username;
		this.password = password;
	}
}
