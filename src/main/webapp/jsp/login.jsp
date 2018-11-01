<%-- 
    Document   : login
    Created on : 1 nov. 2018, 18:04:53
    Author     : HP_LOUIS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- Using Struts2 Tags in JSP --%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Page</title>
</head>
<body>
<h3>Welcome User, please login below</h3>
<s:form action="login">
	<s:textfield name="user" label="User Name"></s:textfield>
	<s:textfield name="password" label="Password" type="password"></s:textfield>
	<s:submit value="Login"></s:submit>
</s:form>
</body>
</html>