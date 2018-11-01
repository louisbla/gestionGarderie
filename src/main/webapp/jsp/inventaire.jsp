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

        <s:form theme="bootstrap" cssClass="form-horizontal" action="chercherarticle" method="post">
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
                    <s:textfield placeholder="Rechercher par nom..."
                                 inputPrependIcon="search" name="motCle" />
                </div>

            </div>
        </s:form>

        <div class="row">
            <div class="col-md-6">
                <button class="btn btn-primary mb-3" data-toggle="modal"
                        data-target="#modalCreateArticle">
                    <span class="glyphicon glyphicon-plus"></span>
                    Ajouter
                </button>
            </div>
        </div>

        <div class="row">
            <div class="table-responsive">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>#</th>
                        <th class="d-none">Inventaire</th>
                        <th>Categorie</th>
                        <th>Libelle</th>
                        <th>Quantite</th>
                        <th>Description</th>
                        <th>Image</th>
                        <th>Editer</th>
                    </tr>

                    <s:if test="%{articles.size()>0}">
                        <s:iterator value="articles">
                            <tr>
                                <td><s:property value="idArticle" /></td>
                                <td class="d-none"><s:property value="inventaire.idInventaire" /></td>
                                <td><s:property value="categorie.nom" /></td>
                                <td><s:property value="nom" /></td>
                                <td><s:property value="quantite" /></td>
                                <td><s:property value="description" /></td>
                                <td>
                                    <img alt="" src="<s:property value="photo" />"
                                         class="img-thumbnail img-responsive center-block"
                                         style="width:204px;height:auto;">
                                </td>
                                <td>
                                    <button class="btn btn-primary"
                                            data-toggle="modal" data-id="<s:property value="idArticle" />"
                                            data-categorie="<s:property value="categorie.idCategorie" />"
                                            data-img="<s:property value="photo" />"
                                            data-nom="<s:property value="nom" />"
                                            data-description="<s:property value="description" />"
                                            data-quantite="<s:property value="quantite" />"
                                            data-inventaire="<s:property value="inventaire.idInventaire" />"
                                            data-target="#modalArticle">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                </td>
                            </tr>
                        </s:iterator>
                    </s:if>
                    <s:elseif test="%{articlesTrouves.size()>0}">
                        <s:iterator value="articlesTrouves">
                            <tr>
                                <td><s:property value="idArticle" /></td>
                                <td class="d-none"><s:property value="inventaire.idInventaire" /></td>
                                <td><s:property value="categorie.nom" /></td>
                                <td><s:property value="nom" /></td>
                                <td><s:property value="quantite" /></td>
                                <td><s:property value="description" /></td>
                                <td>
                                    <img alt="" src="<s:property value="photo" />"
                                         class="img-thumbnail img-responsive center-block"
                                         style="width:204px;height:auto;">
                                </td>
                                <td>
                                    <button class="btn btn-primary"
                                            data-toggle="modal" data-id="<s:property value="idArticle" />"
                                            data-categorie="<s:property value="categorie.idCategorie" />"
                                            data-img="<s:property value="photo" />"
                                            data-nom="<s:property value="nom" />"
                                            data-description="<s:property value="description" />"
                                            data-quantite="<s:property value="quantite" />"
                                            data-inventaire="<s:property value="inventaire.idInventaire" />"
                                            data-target="#modalArticle">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                </td>
                            </tr>
                        </s:iterator>
                    </s:elseif>
                    <s:else>
                        Aucun article dans la liste.
                    </s:else>
                </table>
            </div>
        </div>


        <!-- Modal -->
        <div class="modal fade" id="modalArticle" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Edition de l'article</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row text-center">
                            <h3></h3>
                            <div class="col-md-6 col-md-offset-3">
                                <img id="article-img" src="" class="img-thumbnail center-block" alt="Responsive image">
                            </div>
                        </div>

                        <s:form theme="bootstrap" cssClass="form-vertical" action="updatearticle" method="post">
                            <s:textfield
                                name="article.idArticle"
                                id="article-id"
                                cssClass="invisible"
                                elementCssClass=""
                                labelCssClass=""/>

                            <s:textfield
                                name="article.photo"
                                id="article-photo"
                                cssClass="invisible"
                                elementCssClass=""
                                labelCssClass=""/>

                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group ">
                                        <label class=" control-label" for="article-nom">Nom</label>
                                        <div class=" controls">
                                            <input type="text" name="article.nom" value="" id="article-nom" class="form-control input-sm" required>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <s:select
                                        label="Categorie"
                                        name="article.categorie.idCategorie"
                                        list="categories"
                                        listKey="idCategorie"
                                        listValue="nom"
                                        id="categorie"
                                        cssClass="input-sm"
                                        elementCssClass=""
                                        labelCssClass=""/>
                                </div>

                                <div class="col-md-3">
                                    <s:textfield type="number"
                                                 label="Quantite"
                                                 name="article.quantite"
                                                 id="quantite"
                                                 min="0" max="100"/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group ">
                                        <label class="  control-label" for="description">Description</label>
                                        <div class="  controls">
                                            <textarea name="article.description" cols="20" rows="3" id="description" class="form-control noresize" required>
                                            </textarea>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-9">
                                    <s:file name="" label="Photo"/>
                                </div>
                                <div class="col-md-3">
                                    <s:select
                                        label="Inventaire"
                                        name="article.inventaire.idInventaire"
                                        list="inventaires"
                                        listKey="idInventaire"
                                        listValue="idInventaire"
                                        id="inventaire"
                                        cssClass="input-sm"
                                        elementCssClass=""
                                        labelCssClass=""/>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-danger" formaction="deletearticle">
                                <span class="glyphicon glyphicon-trash"></span>
                            </button>
                            <button type="submit" class="btn btn-primary">Valider</button>
                        </div>
                    </s:form>
                </div>
            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="modalCreateArticle" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Nouvel article</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row text-center">
                            <h3></h3>
                        </div>

                        <s:form theme="bootstrap" cssClass="form-vertical" action="createarticle" method="post">
                            <s:textfield
                                name="article.idArticle"
                                id="article-id"
                                cssClass="invisible"
                                elementCssClass=""
                                labelCssClass=""/>

                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group ">
                                        <label class=" control-label" for="article-nom">Nom</label>
                                        <div class=" controls">
                                            <input type="text" name="article.nom" value="" id="article-nom" class="form-control input-sm" required>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <s:select
                                        label="Categorie"
                                        name="article.categorie.idCategorie"
                                        list="categories"
                                        listKey="idCategorie"
                                        listValue="nom"
                                        id="categorie"
                                        cssClass="input-sm"
                                        elementCssClass=""
                                        labelCssClass=""/>
                                </div>

                                <div class="col-md-3">
                                    <s:textfield type="number"
                                                 label="Quantite"
                                                 name="article.quantite"
                                                 id="quantite"
                                                 value="1"
                                                 min="0" max="100"/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group ">
                                        <label class="  control-label" for="description">Description</label>
                                        <div class="  controls">
                                            <textarea name="article.description" cols="20" rows="3"
                                                      id="description" class="form-control noresize" required></textarea>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-9">
                                    <s:file name="article.photo" label="Photo"/>
                                </div>
                                <div class="col-md-3">
                                    <s:select
                                        label="Inventaire"
                                        name="article.inventaire.idInventaire"
                                        list="inventaires"
                                        listKey="idInventaire"
                                        listValue="idInventaire"
                                        id="inventaire"
                                        cssClass="input-sm"
                                        elementCssClass=""
                                        labelCssClass=""/>
                                </div>
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

</body>
<script>
    $('#modalArticle').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget); // Button that triggered the modal
        var categorie = button.data('categorie');
        var img = button.data('img');
        var nom = button.data('nom');
        var description = button.data('description');
        var id = button.data('id');
        var quantite = button.data('quantite');
        var inventaire = button.data('inventaire');
        var modal = $(this);
        modal.find('.modal-body h3').text(nom);
        $(".modal-body #article-id").val(id);
        $(".modal-body #article-nom").val(nom);
        $(".modal-body #description").val(description);
        $(".modal-body #quantite").val(quantite);
        $(".modal-body #categorie").val(categorie);
        $(".modal-body #inventaire").val(inventaire);
        $(".modal-body #article-img").attr("src", img);
        $(".modal-body #article-photo").val(img);
    });
</script>
</html>