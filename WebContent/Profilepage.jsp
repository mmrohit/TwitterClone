<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>

<%@page import="Beans.UserDataBean" %>
<%@include file="header.jsp" %>

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



<% UserDataBean udb = (UserDataBean)session.getAttribute("data"); %>




<html>
<head>
<link rel="stylesheet" href="profilepage.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile Info</title>
<script>

function loadFields()
{
	document.update.fname.value= '<%= udb.getFullname() %>';
	document.update.mail.value= '<%= udb.getEmail() %>';
	
	}
function check()
{
	var status=confirm("Are you sure you want to leave");
		if(status == true)
			return true;
		else
			return false;
	}

</script>
</head>

<body onload="loadFields();">
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
<h1>Update Your Profile</h1>
<br><br>

<div style="width:30%;">
<fieldset style ="textalign:center">
<legend><font color= "black"><b>Account Details</b></font></legend>

<s:form name="update" action="update">


<s:textfield label="Full Name" key="fname" name="fname"/>
<input type="hidden" name="uname" value="<%=((LoginSuccessBean)session.getAttribute("lsb")).getUname() %>">
<s:textfield label="Email" key="mail" name="mail"/>
<s:password label="New Password" key="npass"></s:password>
<s:password label="Retype Password" key="rpass"></s:password>
<s:password label="Enter Current Password" key="cpass"/>
<s:submit value="Update Profile"></s:submit>
</s:form>
</fieldset>
</div>
<br><br>
<div style="width:20%;">
<fieldset style ="textalign:center">
<legend><font color= "black"><b>Delete Your Account</b></font></legend>
<s:form action="delete" onsubmit="return check();">
<s:submit value="Delete Account"></s:submit>
</s:form>
</fieldset>
</div>
</center>
</body>
</html>
<% }%>