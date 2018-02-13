package com.umassd.controller;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import com.umassd.model.JWTObject;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
/**
 * 
 * @author sreerag
 * @desc: create JWT, creates the jwt for the object of details passed
 * 		: parse JWT checks if the key passed is valid
 * @reference: https://stormpath.com/blog/jwt-java-create-verify
 *
 */
public class JWT {

	public String createJWT(JWTObject object) {

	
	    //The JWT signature algorithm we will be using to sign the token
	    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

	    long nowMillis = System.currentTimeMillis();
	    Date now = new Date(nowMillis);

	    //We will sign our JWT with our ApiKey secret
	    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(JWTConstants.SECRET_KEY);
	    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

	    //Let's set the JWT Claims
	    JwtBuilder builder = Jwts.builder().setId(""+object.getId())
	                                .setIssuedAt(now)
	                                .setSubject(object.getSubject())
	                                .setIssuer(object.getIssuer())
	                                .signWith(signatureAlgorithm, signingKey);

	    //if it has been specified, let's add the expiration
	    if (object.getTimeToLive() >= 0) {
	    long expMillis = nowMillis + object.getTimeToLive();
	        Date exp = new Date(expMillis);
	        builder.setExpiration(exp);
	    }

	    //Builds the JWT and serializes it to a compact, URL-safe string
	    return builder.compact();
	}
	
	
	public String parseJWT(String jwt) {
		 
	    //This line will throw an exception if it is not a signed JWS (as expected)
	    try {
			Claims claims = Jwts.parser()         
			   .setSigningKey(DatatypeConverter.parseBase64Binary(JWTConstants.SECRET_KEY))
			   .parseClaimsJws(jwt).getBody();
			System.out.println("ID: " + claims.getId());
			System.out.println("Subject: " + claims.getSubject());
			System.out.println("Issuer: " + claims.getIssuer());
			System.out.println("Expiration: " + claims.getExpiration());
		} catch (ExpiredJwtException e) {
			e.printStackTrace();
			return e.getMessage();

		} catch (UnsupportedJwtException e) {
			e.printStackTrace();
			return e.getMessage();
		} catch (MalformedJwtException e) {
			e.printStackTrace();
			return e.getMessage();
		} catch (SignatureException e) {
			e.printStackTrace();
			return e.getMessage();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	      catch(Exception e) {
	    	  e.printStackTrace();
				return "Generic Error";
	    }
	    
	    return "success!";
	}
	
}
