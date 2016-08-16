<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Now</title>

<link rel="stylesheet" href="login.css"/>
</head>


<body>
<center>

<img class="head" src="Images/login header.png"/>
	

<div>
<fieldset style ="textalign:center">
<legend><font color= "black"><b>User Register</b></font></legend>
<s:form action="register" method="post">
<s:textfield label="Username" key="uname" ></s:textfield>
<s:password label="Password" key="pass"></s:password>
<s:textfield label="Fullname" key="fname"></s:textfield>
<s:textfield label="Email" key="mail"></s:textfield>
<s:submit></s:submit>
</s:form>
</fieldset>
</div>
</center>
</body>
</html>