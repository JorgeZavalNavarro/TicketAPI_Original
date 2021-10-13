package com.enlacetpe.ticketapi.util;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class ActivityLogger {

	final static Logger logger = Logger.getLogger(ActivityLogger.class);
	private static Authentication auth;
	
	public static void logMethod(String method) {
		auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			logger.info("User: " + auth.getName() + ", Method: " + method + ", Role: " + auth.getAuthorities());
		}else {
			logger.info("Method: " + method );
		}
		
		
	}
}
