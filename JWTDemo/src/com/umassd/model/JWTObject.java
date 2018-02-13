package com.umassd.model;
/**
 * 
 * @author sreerag
 * @desc: to pass the output to the front end
 */
public class JWTObject 
{
	private int id;
	
	private String issuer;
	
	private String subject;
	
	private long timeToLive;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public long getTimeToLive() {
		return timeToLive;
	}

	public void setTimeToLive(long timeToLive) {
		this.timeToLive = timeToLive;
	}
	
	
}
