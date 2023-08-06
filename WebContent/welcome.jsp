<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="styling.css" type="text/css" rel="stylesheet">
<title>welcome page</title>
</head>
<body>
<div id="nav">
<ul>
<li><a href="/BankingApplication1/balance.html">View Balance</a></li>
<li><a href="/BankingApplication1/loan.html">Apply Loan</a></li>
<li><a href="/BankingApplication1/transfer.html">Transfer Money</a></li>
<li><a href="/BankingApplication1/changepwd.html">Change Password</a></li>
<li><a href="/BankingApplication1/changename.html">Change Name</a></li>
<li><a href="/BankingApplication1/logout.jsp">Logout</a></li>
</ul>
</div>
<br>
<br>
<%
session = request.getSession();
String name=(String)session.getAttribute("name");
int accno=(int)session.getAttribute("accno");
out.println("<h3>Welcome "+name+"</br>");
out.println("Account number : "+accno);
out.println("</h3>");
%>
</body>
</html>