<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <link TYPE="text/css" REL="stylesheet" HREF= "tweet.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EDIT YOUR TWEET</title>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page import="Beans.LoginSuccessBean" %>
<%@page import="Beans.MyTweetsBean" %>

<%if(((LoginSuccessBean)session.getAttribute("lsb"))==null)
{
	
%>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
function logout()
{
	document.getElementById('logout').submit();
	}
</script>
</head>
<body onload="logout()">
<s:form action="nologin" name="logout" id="logout"></s:form>

</body>
</html>
<%}

else
{%>
<%@page import="Beans.MyTweetsBean" %>
<html>
</head>
<body>
<center>

<%@include file="header.jsp" %>


<s:form action="edittweetaction">
<textarea rows=5 cols=60 name="message"><%= ((MyTweetsBean)session.getAttribute("mytweets")).getMyTweets().get(session.getAttribute("et_id")) %></textarea>
<s:submit value="Update Tweet"></s:submit>
</s:form>


</center>
</body>
</html>

<%}%>