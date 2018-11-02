<%@page import="garderie.dao.ActiviteDAO"%>
<%@page import="garderie.db.BDDManagerMySQL"%>
<%@page import="garderie.db.FactoryBDDManagerInstance"%>
<%@page import="garderie.db.FactoryBDDManager"%>
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

        <s:if test="hasActionErrors()">
            <div class="errors">
                <s:actionerror theme="bootstrap"/>
            </div>
        </s:if>
        <s:if test="hasActionMessages()">
            <div class="welcome">
                <s:actionmessage theme="bootstrap"/>
            </div>
        </s:if>
        <div class="jumbotron">
            <h1 class="text-center">Bienvenue !</h1>
            <img alt="garderie" class="img-responsive" src="<s:url value='/images/garderie.jpg' />">
            <s:if test="#session.user">

            </s:if>
            <s:else>
                <p class="lead text-center p-5">Veuillez-vous connecter pour accéder aux fonctionnalités de l'application.</p>
            </s:else>
        </div>
    </body>
</html>