<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=ISO-8859-1">
<title>Welcome To Twitter</title>
<link TYPE="text/css" REL="stylesheet" HREF="login.css">
<script>


function changeHashOnLoad() {
    window.location.href += "#";
    setTimeout("changeHashAgain()", "50"); 
}

function changeHashAgain() {
 window.location.href += "1";
}

var storedHash = window.location.hash;
window.setInterval(function () {
   if (window.location.hash != storedHash) {
        window.location.hash = storedHash;
   }
}, 50);


</script>

</head>
<% if (request.getSession(false)==null)
request.getSession();
else
{
%>

<body onload="changeHashOnLoad();">

					

	<center>
		<img class="head" src="Images/login header.png"/>
	
		

			<fieldset>
			
			<legend align="left" >
				<b>User Login</b>	
				</legend>
					<s:form action="login" method="post">
					<s:textfield label="Username" key="uname"></s:textfield>
					<s:password label="Password" key="pass"></s:password>
					<s:submit value="Sign In"></s:submit>
					</s:form>
					<br>				
					<s:div>NewUser? &nbsp;&nbsp; <a HREF='<s:url action="registerpage"/>'>SignUp</a></s:div>
			
			</fieldset>
		
			</center>
</body>
</html>
<%} %>
