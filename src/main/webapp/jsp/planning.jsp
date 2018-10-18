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
        <h1 class="text-center">Planning</h1>
        <div class="row">
            <div class="col-md-6">
                <s:form theme="bootstrap" cssClass="form-horizontal">
                    <s:textfield name="search"
                                 cssClass="input-sm"
                                 placeholder="Rechercher..."/>
                </s:form>
            </div>
        </div>
        <div class="table-responsive">
            <table class="table table-striped table-bordered">
                <tr>
                    <th>#</th>
                    <th>Nom</th>
                    <th>Prenom</th>
                    <th>Groupe</th>
                    <th>Editer</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>Laurence</td>
                    <td>Emma</td>
                    <td>2</td>
                    <td>
                        <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                            <span class="glyphicon glyphicon-pencil"></span>
                        </button>
                    </td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Petrulli</td>
                    <td>Amber</td>
                    <td>1</td>
                    <td>
                        <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                            <span class="glyphicon glyphicon-pencil"></span>
                        </button>
                    </td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Washington</td>
                    <td>Jessica</td>
                    <td>3</td>
                    <td>
                        <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                            <span class="glyphicon glyphicon-pencil"></span>
                        </button>
                    </td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>McDonald</td>
                    <td>Adelaide</td>
                    <td>1</td>
                    <td>
                        <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                            <span class="glyphicon glyphicon-pencil"></span>
                        </button>
                    </td>
                </tr>
                <tr>
                    <td>5</td>
                    <td>McBride</td>
                    <td>Julian</td>
                    <td>2</td>
                    <td>
                        <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                            <span class="glyphicon glyphicon-pencil"></span>
                        </button>
                    </td>
                </tr>
            </table>
        </div>
        <hr class="hr-primary hr-big">


        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
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

    </body>
</html>
