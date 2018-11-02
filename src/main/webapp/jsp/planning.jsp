<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Planning</title>
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
            <s:if test="#session.user.privilege==true">
                <h1 class="text-center">Planning</h1>
                <s:form theme="bootstrap" cssClass="form-horizontal" action="chercheremploye" method="post">
                    <div class="row">
                        <div class="col-md-9">
                            <s:textfield placeholder="Rechercher par Nom ou prenom..."
                                         inputPrependIcon="search" name="motCle"
                                         cssClass="input-xxlarge"/>
                        </div>
                    </div>
                </s:form>

                <div class="row justify-content-md-center">

                    <div class="col-md-6">
                        <button class="btn btn-primary mb-3" data-toggle="modal"
                                data-target="#modalCreateEmploye">
                            <span class="glyphicon glyphicon-plus"></span>
                            Ajouter
                        </button>
                    </div>
                </div>
                <div class="table-responsive">
                    <s:if test="%{employes.size()>0}">


                        <table class="table table-striped table-bordered">
                            <tr>
                                <th>#</th>
                                <th>Nom</th>
                                <th>Prenom</th>
                                <th>Poste</th>
                                <th>Telephone</th>
                                <th>Editer</th>
                            </tr>
                            <s:iterator value="employes" status="incr">
                                <tr>
                                    <td><s:property value="%{#incr.index+1}"/></td>
                                    <td><s:property value="nom" /></td>
                                    <td><s:property value="prenom" /></td>
                                    <td><s:property value="poste" /></td>
                                    <td>
                                        <s:property value="numTel" />
                                    </td>
                                    <td>
                                        <s:form>
                                            <s:textfield name="idEmploye"
                                                         cssClass="d-none"/>

                                            <button class="btn btn-primary"
                                                    type="submit">
                                                <span class="glyphicon glyphicon-eye-open"></span>
                                            </button>
                                        </s:form>
                                    </td>
                                </tr>
                            </s:iterator>
                        </table>
                    </s:if>
                    <s:elseif test="%{employesTrouves.size()>0}">


                        <table class="table table-striped table-bordered">
                            <tr>
                                <th>#</th>
                                <th>Nom</th>
                                <th>Prenom</th>
                                <th>Poste</th>
                                <th>Telephone</th>
                                <th>Editer</th>
                            </tr>
                            <s:iterator value="employesTrouves" status="incr">
                                <tr>
                                    <td><s:property value="%{#incr.index+1}"/></td>
                                    <td><s:property value="nom" /></td>
                                    <td><s:property value="prenom" /></td>
                                    <td><s:property value="poste" /></td>
                                    <td>
                                        <s:property value="numTel" />
                                    </td>
                                    <td>
                                        <s:form>
                                            <s:textfield name="idEmploye"
                                                         cssClass="d-none"/>

                                            <button class="btn btn-primary"
                                                    type="submit">
                                                <span class="glyphicon glyphicon-eye-open"></span>
                                            </button>
                                        </s:form>
                                    </td>
                                </tr>
                            </s:iterator>
                        </table>
                    </s:elseif>
                    <s:else>
                        Aucun employé trouvé.
                    </s:else>
                </div>
                <hr class="hr-primary hr-big">

                <!-- Modal -->
                <div class="modal fade" id="modalCreateEmploye" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">Edition du planning</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row text-center">
                                    <h3>Nom Prenom</h3>
                                    <div class="col-md-6 col-md-offset-3">
                                        <img src="images/icons8-pug.png" class="img-responsive center-block" alt="Responsive image">
                                    </div>
                                </div>

                                <s:form theme="bootstrap" cssClass="form-vertical">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <sj:datepicker id="datepicker"
                                                           parentTheme="bootstrap"
                                                           label="Date de debut"
                                                           cssClass="form-control input-sm"
                                                           elementCssClass=""
                                                           showOn="focus"
                                                           inputAppendIcon="calendar" />
                                        </div>
                                        <div class="col-md-6">
                                            <sj:datepicker id="datepicker2"
                                                           parentTheme="bootstrap"
                                                           label="Date de fin"
                                                           cssClass="form-control input-sm"
                                                           elementCssClass=""
                                                           showOn="focus"
                                                           inputAppendIcon="calendar" />
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <s:select
                                                label="Groupe"
                                                name="groupe"
                                                list="{'Groupe 1', 'Groupe 2', 'Groupe 3'}"
                                                cssClass="input-sm"
                                                elementCssClass=""
                                                labelCssClass=""
                                                />
                                        </div>
                                    </div>

                                </s:form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">Save changes</button>
                            </div>
                        </div>
                    </div>
                </div>


                <!-- Modal -->
                <div class="modal fade" id="modalCreateEmploye" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">Nouvel employe</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row text-center">
                                    <h3>Nom Prenom</h3>
                                    <div class="col-md-6 col-md-offset-3">
                                        <img src="images/icons8-pug.png" class="img-responsive center-block" alt="Responsive image">
                                    </div>
                                </div>

                                <s:form theme="bootstrap" cssClass="form-vertical">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <sj:datepicker id="datepicker"
                                                           parentTheme="bootstrap"
                                                           label="Date de debut"
                                                           cssClass="form-control input-sm"
                                                           elementCssClass=""
                                                           showOn="focus"
                                                           inputAppendIcon="calendar" />
                                        </div>
                                        <div class="col-md-6">
                                            <sj:datepicker id="datepicker2"
                                                           parentTheme="bootstrap"
                                                           label="Date de fin"
                                                           cssClass="form-control input-sm"
                                                           elementCssClass=""
                                                           showOn="focus"
                                                           inputAppendIcon="calendar" />
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <s:select
                                                label="Groupe"
                                                name="groupe"
                                                list="{'Groupe 1', 'Groupe 2', 'Groupe 3'}"
                                                cssClass="input-sm"
                                                elementCssClass=""
                                                labelCssClass=""
                                                />
                                        </div>
                                    </div>

                                </s:form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">Save changes</button>
                            </div>
                        </div>
                    </div>
                </div>
            </s:if>
            <s:else>
                <div class="alert alert-danger text-center">
                    <strong>Oops!</strong> Vous n'avez pas les droits pour accéder à cette page.
                </div>
            </s:else>

        </s:if>
        <s:else>
            <div class="alert alert-danger text-center">
                <strong>Oops!</strong> Vous n'avez pas les droits pour accéder à cette page.
            </div>
        </s:else>
    </body>
</html>
