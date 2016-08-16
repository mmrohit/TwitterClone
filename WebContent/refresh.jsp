<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page import="Beans.LoginSuccessBean" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
function reLog()
{
	document.form.uname.value='<%= ( (LoginSuccessBean)session.getAttribute("lsb")).getUname() %>';   
	document.form.pass.value='<%= (String)session.getAttribute("pass") %>';    
	document.getElementById('form').submit();
	}
</script>
</head>
<body onload="reLog()">
				<s:form name="form" id="form" action="login" method="post">
					<s:hidden id="uname"  name="uname" key="uname"/>
					<s:hidden id="pass" name="pass" key="pass"></s:hidden>
				</s:form>
	</body>
</html>