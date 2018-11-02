<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mon compte</title>
        <sj:head jqueryui="true"/>
        <sb:head includeScripts="true" includeScriptsValidation="false"/>
    </head>
    <body>
        <s:if test="#session.user">
            <h1 class="mb-5">Mon compte</h1>

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

            <s:form action="editercompte" enctype="multipart/form-data"
                    theme="bootstrap" cssClass="form-vertical well mt-2"
                    label="Editer">
                <div class="row">
                    <div class="col-md-4">
                        <s:textfield
                            label="Nom"
                            name="nom"
                            cssClass="input-sm"
                            elementCssClass=""
                            labelCssClass=""
                            value="%{#session.user.personne.nom}"
                            tooltip="Entrez le nom"/>
                    </div>
                    <div class="col-md-4">
                        <s:textfield
                            label="Prenom"
                            name="prenom"
                            cssClass="input-sm"
                            elementCssClass=""
                            labelCssClass=""
                            value="%{#session.user.personne.prenom}"
                            tooltip="Entrez le prenom"/>
                    </div>
                    <div class="col-md-4">
                        <s:select
                            label="Sexe"
                            name="sexe"
                            list="{'masculin', 'feminin', 'autre'}"
                            cssClass="input-sm"
                            elementCssClass=""
                            labelCssClass=""
                            value="%{#session.user.personne.sexe}"
                            />
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <s:textfield
                            label="Identifiant"
                            name="login"
                            cssClass="input-sm"
                            elementCssClass=""
                            labelCssClass=""
                            value="%{#session.user.login}"
                            tooltip="Entrez le nouveau login"/>
                    </div>
                    <div class="col-md-6">
                        <s:password
                            label="Mot de passe"
                            name="mdp"
                            cssClass="input-sm"
                            elementCssClass=""
                            labelCssClass=""
                            showPassword="true"
                            value="%{#session.user.mdp}"
                            tooltip="Entrez le nouveau mot de passe"/>
                    </div>
                </div>

                <button type="submit" class="btn btn-primary">Valider</button>
            </s:form>

        </s:if>
        <s:else>
            <div class="alert alert-danger text-center">
                <strong>Oops!</strong> Vous n'avez pas les droits pour accéder à cette page.
            </div>
        </s:else>
    </body>
</html>
