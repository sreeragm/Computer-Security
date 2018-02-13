package com.umassd.model;

import java.util.Date;
/**
 * 
 * @author sreerag
 * @desc: pojo to set and get the payload values
 */
public class JWTOutput {

private String key;

private boolean isValid;

private Date date;

public String getKey() {
	return key;
}

public void setKey(String key) {
	this.key = key;
}

public boolean isValid() {
	return isValid;
}

public void setValid(boolean isValid) {
	this.isValid = isValid;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}



	
}
