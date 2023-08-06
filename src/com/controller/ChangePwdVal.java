package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ChangePwdVal extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String op=req.getParameter("op");
			String np=req.getParameter("np");
			String cp=req.getParameter("cp");
			
			if(op.length()==0 || np.length()==0 || cp.length()==0)
			{
				resp.sendRedirect("/BankingApplication1/changepwderror.html");
			}
			else
			{
				if(np.equals(cp))
				{
					req.getServletContext().getRequestDispatcher("/ChangePwd").forward(req, resp);
				}
				else
				{
					resp.sendRedirect("/BankingApplication1/changepwderror.html");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
