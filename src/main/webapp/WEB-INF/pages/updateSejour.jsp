<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="header.jsp" %>
<body>
<%@include file="navbar.jsp" %>
<div class="container">
    <form id="formAddSejour" method="post" action="/sejours">
        <div class="row">
            <p>
                <label for="client">Client</label> :
                <input type="text" name="client" id="client" required/>
            </p>
            <p>
                <label for="dateDebut">Date début</label> :
                <input type="text" name="dateDebut" id="dateDebut" required/>
            </p>
            <p>
                <label for="dateFin">Date fin</label> :
                <input type="text" name="dateFin" id="dateFin" required/>
            </p>
            <p>
                <label for="numEmplacement">Numéro d'emplacement</label> :
                <input type="number" name="numEmplacement" id="numEmplacement" required/>
            </p>
            <p>
                <label for="nombrePersonne">Nombre de personnes</label> :
                <input type="number" name="nombrePersonne" id="nombrePersonne" required/>
            </p>
        </div>
        <div class="row">
            <input id="buttonAddSejour" type="submit" class="btn btn-default" value="Envoyer"/>
        </div>
    </form>
</div>
<%@include file="footer.jsp" %>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/main.js"/>" type="text/javascript"></script>
</body>
</html>
