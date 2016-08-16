<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="header.jsp" %>
<%@ page import="Beans.LoginSuccessBean" %>
<%@taglib prefix="s" uri="/struts-tags" %>

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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>People Following You</title>
<link TYPE="text/css" REL="stylesheet" HREF="following.css">
</head>
<body>
<br> 
<center>
<div style="float:left; width: 8%;">

<s:form name="search" action="search"><s:textfield key="searchkey" label="Search and Follow" labelposition="top"/><br>
 <s:submit value="search" align="center"></s:submit></s:form>
 </div>



<div style="float:right;width:20%;">
<s:form action="tweet" name="form">
<s:textarea label="what are you doing" key="tweet" name="tweet" rows="2" cols="20" labelposition="top"></s:textarea>
<input type="hidden" name="uname" value="<%=((LoginSuccessBean)session.getAttribute("lsb")).getUname() %>"/>
<s:submit value="Tweet" align="center"></s:submit>
</s:form>
</div>

<% String[] following=((LoginSuccessBean)session.getAttribute("lsb")).getFollowing();
int count=following.length;
for(int i=0;i<count;i++)
{
%>	
	<div style="border: 1px solid lime; width: 20%">
		<s:form action="unfollow">
	    <input type="hidden" name="fname" value="<%= following[i] %>">
	   <u>UserId</u><br>
	   <b> <%= following[i] %></b>&nbsp;
	   <s:submit value="unfollow" align="center"></s:submit>
	</s:form>
	</div>
<%} %>
</center>
</body>
</html>

<%}%>