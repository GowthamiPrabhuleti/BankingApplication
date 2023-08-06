package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;


public class Balance extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse resp)
	{
		try {
			HttpSession hs=req.getSession();
			//getting from the session
			String pwd=(String)hs.getAttribute("pass");
			int accno=(int)hs.getAttribute("accno");
			
			//getting from form data
			String pass=req.getParameter("pass");
			if(pwd.equals(pass))
			{
				Model m= new Model();
				m.setAccno(accno);
				boolean status=m.viewBalance();
				int bal=m.getBalance();
				
				if(status==true)
				{
					hs.setAttribute("newbal", bal);
					resp.sendRedirect("/BankingApplication1/balancesuccess.jsp");
				}
				else
				{
					resp.sendRedirect("/BankingApplication1/balancefail.html");
				}
			}
			else{
				resp.sendRedirect("/BankingApplication1/balanceerror.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
