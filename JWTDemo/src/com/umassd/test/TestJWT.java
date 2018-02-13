package com.umassd.test;

import java.util.Date;

import com.umassd.controller.JWT;
import com.umassd.model.JWTObject;
import com.umassd.model.JWTOutput;
/**
 * 
 * @author sreerag
 * @category: main class to implement basic JJWT (Java JSON Web Token)
 *
 */
public class TestJWT 
{

	public static void main(String[] args) 
	{
		// Passing the input values
		// Passed as a stub for demo. Will be in the form of JSON from the front end
		JWTObject obj=new JWTObject();
		JWTOutput output=new JWTOutput();
		
		obj.setId(1);
		obj.setIssuer("Sreerag");
		obj.setSubject("Hello World!");
		obj.setTimeToLive(500000);
		
		
		JWT jwt=new JWT();
		
		// Create the signature key
		String key=jwt.createJWT(obj);
		System.out.println("JWT signature key");
		System.out.println(key);
		
		// Send the key to the front end/back end
		
		// Passing the key to check for authenticity
		String message=jwt.parseJWT(key);
		
		System.out.println(message);

		// If both true, return success, else error message
		if(message!=null && message.equalsIgnoreCase("Success"))
		{
			output.setDate(new Date());
			output.setKey(key);
			output.setValid(true);
		}
		else
		{
			output.setValid(false);
		}

		
	}
}
