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
            <s:if test="#session.user">
                <div class="navbar-form navbar-right">
                    <span class="glyphicon glyphicon-user"></span> 
                    <strong><s:property value="#session.user.personne.prenom" /> <s:property value="#session.user.personne.nom"  /></strong>
                    <s:a action="logout" type="submit" class="btn btn-success">Se déconnecter</s:a>
                    </div>

            </s:if>
            <s:else>
                <s:form action="loginprocess" theme="bootstrap" cssClass="navbar-form navbar-right">
                    <s:textfield placeholder="Identifiant" name="login"
                                 cssClass="input-sm" />
                    <s:password placeholder="Mot de passe" name="mdp"
                                cssClass="input-sm" />

                    <button type="submit" class="btn btn-success">Se connecter</button>
                </s:form>
            </s:else>

        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
