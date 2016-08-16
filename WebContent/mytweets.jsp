<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <link TYPE="text/css" REL="stylesheet" HREF= "mytweets.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<%@page import="Beans.MyTweetsBean" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyTweets</title>
</head>
<body>
<%@include file="header.jsp" %>
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
<% MyTweetsBean mtb= (MyTweetsBean)session.getAttribute("mytweets");
int count=mtb.getT_id().size();
for(int i=0;i<count;i++){ %>
<div style="width:30%; border:2px solid black;" >

<form name="mytweets">
<br>
<font style="color:blue; font-size: large;font: bold;"><%=mtb.getMyTweets().get(mtb.getT_id().get(i)) %> <%//Displaying Tweet %></font>
<input type=hidden name="tid" value="<%=mtb.getT_id().get(i) %>"/>
<s:submit action="edittweet" value="Edit Tweet" cssStyle="float:left;"></s:submit> <s:submit value="Delete Tweet" action="deletetweet" cssStyle="float:right;"></s:submit><br>
</form>

<br>
</div>

<% }%>
</center>
</body>
</html>
<%}%>