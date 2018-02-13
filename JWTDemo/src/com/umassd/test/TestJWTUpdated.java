package com.umassd.test;

import java.util.Date;

import com.umassd.controller.JWTUpdated;
import com.umassd.model.JWTObject;
import com.umassd.model.JWTOutput;

/**
 * 
 * @author sreerag
 * @category: main class to implement updated JJWT (Java JSON Web Token)
 * 			: 
 */
public class TestJWTUpdated 
{

	public static void main(String[] args) 
	{
		JWTObject obj=new JWTObject();
		JWTOutput output=new JWTOutput();
		
		obj.setId(1);
		obj.setIssuer("Sreerag");
		obj.setSubject("Hello World!");
		obj.setTimeToLive(500000);
		
		
		JWTUpdated jwt=new JWTUpdated();
		
		String key=jwt.createJWT(obj,new Date());
		System.out.println("JWT signature key");
		System.out.println(key);
		
		String message=jwt.parseJWT(key,obj.getIssuer(),new Date());
		
		System.out.println(message);
		
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
