<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!-- Sidebar -->
<nav class="navbar navbar-default navbar-fixed-top" id="sidebar-wrapper" role="navigation">
    <ul class="nav sidebar-nav">
        <li class="sidebar-brand m-auto">
            <a href="<s:url action='welcomeLink'/>" class="text-center">
                <img alt="Brand" class="img-responsive" src="<s:url value='/images/icons8-finn.png' />">
            </a>
        </li>
        <li>
            <a href="<s:url action='welcomeLink'/>">Home</a>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Inscription <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
                <li class="dropdown-header"></li>
                <li><a href="<s:url action='inscriptionLink'/>">Nouveau</a></li>
                <li><a href="#">Reinscription</a></li>
            </ul>
        </li>
        <li>
            <a href="<s:url action='planningLink'/>">Planning</a>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Inventaire <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
                <li class="dropdown-header"></li>
                <li><a href="<s:url action='afficherarticles'/>">Articles</a></li>
                <li><a href="<s:url action='afficherCategories'/>">Categories</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Facturation <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
                <li class="dropdown-header"></li>
                <li><a href="<s:url action='afficherfactures'/>">Factures</a></li>
                <li><a href="#">Another action</a></li>
            </ul>
        </li>
    </ul>
</nav>
<!-- /#sidebar-wrapper -->
