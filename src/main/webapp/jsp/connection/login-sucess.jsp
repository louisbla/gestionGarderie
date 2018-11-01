<%-- 
    Document   : login-sucess
    Created on : 1 nov. 2018, 17:19:52
    Author     : Maryline
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>  

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="index.jsp"></jsp:include>  
        <hr>  
        
  
        Welcome, <s:property value="#session.name"/>  
    </body>
</html>
