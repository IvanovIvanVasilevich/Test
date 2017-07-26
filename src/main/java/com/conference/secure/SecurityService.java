package com.conference.secure;

public interface SecurityService {
	
	   String findLoggedInUsername();

	    void autologin(String username, String password);

}
