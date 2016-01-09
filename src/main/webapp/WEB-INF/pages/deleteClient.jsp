<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="header.jsp" %>
<body>
<%@include file="navbar.jsp" %>
<div class="container">
    <div class="row">
        <c:choose>
            <c:when test="${result.booleanValue()}">
                <div class="alert alert-success" role="alert">
                    Suppression effectuée avec succés
                </div>
            </c:when>
            <c:otherwise>
                <div class="alert alert-danger" role="alert">
                    <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                    <span class="sr-only">Erreur :</span>
                    La suppression n'a pas pu être faite
                </div>
            </c:otherwise>
        </c:choose>
        <a href="/listeClient">Retour à la liste clients</a>
    </div>
</div>
<%@include file="footer.jsp" %>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/main.js"/>" type="text/javascript"></script>
</body>
</html>