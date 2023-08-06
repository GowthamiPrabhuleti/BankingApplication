package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Model;


public class Register extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse resp)
	{
		try {
			int accno=Integer.parseInt(req.getParameter("accno"));
			String name=req.getParameter("name");
			String pass=req.getParameter("pass");
			String email=req.getParameter("email");
			int balance = Integer.parseInt(req.getParameter("balance"));
			
			Model m = new Model();
			m.setAccno(accno);
			m.setName(name);
			m.setPass(pass);
			m.setEmail(email);
			m.setBalance(balance);
			
			boolean status=m.register();
			
			if(status==true)
			{
				resp.sendRedirect("/BankingApplication1/regsuccess.html");
			}
			else
			{
				resp.sendRedirect("/BankingApplication1/regfail.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
