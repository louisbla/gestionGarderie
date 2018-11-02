<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<nav class="navbar navbar-default navbar-fixed-top" id="top-navbar">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="hamburger is-closed" data-toggle="offcanvas">
                <span class="hamb-top"></span>
                <span class="hamb-middle"></span>
                <span class="hamb-bottom"></span>
            </button>
        </div>

        <div class="collapse navbar-collapse" id="navbar-main">

            <s:form action="loginprocess" theme="bootstrap" cssClass="navbar-form navbar-right">
                <s:textfield placeholder="Identifiant" name="compteUser.login"
                             cssClass="input-sm" />
                <s:textfield placeholder="Mot de passe" name="compteUser.mdp"
                             cssClass="input-sm" />
                <button type="submit" class="btn btn-success">Se connecter</button>
            </s:form>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
