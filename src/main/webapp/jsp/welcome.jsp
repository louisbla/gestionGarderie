<%@page import="java.sql.Connection"%>
<%@page import="garderie.db.DBManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <sj:head jqueryui="true"/>
        <sb:head includeScripts="true" includeScriptsValidation="false"/>
    </head>
    <body>
        <div class="jumbotron">
            <h1 class="text-center">Bienvenue !</h1>
            <img alt="garderie" class="img-responsive" src="<s:url value='/images/garderie.jpg' />">
            <p class="lead text-center p-5">Veuillez-vous connecter pour accéder aux fonctionnalités de l'application.</p>
        </div>

        <%
            Connection connection = DBManager.getInstance();

            if (connection == null) {
                out.println("connection failed");
            } else {
                out.println("connection succeded");
            }
        %>
    </body>
</html>