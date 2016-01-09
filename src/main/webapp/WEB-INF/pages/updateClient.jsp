<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="header.jsp" %>
<body>
<%@include file="navbar.jsp" %>
<div class="container">
    <form id="formUpdateClient" method="put" action="/clients">
        <div class="row">
            <p>
                <label for="nom">Nom</label> :
                <input type="text" name="nom" id="nom" value="${client.nomCli}" required/>
            </p>
            <p>
                <label for="adresse">Adresse</label> :
                <input type="text" name="adresse" id="adresse" value="${client.adrRueCli}" required/>
            </p>
            <p>
                <label for="codePostal">Code postal</label> :
                <input type="number" name="codePostal" id="codePostal" value="${client.cpCli}" required/>
            </p>
        </div>
        <div class="row">
            <input id="buttonUpdateClient" type="submit" class="btn btn-default" value="Envoyer"/>
        </div>
    </form>
</div>
<%@include file="footer.jsp" %>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/main.js"/>" type="text/javascript"></script>
</body>
</html>