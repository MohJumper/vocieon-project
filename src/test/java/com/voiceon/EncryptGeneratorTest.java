package com.voiceon;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class EncryptGeneratorTest {
	
	@Test
	public void encrypt_password () {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		String encodedPassword = passwordEncoder.encode("pass123");
		
		System.out.println(encodedPassword);
	}

}
