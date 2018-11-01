<%-- 
    Document   : profile-success
    Created on : 1 nov. 2018, 17:22:03
    Author     : Maryline
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="index.jsp"></jsp:include>  
        <hr>  
        <%@ taglib uri="/struts-tags" prefix="s" %>  

        Welcome to Profile, <s:property value="#session.name"/>  
    </body>
</html>
