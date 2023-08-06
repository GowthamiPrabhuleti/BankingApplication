package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;


public class ChangeName extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp){
		try {
			String on=req.getParameter("on");
			String nn=req.getParameter("nn");
			
			HttpSession hs = req.getSession();
			int accno=(int)hs.getAttribute("accno");
			
			Model m = new Model();
			m.setAccno(accno);
			m.setName(on);
			
			boolean status = m.changeName(nn);
			if(status==true)
			{
				resp.sendRedirect("/BankingApplication1/changenamesuccess.html");
			}
			else
			{
				resp.sendRedirect("/BankingApplication1/changenamefail.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
