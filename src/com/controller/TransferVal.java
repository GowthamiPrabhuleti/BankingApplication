package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TransferVal extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp){
		try {
			String taccno = req.getParameter("taccno");
			String amount= req.getParameter("amount");
			
			if(taccno.length()==0 || amount.length()==0)
			{
				resp.sendRedirect("/BankingApplication1/transfererror.html");
			}
			else
			{
				req.getServletContext().getRequestDispatcher("/Transfer").forward(req,resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
