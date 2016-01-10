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
                <select name="client" id="client" value="${sejour.client.numCli}">
                    <c:forEach items="${listClient}" var="item">
                        <option value="${item.numCli}">${item.nomCli}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <label for="dateDebut">Date début</label> :
                <input data-provide="datepicker" name="dateDebut" id="dateDebut" value="${sejour.datedebSej}" required/>
            </p>
            <p>
                <label for="dateFin">Date fin</label> :
                <input data-provide="datepicker" name="dateFin" id="dateFin" value="${sejour.dateFinSej}" required/>
            </p>
            <p>
                <label for="numEmplacement">Numéro d'emplacement</label> :
                <input type="number" name="numEmplacement" id="numEmplacement" value="${sejour.numEmpl}" required/>
            </p>
            <p>
                <label for="nombrePersonne">Nombre de personnes</label> :
                <input type="number" name="nombrePersonne" id="nombrePersonne" value="${sejour.nbPersonnes}" required/>
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
<script src="<c:url value="/resources/js/bootstrap-datepicker.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/bootstrap-datepicker.fr.min.js"/>" type="text/javascript"></script>
</body>
</html>
