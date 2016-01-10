<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="header.jsp" %>
<body>
<%@include file="navbar.jsp" %>
<div class="container">
	<div class="row">
		<h1>Bienvenue sur votre site de gestion des séjours et des clients de votre camping ! </h1>
	</div>
	<div class="row">
		<img class="img-responsive" src="/resources/images/camping.jpg">
	</div>
	<div class="row">
		<div class="col-lg-4">
			<h2>L'onglet Client vous permet de consulter la liste des clients, d'en ajouter, d'en modifier ou d'en supprimer.</h2>
		</div>
		<div class="col-lg-offset-2 col-lg-6">
			<h2>L'onglet Séjour vous permet de consulter la liste des séjours, d'en ajouter, d'en modifier ou d'en supprimer. Il vous permet également de consulter les activité du séjour d'en ajoute ou d'en supprimer. Il est également possible de générer la facture en pdf de ce séjour.</h2>

		</div>
	</div>
</div>
<%@include file="footer.jsp" %>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/main.js"/>" type="text/javascript"></script>
</body>
</html>