<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Facturation</title>
        <sj:head jqueryui="true"/>
        <sb:head includeScripts="true" includeScriptsValidation="false"/>
    </head>
    <body>
        <h1 class="text-center mb-5">Facturation</h1>

        <div class="row">
            <div class="table-responsive">


                <s:if test="%{factures.size()>0}">
                    <table class="table table-striped table-bordered">
                        <tr>
                            <th>#</th>
                            <th>Date d'emission</th>
                            <th>Date de paiement</th>
                            <th>Montant TTC</th>
                            <th>Statut</th>
                            <th>Voir</th>
                        </tr>
                        <s:iterator value="factures" status="incr">
                            <tr>
                                <td><s:property value="%{#incr.index+1}"/></td>
                                <td><s:property value="dateEmission" /></td>
                                <td><s:property value="datePaiement" /></td>
                                <td><s:property value="montantTTC" /></td>
                                <td>
                                    <s:property value="statut.toString()" /></td>
                                <td>
                                    <s:form action="afficherdetailsfacture" method="post">
                                        <s:textfield name="idFacture"
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

                <s:elseif test="%{lignesFacture.size()>0}">
                    <table class="table table-striped table-bordered">
                        <tr>
                            <th>#</th>
                            <th>Objet</th>
                            <th>Quantite</th>
                            <th>Total HT</th>
                            <th>TVA</th>
                            <th>Total TTC</th>
                        </tr>
                        <s:iterator value="lignesFacture" status="incr">
                            <tr>
                                <td><s:property value="%{#incr.index+1}"/></td>
                                <td><s:property value="objetFacturable.nom" /></td>
                                <td><s:property value="quantite" /></td>
                                <td><s:property value="totalHT" /> $CA</td>
                                <td><s:property value="objetFacturable.tva.montant" />%</td>
                                <td><s:property value="totalTTC" /> $CA</td>
                            </tr>
                        </s:iterator>
                    </table>

                </s:elseif>

                <s:else>
                    Aucune facture dans la liste.
                </s:else>

            </div>
        </div>


    </body>

    <script>
        $('#modalFacture').on('show.bs.modal', function (event) {
            var button = $(event.relatedTarget); // Button that triggered the modal
            var lignes = button.data('lignesFactures');
            var modal = $(this);
            modal.find('.modal-body h3').text(nom);
            $(".modal-body #article-id").val(id);
            $(".modal-body #article-nom").val(nom);
        });
    </script>

</html>
