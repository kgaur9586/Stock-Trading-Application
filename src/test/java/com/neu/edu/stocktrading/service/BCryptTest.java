package com.neu.edu.stocktrading.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

public class BCryptTest {
	
	@Test
	public void generateEncryptedPasswordTest() 
	{
		String actualEncryptedPass = BCrypt.hashpw("Pass@123", BCrypt.gensalt());
		Assertions.assertTrue(BCrypt.checkpw("Pass@123", actualEncryptedPass));
	}
}