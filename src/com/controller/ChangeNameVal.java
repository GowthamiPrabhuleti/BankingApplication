package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ChangeNameVal extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp){
		try {
			String on=req.getParameter("on");
			String nn=req.getParameter("nn");
			
			
			if(on.length()==0 || nn.length()==0)
			{
				resp.sendRedirect("/BankingApplication1/changenameerror.html");
			}
			else
			{
				req.getServletContext().getRequestDispatcher("/ChangeName").forward(req, resp);
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


