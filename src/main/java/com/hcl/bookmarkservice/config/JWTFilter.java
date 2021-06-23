package com.hcl.bookmarkservice.config;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;


public class JWTFilter implements Filter{
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String authHeader = req.getHeader("authorization");
		
		if(req.getMethod().equals("OPTIONS")) {
			res.setStatus(res.SC_OK);
			chain.doFilter(request, response);
		}else {
			
			if(authHeader == null || !authHeader.startsWith("Bearer ")){
				throw new ServletException("Missing Token");
			}
			
			System.out.println("Auth header : "+authHeader);
			String token = authHeader.split(" ")[1];
			System.out.println(token);
			
			try {
				
				Claims claims = Jwts
									.parser()
									.setSigningKey("placeapp")
									.parseClaimsJws(token).getBody();
				
				System.out.println("User logged in : "+ claims.getSubject());
				request.setAttribute("claims",claims);
				chain.doFilter(request, response);
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			
		}
		
		
		
	}



}
