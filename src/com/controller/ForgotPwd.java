package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;

public class ForgotPwd extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp){
		try {
			int accno= Integer.parseInt(req.getParameter("accno"));
			String name=req.getParameter("name");
			String email=req.getParameter("email");
			String np=req.getParameter("np");
			
			
			Model m = new Model();
			m.setAccno(accno);
			m.setName(name);
			m.setEmail(email);
			
			
			boolean status = m.forgotPwd(np);
			if(status==true)
			{
				resp.sendRedirect("/BankingApplication1/forgotpwdsuccess.html");
			}
			else
			{
				resp.sendRedirect("/BankingApplication1/forgotpwdfail.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
