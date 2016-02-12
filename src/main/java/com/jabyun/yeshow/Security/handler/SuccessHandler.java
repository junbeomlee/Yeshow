package com.jabyun.yeshow.Security.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class SuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
	
		//ArrayList<Object> resultListData = new ArrayList<Object>();
		Map<String, Object> mapRslt = new HashMap<String, Object>();
		mapRslt.put("userName", authentication.getName());
		mapRslt.put("userRoles", "ADMIN");
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(mapRslt.toString());
		//response.sendRedirect(request.getContextPath()+"/admin");
	}
}
