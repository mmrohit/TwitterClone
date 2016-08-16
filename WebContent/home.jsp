<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ page import="Beans.LoginSuccessBean"  %>
<%@ page import="Beans.HomeTweetBean"  %>
<% if(session.getAttribute("pass")!= null)
{
session.removeAttribute("pass");
}%>

<!-- LOGIN CHECKER  -->
<%if(((LoginSuccessBean)session.getAttribute("lsb"))==null)
{%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="home.css">
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

<!-- LOGIN Success  -->




<html>
<head>
<link rel="stylesheet" href="home.css">
<sx:head/>
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


<br>
<br>


<center>

<div style="witdh:40%;  ">

<sx:div  autoStart="true" href="hometweets.action"  updateFreq="4000" cssStyle="width:50%;border: 2px solid black;" showErrorTransportText="false">
<%
int tweets=((HomeTweetBean)session.getAttribute("htb")).getUname().size();

for(int i=0;i<tweets;i++)
{

if(  ((HomeTweetBean)session.getAttribute("htb")).getUname().get(i).equals(((LoginSuccessBean)session.getAttribute("lsb")).getUname()) )
	{ %>
	
	<font color="blue" >@<%= ((HomeTweetBean)session.getAttribute("htb")).getUname().get(i) %></font>  &nbsp;&nbsp;&nbsp;<b><%= ((HomeTweetBean)session.getAttribute("htb")).getMessage().get(i) %></b> &nbsp;&nbsp;&nbsp;<font color="green"><%= ((HomeTweetBean)session.getAttribute("htb")).getTimestamp().get(i) %></font><br>
<%}

else

{%>

<font color="#660033">@<%= ((HomeTweetBean)session.getAttribute("htb")).getUname().get(i) %></font>  &nbsp;&nbsp;&nbsp;<b><%= ((HomeTweetBean)session.getAttribute("htb")).getMessage().get(i) %></b> &nbsp;&nbsp;&nbsp;<font color="green"><%= ((HomeTweetBean)session.getAttribute("htb")).getTimestamp().get(i) %></font><br>
<%} %>

<%} %>
</sx:div>
</div>
</center>
</body>
</html>

<% }%>