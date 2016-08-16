<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <link TYPE="text/css" REL="stylesheet" HREF= "following.css">
     <%@taglib prefix="s" uri="/struts-tags" %>
     <%@ page import="Beans.LoginSuccessBean" %>
    
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
    
    
     <%@ page import="Beans.SearchBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search result</title>
</head>
<body>
<br>

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


<center>

<h2>Search Result</h2>
<% int count=((SearchBean)session.getAttribute("sb")).getResult().size();

for(int i=0;i<count;i++)
{

%>

<div style="border: 2px solid yellow; width: 30%;">

<s:form action="follow" name="followform">
<%String fname=((SearchBean)session.getAttribute("sb")).getResult().get(i);
	
%>


<b>User: <i><%= fname %></i></b>
<input type="hidden" name="fname" value="<%= ((LoginSuccessBean)session.getAttribute("lsb")).getUname() %>" />
<input type="hidden" name="uname" value="<%= fname %>" />
<s:submit value="Follow"></s:submit>
</s:form>
</div>
<br>
<%} %>

</center>
</body>
</html>
<%}%>