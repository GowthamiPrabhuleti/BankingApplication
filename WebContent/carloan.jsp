<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>car loan</title>
</head>
<body>
<%
session=request.getSession();
String name=(String)session.getAttribute("name");
out.println("Dear "+"<b>"+name+"</b>"+",");
/* out.print("Dear ");
out.print("<b>"+name+"</b>");
out.print(",");*/
out.println();
out.println("Thank you for applying for car loan.");
%>
</body>
</html>