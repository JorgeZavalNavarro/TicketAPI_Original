package com.enlacetpe.ticketapi.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.enlacetpe.ticketapi.util.AES128;

public class PruebaEnciptarDesencriptar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AES128 aes = new AES128();
		String pass1 = aes.encrypt("g3st0r_d4sHbo4rd");
		System.out.print(" +++++++++++PASS 1++++++++++++: "+pass1);
		
		/***************************************************************************/
		
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String pass2 = passwordEncoder.encode("g3st0r_d4sHbo4rd");
		System.out.print(" ****************PASS 2: ************: "+pass2);

	}

}
