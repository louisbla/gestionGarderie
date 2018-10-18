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
        <h1 class="text-center">Bienvenue</h1>
        <s:form theme="bootstrap" cssClass="well form-signin">
            <s:textfield placeholder="Email"
                         name="email"
                         type="email"
                         cssClass="input-sm" />

            <s:password placeholder="Mot de passe"
                        name="password"
                        cssClass="input-sm" />
            <div class="form-group">
                <div class="text-center">
                    <s:submit cssClass="btn btn-primary"/>
                </div>
            </div>
        </s:form>

    </body>
</html>