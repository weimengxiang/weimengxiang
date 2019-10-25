package org.wmx.jwy.commons.bean;

import java.io.Serializable;

public class UserBean implements Serializable {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public int uuid;
 
 public String username;
 
 public String password;

public int getUuid() {
	return uuid;
}

public void setUuid(int uuid) {
	this.uuid = uuid;
}

public String getUsername() {
	return username;
}
public String getUsername(String user) {
	
	return user;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
public String toString() {
	return "UserBean [uuid=" + uuid + ", username=" + username + ", password=" + password + "]";
}
 
 
}
