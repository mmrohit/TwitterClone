<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="Beans.HomeTweetBean" %>
<%@page import="Beans.LoginSuccessBean" %>




<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body style="background-image: url('Images/hometweetbg.gif');">



<%
int tweets=((HomeTweetBean)session.getAttribute("htb")).getUname().size();

for(int i=0;i<tweets;i++)
{
%>


<%if(  ((HomeTweetBean)session.getAttribute("htb")).getUname().get(i).equals(((LoginSuccessBean)session.getAttribute("lsb")).getUname()) )
	
	{ %>
	
	<font color="blue" >@<%= ((HomeTweetBean)session.getAttribute("htb")).getUname().get(i) %></font>  &nbsp;&nbsp;&nbsp;<b><%= ((HomeTweetBean)session.getAttribute("htb")).getMessage().get(i) %></b> &nbsp;&nbsp;&nbsp;<font color="green"><%= ((HomeTweetBean)session.getAttribute("htb")).getTimestamp().get(i) %></font><br>
<%}

else

{%>

<font color="#660033">@<%= ((HomeTweetBean)session.getAttribute("htb")).getUname().get(i) %></font>  &nbsp;&nbsp;&nbsp;<b><%= ((HomeTweetBean)session.getAttribute("htb")).getMessage().get(i) %></b> &nbsp;&nbsp;&nbsp;<font color="green"><%= ((HomeTweetBean)session.getAttribute("htb")).getTimestamp().get(i) %></font><br>
<%} %>

<%} %>

</body>
</html>

