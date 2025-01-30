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
<<<<<<< HEAD
			logger.info("doesSessionExist::INSIDE");
			if (request.getSession(false) != null) 
			{
				logger.info("Session exists");

				if (request.getSession().getAttribute("user") != null) 
				{
					logger.info("User exists");
=======
			logger.debug("doesSessionExist::INSIDE");
			if (request.getSession(false) != null) 
			{
				logger.debug("Session exists");

				if (request.getSession().getAttribute("user") != null) 
				{
					logger.debug("User exists");
>>>>>>> bfa3d0c092865e6b8aacd1af30606a372ba3957f
					return true;
				}
				else
				{
<<<<<<< HEAD
					logger.info("User does not exists");
=======
					logger.debug("User does not exists");
>>>>>>> bfa3d0c092865e6b8aacd1af30606a372ba3957f
					return false;
				}
			}

<<<<<<< HEAD
		logger.info("doesSessionExist::FALSE");
=======
		logger.debug("doesSessionExist::FALSE");
>>>>>>> bfa3d0c092865e6b8aacd1af30606a372ba3957f
		return false;
	}

	public HttpSession createNewSessionForUser(HttpServletRequest request, String email) 
	{
		logger.debug("createNewSessionForUser::INSIDE::"+email);
<<<<<<< HEAD
		logger.info("createNewSessionForUser {} {}",email,request);
		if (!doesSessionExist(request)) 
		{
			logger.info("yes session exists");
=======
		if (!doesSessionExist(request)) 
		{
>>>>>>> bfa3d0c092865e6b8aacd1af30606a372ba3957f
			HttpSession session = request.getSession();
			session.setAttribute("user", email);
			return session;
		} 
		else 
		{
<<<<<<< HEAD
			logger.info("createNewSessionForUser::Return current session::");
=======
			logger.debug("createNewSessionForUser::Return current session::");
>>>>>>> bfa3d0c092865e6b8aacd1af30606a372ba3957f
			return request.getSession();
		}
	}
}