package com.enlacetpe.ticketapi.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SpringBCryptPasswordEncoder {

	public static void main(String[] args) {
		String password = "pdm"; 
	    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
	    String encodedPassword = passwordEncoder.encode(password);  
	    System.out.print(encodedPassword);

	}

}
