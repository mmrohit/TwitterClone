<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page import="Beans.LoginSuccessBean"  %>

<%if(((LoginSuccessBean)session.getAttribute("lsb"))==null)
{
	
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
function logout()
{
	document.getElementById('logout').submit();
	}
</script>
</head>
<body onLoad="logout()">
<s:form action="nologin" name="logout" id="logout"></s:form>

</body>
</html>
<%}

else
{%>
<html>
<head>
<link rel="stylesheet" href="header.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body >
<br>
<center>
<div style="border: thin;border: solid #336666;width: 40%;">
<br>
<img src= "Images/TwitterBird.gif" height="70px" width="50px"><br>
<font size="+2" color=""><b><%= ((LoginSuccessBean)session.getAttribute("lsb")).getUname() %></b></font><br>
<b>
<a href='<s:url action="home"/>'>Home</a>&nbsp;|&nbsp;
<a href='<s:url action="profile"/>'>Profile</a>&nbsp;|&nbsp;
<a href="<s:url action="ntweets"/>">(<%= ((LoginSuccessBean)session.getAttribute("lsb")).getTcount() %>) &nbsp;MyTweets</a>&nbsp;|&nbsp;
<a href="<s:url action="following"/>">(<%= ((LoginSuccessBean)session.getAttribute("lsb")).getNfg() %>) &nbsp;Following</a>&nbsp;|&nbsp;
<a href="<s:url action="followers"/>">(<%= ((LoginSuccessBean)session.getAttribute("lsb")).getNfr() %>) &nbsp;Followers</a>&nbsp;|&nbsp;
<a href='<s:url action="signout"/>'>LogOut</a> 
</b></font>

<br>
</div>
</center>
</body>
</html>
<% }%>



