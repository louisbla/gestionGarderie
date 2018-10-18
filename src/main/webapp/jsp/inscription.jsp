<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscription</title>
        <sj:head jqueryui="true"/>
        <sb:head includeScripts="true" includeScriptsValidation="false"/>
    </head>
    <body>
        <h1 class="text-center">Inscription</h1>

        <s:form action="customlayout" enctype="multipart/form-data" theme="bootstrap" cssClass="form-vertical well"
                label="Nouvel enfant">
            <div class="row">
                <div class="col-md-6">
                    <s:textfield
                        label="Nom"
                        name="name"
                        cssClass="input-sm"
                        elementCssClass=""
                        labelCssClass=""
                        tooltip="Entrez le nom"/>
                </div>
                <div class="col-md-6">
                    <s:textfield
                        label="Prenom"
                        name="name"
                        cssClass="input-sm"
                        elementCssClass=""
                        labelCssClass=""
                        tooltip="Entrez le prenom"/>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <s:select
                        label="Sexe"
                        name="genger"
                        list="{'garcon', 'fille'}"
                        cssClass="input-sm"
                        elementCssClass=""
                        labelCssClass=""
                        />
                </div>
                <div class="col-md-6">
                    <sj:datepicker
                        id="datepicker"
                        parentTheme="bootstrap"
                        label="Date de naissance"
                        cssClass="form-control input-sm"
                        elementCssClass=""
                        showOn="focus"
                        inputAppendIcon="calendar"
                        changeMonth="true"
                        changeYear="true"
                        />
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <s:textfield
                        label="Adresse 1"
                        name="adresse1"
                        cssClass="input-xxlarge"
                        tooltip=""/>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <s:textfield
                        label="Adresse 2"
                        name="adresse2"
                        cssClass="input-xxlarge"
                        tooltip=""/>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <s:textfield
                        label="Ville"
                        name="ville"
                        cssClass="input-sm"/>
                </div>
                <div class="col-md-6">
                    <s:textfield
                        label="Code postal"
                        name="codepostal"
                        cssClass="input-sm"/>
                </div>
            </div>
        </s:form>
        <br>
        <hr>
        <div class="row">
            <div class="col-md-6">
                <s:form action="customlayout" enctype="multipart/form-data" theme="bootstrap" cssClass="form-vertical well"
                        label="Parent 1">
                    <div class="row">
                        <div class="col-md-6">
                            <s:textfield
                                label="Nom"
                                name="name"
                                cssClass="input-sm"
                                elementCssClass=""
                                labelCssClass=""
                                tooltip="Entrez le nom"/>
                        </div>
                        <div class="col-md-6">
                            <s:textfield
                                label="Prenom"
                                name="name"
                                cssClass="input-sm"
                                elementCssClass=""
                                labelCssClass=""
                                tooltip="Entrez le prenom"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <s:select
                                label="Sexe"
                                name="genger"
                                list="{'masculin', 'feminin'}"
                                cssClass="input-xxlarge"
                                elementCssClass=""
                                labelCssClass=""
                                />
                        </div>
                        <div class="col-md-6">
                            <sj:datepicker
                                id="datepicker_parent1"
                                parentTheme="bootstrap"
                                label="Date de naissance"
                                cssClass="form-control input-xxlarge"
                                elementCssClass=""
                                showOn="focus"
                                inputAppendIcon="calendar"
                                changeMonth="true"
                                changeYear="true"
                                />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <s:textfield
                                label="Adresse 1"
                                name="adresse1"
                                cssClass="input-xxlarge"
                                tooltip=""/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <s:textfield
                                label="Adresse 2"
                                name="adresse2"
                                cssClass="input-xxlarge"
                                tooltip=""/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <s:textfield
                                label="Ville"
                                name="ville"
                                cssClass="input-sm"/>
                        </div>
                        <div class="col-md-6">
                            <s:textfield
                                label="Code postal"
                                name="codepostal"
                                cssClass="input-sm"/>
                        </div>
                    </div>
                </s:form>
            </div>
            <div class="col-md-6">
                <s:form action="customlayout" enctype="multipart/form-data" theme="bootstrap" cssClass="form-vertical well"
                        label="Parent 2">
                    <div class="row">
                        <div class="col-md-6">
                            <s:textfield
                                label="Nom"
                                name="name"
                                cssClass="input-sm"
                                elementCssClass=""
                                labelCssClass=""
                                tooltip="Entrez le nom"/>
                        </div>
                        <div class="col-md-6">
                            <s:textfield
                                label="Prenom"
                                name="name"
                                cssClass="input-sm"
                                elementCssClass=""
                                labelCssClass=""
                                tooltip="Entrez le prenom"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <s:select
                                label="Sexe"
                                name="genger"
                                list="{'masculin', 'feminin'}"
                                cssClass="input-sm"
                                elementCssClass=""
                                labelCssClass=""
                                />
                        </div>
                        <div class="col-md-6">
                            <sj:datepicker
                                id="datepicker_parent2"
                                parentTheme="bootstrap"
                                label="Date de naissance"
                                cssClass="form-control input-sm"
                                elementCssClass=""
                                showOn="focus"
                                inputAppendIcon="calendar"
                                changeMonth="true"
                                changeYear="true"
                                />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <s:textfield
                                label="Adresse 1"
                                name="adresse1"
                                cssClass="input-xxlarge"
                                tooltip=""/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <s:textfield
                                label="Adresse 2"
                                name="adresse2"
                                cssClass="input-xxlarge"
                                tooltip=""/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <s:textfield
                                label="Ville"
                                name="ville"
                                cssClass="input-sm"/>
                        </div>
                        <div class="col-md-6">
                            <s:textfield
                                label="Code postal"
                                name="codepostal"
                                cssClass="input-sm"/>
                        </div>
                    </div>
                </s:form>
            </div>
        </div>
        <h3 class="text-center">Personnes de confiance</h3>
        <div class="row text-center">
            <div class="col-md-12">
                <i class="fas fa-user-plus"> </i> <button id="confiancebtn" class="btn btn-primary m-4">Ajouter une personne</button>
                <div id="confiance" class="collapse in">
                    <s:form action="customlayout" enctype="multipart/form-data" theme="bootstrap" cssClass="form-vertical well"
                            label="Personne de confiance">
                        <div class="row">
                            <div class="col-md-6">
                                <s:textfield
                                    label="Nom"
                                    name="name"
                                    cssClass="input-sm"
                                    elementCssClass=""
                                    labelCssClass=""
                                    tooltip="Entrez le nom"/>
                            </div>
                            <div class="col-md-6">
                                <s:textfield
                                    label="Prenom"
                                    name="name"
                                    cssClass="input-sm"
                                    elementCssClass=""
                                    labelCssClass=""
                                    tooltip="Entrez le prenom"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <s:select
                                    label="Sexe"
                                    name="genger"
                                    list="{'masculin', 'feminin'}"
                                    cssClass="input-xxlarge"
                                    elementCssClass=""
                                    labelCssClass=""
                                    />
                            </div>
                            <div class="col-md-6">
                                <sj:datepicker
                                    id="datepicker_parent1"
                                    parentTheme="bootstrap"
                                    label="Date de naissance"
                                    cssClass="form-control input-xxlarge"
                                    elementCssClass=""
                                    showOn="focus"
                                    inputAppendIcon="calendar"
                                    changeMonth="true"
                                    changeYear="true"
                                    />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <s:textfield
                                    label="Adresse 1"
                                    name="adresse1"
                                    cssClass="input-xxlarge"
                                    tooltip=""/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <s:textfield
                                    label="Adresse 2"
                                    name="adresse2"
                                    cssClass="input-xxlarge"
                                    tooltip=""/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <s:textfield
                                    label="Ville"
                                    name="ville"
                                    cssClass="input-sm"/>
                            </div>
                            <div class="col-md-6">
                                <s:textfield
                                    label="Code postal"
                                    name="codepostal"
                                    cssClass="input-sm"/>
                            </div>
                        </div>
                    </s:form>
                </div>

            </div>
        </div>
        <br>
        <h3 class="text-center">Maladies et traitements</h3>
        <div class="row text-center">
            <div class="col-md-12">
                <i class="fas fa-medkit">   </i> <button id="maladiebtn" class="btn btn-primary m-4">Ajouter une maladie</button>
                <div id="maladie" class="collapse in">
                    <s:form action="customlayout" enctype="multipart/form-data" theme="bootstrap" cssClass="form-vertical well"
                            label="Maladie">
                        <div class="row">
                            <div class="col-md-6">
                                <s:textfield
                                    label="Nom"
                                    name="name"
                                    cssClass="input-sm"
                                    elementCssClass=""
                                    labelCssClass=""
                                    tooltip="Entrez le nom"/>
                            </div>
                            <div class="col-md-6">
                                <s:textfield
                                    label="Prenom"
                                    name="name"
                                    cssClass="input-sm"
                                    elementCssClass=""
                                    labelCssClass=""
                                    tooltip="Entrez le prenom"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <s:select
                                    label="Sexe"
                                    name="genger"
                                    list="{'masculin', 'feminin'}"
                                    cssClass="input-xxlarge"
                                    elementCssClass=""
                                    labelCssClass=""
                                    />
                            </div>
                            <div class="col-md-6">
                                <sj:datepicker
                                    id="datepicker_parent1"
                                    parentTheme="bootstrap"
                                    label="Date de naissance"
                                    cssClass="form-control input-xxlarge"
                                    elementCssClass=""
                                    showOn="focus"
                                    inputAppendIcon="calendar"
                                    changeMonth="true"
                                    changeYear="true"
                                    />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <s:textfield
                                    label="Adresse 1"
                                    name="adresse1"
                                    cssClass="input-xxlarge"
                                    tooltip=""/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <s:textfield
                                    label="Adresse 2"
                                    name="adresse2"
                                    cssClass="input-xxlarge"
                                    tooltip=""/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <s:textfield
                                    label="Ville"
                                    name="ville"
                                    cssClass="input-sm"/>
                            </div>
                            <div class="col-md-6">
                                <s:textfield
                                    label="Code postal"
                                    name="codepostal"
                                    cssClass="input-sm"/>
                            </div>
                        </div>
                    </s:form>
                </div>

            </div>
        </div>

        <script type="text/javascript">
            $(document).ready(function () {
                $(".collapse").collapse();
                $("#confiancebtn").click(function () {
                    $('#confiance').collapse('toggle')
                });
                $("#maladiebtn").click(function () {
                    $('#maladie').collapse('toggle')
                });
            });
        </script>
    </body>
</html>
