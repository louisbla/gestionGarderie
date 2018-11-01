<%-- 
    Document   : login
    Created on : 1 nov. 2018, 17:16:13
    Author     : Maryline
--%>
<%@ taglib uri="/struts-tags" prefix="s" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <img src="images/garderie2.jpg">
	</div>
        div>
            <h1 style="text-align:center;">Connexion</h1>
	</div>
        <s:form action="login" method="post">  
            <s:textfield name="name" label="Name"></s:textfield>  
            <s:password name="password" label="Password"></s:password>  
            <s:submit value="login"></s:submit>  
        </s:form>  
    </body>
</html>
