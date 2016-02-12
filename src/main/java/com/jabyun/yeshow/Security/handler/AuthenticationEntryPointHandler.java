package com.jabyun.yeshow.Security.handler;

import java.io.IOException;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.AuthenticationEntryPoint;

public class AuthenticationEntryPointHandler implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			org.springframework.security.core.AuthenticationException authException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String[] path=request.getRequestURI().split("/");
		String plusPath="";
		if(path[path.length-2].equals("admin")){
			plusPath="/login.html";
		}
		response.sendRedirect(request.getContextPath()+plusPath);
	}
}