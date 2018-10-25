<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventaire</title>
        <sj:head jqueryui="true"/>
        <sb:head includeScripts="true" includeScriptsValidation="false"/>
    </head>
    <body>
        <h1 class="text-center mb-5">Inventaire</h1>

        <s:form theme="bootstrap" cssClass="form-horizontal">
            <div class="row">
                <div class="col-md-6">
                    <div class="btn-group btn-group-toggle" role="group" data-toggle="buttons">
                        <label class="btn btn-primary ">
                            <input type="checkbox"  autocomplete="off"> Categorie 1
                        </label>
                        <label class="btn btn-primary ">
                            <input type="checkbox"  autocomplete="off"> Categorie 2
                        </label>
                        <label class="btn btn-primary active">
                            <input type="checkbox" checked autocomplete="off"> Categorie 3
                        </label>
                    </div>
                </div>
                <div class="col-md-6">
                    <s:textfield placeholder="Rechercher..."
                                 inputPrependIcon="search" />
                </div>
            </div>
        </s:form>

        <s:bean name="garderie.model.Article" var="article">
            <s:param name="idArticle" value="'1'"/>
            <s:param name="nom" value="'Mickey'"/>
            <s:param name="quantite" value="'2'"/>
        </s:bean>

        <div class="row">
            <div class="table-responsive">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>#</th>
                        <th>Categorie</th>
                        <th>Libelle</th>
                        <th>Quantite</th>
                        <th>Image</th>
                        <th>Editer</th>
                    </tr>
                    <tr>
                        <td><s:property value="#article.idArticle" /></td>
                        <td><s:property value="#article.nom" /></td>
                        <td><s:property value="#article.quantite" /></td>
                        <td>Ok</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>Peluche</td>
                        <td>Mickey</td>
                        <td>2</td>
                        <td>
                            <img alt="" src="<s:url value='/images/articles/icons8-animation.png'/>" class="img-responsive center-block">
                        </td>
                        <td>
                            <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </button>
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>Jouet</td>
                        <td>Deadpool</td>
                        <td>1</td>
                        <td>
                            <img alt="" src="<s:url value='/images/articles/icons8-deadpool.png'/>" class="img-responsive center-block">
                        </td>
                        <td>
                            <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </button>
                        </td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>Peluche</td>
                        <td>Madagaskar</td>
                        <td>3</td>
                        <td>
                            <img alt="" src="<s:url value='/images/articles/icons8-madagaskar.png'/>" class="img-responsive center-block">
                        </td>
                        <td>
                            <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </button>
                        </td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td>Jouet</td>
                        <td>Saitama</td>
                        <td>1</td>
                        <td>
                            <img alt="" src="<s:url value='/images/articles/icons8-saitama.png'/>" class="img-responsive center-block">
                        </td>
                        <td>
                            <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </button>
                        </td>
                    </tr>
                    <tr>
                        <td>5</td>
                        <td>Masque</td>
                        <td>Walter White</td>
                        <td>2</td>
                        <td>
                            <img alt="" src="<s:url value='/images/articles/icons8-walter_white.png'/>" class="img-responsive center-block">
                        </td>
                        <td>
                            <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </button>
                        </td>
                    </tr>
                </table>
            </div>
        </div>



    </body>
</html>