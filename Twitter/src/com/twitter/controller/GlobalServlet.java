package com.twitter.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twitter.entity.TwitterEmployee;
import com.twitter.service.TwitterService;
import com.twitter.service.TwitterServiceInterface;

/**
 * Servlet implementation class GlobalServlet
 */
public class GlobalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest rqs, HttpServletResponse rsp) throws ServletException, IOException 
	{
		rsp.setContentType("text/html");
		PrintWriter out=rsp.getWriter();
		out.println("<html><body>");
		String option=rqs.getParameter("ac");
		if(option.equals("Login"))
		{
			String name=rqs.getParameter("name");
			String pass=rqs.getParameter("pass");
			String email=rqs.getParameter("email");
			String address=rqs.getParameter("address");
			TwitterEmployee tw=new TwitterEmployee();
			tw.setName(name);
			tw.setPass(pass);
			tw.setEmail(email);
			tw.setAddress(address);
			TwitterServiceInterface ts=TwitterService.createServiceObject();
			int i=ts.createProfile(tw);
			System.out.println(i);
			if(i>0) {
				out.println("profile is created");
				
			}
			else {
				out.println("profile is not created");
			}
		}
		
		
		if(option.equals("register"))
		{
			
		}
		if(option.equals("timeline")) {
			
		}
		out.println("</body></html>");
		}
				
				
				



		}



				
			
	


