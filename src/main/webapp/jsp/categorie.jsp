<%--
    Document   : categorie
    Created on : 31 oct. 2018, 02:21:54
    Author     : Katsuo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categories</title>
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
        <s:if test="#session.user">
            <h1 class="text-center mb-5">Categories</h1>
            <div class="row">
                <div class="col-md-6">
                    <button class="btn btn-primary" data-toggle="modal"
                            data-target="#modalCreateCategorie">
                        <span class="glyphicon glyphicon-plus"></span>
                        Ajouter
                    </button>
                </div>
                <div class="col-md-6">
                    <s:form theme="bootstrap" cssClass="form-horizontal ">
                        <s:textfield placeholder="Rechercher..."
                                     inputPrependIcon="search" />
                    </s:form>
                </div>
            </div>
            <div class="row">
                <s:if test="%{categories.size()>0}">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered">
                            <tr>
                                <th>#</th>
                                <th>Libelle</th>
                                <th>Editer</th>
                            </tr>


                            <s:iterator value="categories" status="incr">
                                <tr>
                                    <td class="d-none"><s:property value="idCategorie" /></td>
                                    <td><s:property value="%{#incr.index+1}" /></td>
                                    <td><s:property value="nom" /></td>
                                    <td>
                                        <button class="btn btn-primary"
                                                data-toggle="modal" data-id="<s:property value="idCategorie" />"
                                                data-nom="<s:property value="nom" />"
                                                data-target="#modalCategorie">
                                            <span class="glyphicon glyphicon-pencil"></span>
                                        </button>
                                    </td>
                                </tr>
                            </s:iterator>


                        </table>
                    </s:if>
                    <s:else>
                        Aucune categorie dans la liste.
                    </s:else>
                </div>
            </div>


            <!-- Modal -->
            <div class="modal fade" id="modalCategorie" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">Edition de la categorie</h4>
                        </div>
                        <div class="modal-body">
                            <div class="row text-center">
                                <h3></h3>
                            </div>

                            <s:form theme="bootstrap" cssClass="form-vertical" action="editercategorie" method="post">
                                <div class="row">
                                    <div class="col-md-12">
                                        <s:textfield
                                            label="Nom"
                                            name="categorieArticle.nom"
                                            id="categorie-nom"
                                            cssClass="input-sm"
                                            elementCssClass=""
                                            labelCssClass=""/>
                                        <s:textfield
                                            name="categorieArticle.idCategorie"
                                            id="categorie-id"
                                            cssClass="invisible"
                                            elementCssClass=""
                                            labelCssClass=""/>

                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-danger" formaction="deletecategorie">Annuler</button>
                                <button type="submit" class="btn btn-primary">Valider</button>
                            </div>
                        </s:form>
                    </div>
                </div>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="modalCreateCategorie" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">Nouvelle categorie</h4>
                        </div>
                        <div class="modal-body">
                            <div class="row text-center">
                                <h3></h3>
                            </div>

                            <s:form theme="bootstrap" cssClass="form-vertical" action="createcategorie" method="post">
                                <div class="row">
                                    <div class="col-md-12">
                                        <s:textfield
                                            label="Nom"
                                            name="categorieArticle.nom"
                                            id="categorie-nom"
                                            cssClass="input-sm"
                                            elementCssClass=""
                                            labelCssClass=""/>
                                        <s:textfield
                                            name="categorieArticle.idCategorie"
                                            id="categorie-id"
                                            cssClass="invisible"
                                            elementCssClass=""
                                            labelCssClass=""/>

                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-danger" data-dismiss="modal">Annuler</button>
                                <button type="submit" class="btn btn-primary">Valider</button>
                            </div>
                        </s:form>
                    </div>
                </div>
            </div>
        </s:if>
        <s:else>
            <div class="alert alert-danger text-center">
                <strong>Oops!</strong> Vous n'avez pas les droits pour accéder à cette page.
            </div>
        </s:else>

    </body>
    <script>
        $('#modalCategorie').on('show.bs.modal', function (event) {
            var button = $(event.relatedTarget); // Button that triggered the modal
            var nom = button.data('nom');
            var id = button.data('id');
            var modal = $(this);
            modal.find('.modal-body h3').text(nom);
            modal.find(".modal-body #categorie-nom").val(nom);
            $(".modal-body #categorie-id").val(id);

        });
    </script>
</html>
