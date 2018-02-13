package com.umassd.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * 
 * @author mkyong 
 * @reference:https://www.mkyong.com/java/java-sha-hashing-example/
 *@desc: to hash the value passed using SHA-256
 */
public class SHAHashingExample
{
    public static String hashValue(String value)
    {
    	String result;
		try {
			result = null;
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(value.getBytes());

			byte byteData[] = md.digest();

			//convert the byte to hex format method 1
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
			 sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}

			//System.out.println("Hex format : " + sb.toString());

			//convert the byte to hex format method 2
			StringBuffer hexString = new StringBuffer();
			for (int i=0;i<byteData.length;i++) {
				String hex=Integer.toHexString(0xff & byteData[i]);
			 	if(hex.length()==1) hexString.append('0');
			 	hexString.append(hex);
			}
			//System.out.println("Hex format : " + hexString.toString());
			result=hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return e.getMessage();
		}
		catch (Exception e) {
			e.printStackTrace();
			return "Generic Error";
		}
    	
    	return result;
    }
}