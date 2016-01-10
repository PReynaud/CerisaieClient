<%--
  Created by IntelliJ IDEA.
  User: Laura
  Date: 10/01/2016
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="header.jsp" %>
<body>
<%@include file="navbar.jsp" %>
<div class="container">
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th>Numero du séjour</th>
                <th>Numero de l'emplacement</th>
                <th>Type d'emplacement</th>
                <th>Numero du client</th>
                <th>Nom du client</th>
                <th>Adresse du client</th>
                <th>Code postal du client</th>
                <th>Ville du client</th>
                <th>Date de début</th>
                <th>Date de fin</th>
                <th>Nombre de personne</th>
                <th>Cout</th>
            </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${facture.sejourClient.numSej}</td>
                    <td>${facture.sejourClient.numEmpl}</td>
                    <td>${facture.typeEmplacement.libtypepl}</td>
                    <td>${facture.sejourClient.client.numCli}</td>
                    <td>${facture.sejourClient.client.nomCli}</td>
                    <td>${facture.sejourClient.client.adrRueCli}</td>
                    <td>${facture.sejourClient.client.cpCli}</td>
                    <td>${facture.sejourClient.client.villeCli}</td>
                    <td>${facture.sejourClient.datedebSej}</td>
                    <td>${facture.sejourClient.dateFinSej}</td>
                    <td>${facture.sejourClient.nbPersonnes}</td>
                    <td>${facture.prix}</td>
                </tr>


            </tbody>
        </table>
    </div>
</div>




<div class="container">
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th>Date activité</th>
                <th>Temps (nb unit)</th>
                <th>Code sport</th>
                <th>Sport</th>
                <th>Tarif</th>
                <th>Unite tarif</th>
            </thead>
            <tbody>
            <c:forEach items="${facture.activiteSport}" var="item">
                <tr>
                    <td>${item.dateJour}</td>
                    <td>${item.nbloc}</td>
                    <td>${item.sport.codeSport}</td>
                    <td>${item.sport.libelleSport}</td>
                    <td>${item.sport.tarifUnite}</td>
                    <td>${item.sport.uniteTpsSport}</td>

                </tr>
            </c:forEach>


            </tbody>
        </table>
    </div>
</div>


<%@include file="footer.jsp" %>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/main.js"/>" type="text/javascript"></script>
</body>
</html>
