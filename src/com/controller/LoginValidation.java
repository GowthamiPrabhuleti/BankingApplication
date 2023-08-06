package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginValidation extends HttpServlet {
	protected void service(HttpServletRequest req,HttpServletResponse resp)
	{
		try {
			//collecting the form data
			String accno=req.getParameter("accno");
			String pass=req.getParameter("pass");
			
			//performing the basic validation
			if(accno.length()!=4 || pass.length()==0)
			{
				resp.sendRedirect("/BankingApplication1/invalidlogin.html");
			}
			else
			{
				req.getServletContext().getRequestDispatcher("/Login").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
