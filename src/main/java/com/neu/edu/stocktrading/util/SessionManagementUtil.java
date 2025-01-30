package com.neu.edu.stocktrading.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SessionManagementUtil
{
    private static final Logger logger = LoggerFactory.getLogger(SessionManagementUtil.class);

		public Boolean doesSessionExist(HttpServletRequest request) 
		{
			logger.info("doesSessionExist::INSIDE");
			if (request.getSession(false) != null) 
			{
				logger.info("Session exists");

				if (request.getSession().getAttribute("user") != null) 
				{
					logger.info("User exists");
					return true;
				}
				else
				{
					logger.info("User does not exists");
					return false;
				}
			}

		logger.info("doesSessionExist::FALSE");
		return false;
	}

	public HttpSession createNewSessionForUser(HttpServletRequest request, String email) 
	{
		logger.debug("createNewSessionForUser::INSIDE::"+email);
		logger.info("createNewSessionForUser {} {}",email,request);
		if (!doesSessionExist(request)) 
		{
			logger.info("yes session exists");
			HttpSession session = request.getSession();
			session.setAttribute("user", email);
			return session;
		} 
		else 
		{
			logger.info("createNewSessionForUser::Return current session::");
			return request.getSession();
		}
	}
}