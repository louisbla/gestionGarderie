<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
        <tiles:insertAttribute name="header" />
    </head>
    <body>
        <div id="wrapper">
            <div class="overlay"></div>

            <tiles:insertAttribute name="menu" />

            <div id="page-content-wrapper" class="mb-5 pb-5">
                <button type="button" class="hamburger is-closed" data-toggle="offcanvas">
                    <span class="hamb-top"></span>
                    <span class="hamb-middle"></span>
                    <span class="hamb-bottom"></span>
                </button>
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8 col-lg-offset-2">
                            <tiles:insertAttribute name="body" />
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <tiles:insertAttribute name="footer" />

    </body>
</html>
