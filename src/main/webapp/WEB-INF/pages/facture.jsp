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
                <th>Numero du client</th>
                <th>Numero de l'emplacement</th>
                <th>Date de début</th>
                <th>Date de fin</th>
                <th>Nombre de personne</th>
                <th>Cout</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${facture}" var="item">
                <tr>
                    <td>${item.numSej}</td>
                    <td>${item.numCli}</td>
                    <td>${item.numEmpl}</td>
                    <td>${item.datedebSej}</td>
                    <td>${item.dateFinSej}</td>
                    <td>${item.nbPersonnes}</td>
                    <td>${item.cout}</td>
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
