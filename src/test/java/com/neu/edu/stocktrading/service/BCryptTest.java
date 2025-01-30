package com.neu.edu.stocktrading.service;

<<<<<<< HEAD
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
=======
import org.junit.Assert;
import org.junit.Test;
>>>>>>> bfa3d0c092865e6b8aacd1af30606a372ba3957f
import org.mindrot.jbcrypt.BCrypt;

public class BCryptTest {
	
	@Test
	public void generateEncryptedPasswordTest() 
	{
		String actualEncryptedPass = BCrypt.hashpw("Pass@123", BCrypt.gensalt());
<<<<<<< HEAD
		Assertions.assertTrue(BCrypt.checkpw("Pass@123", actualEncryptedPass));
=======
		Assert.assertTrue(BCrypt.checkpw("Pass@123", actualEncryptedPass));
>>>>>>> bfa3d0c092865e6b8aacd1af30606a372ba3957f
	}
}