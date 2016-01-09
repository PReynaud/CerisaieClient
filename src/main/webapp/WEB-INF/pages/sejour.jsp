<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
                <th>Numéro du séjour</th>
                <th>Numéro du client</th>
                <th>Numéro de l'emplacement</th>
                <th>Date début</th>
                <th>Date fin</th>
                <th>Nombre de personnes</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listSejour}" var="item">
                <tr>
                    <td>${item.numSej}</td>
                    <td>${item.client.nomCli}</td>
                    <td>${item.numEmpl}</td>
                    <td>${item.datedebSej}</td>
                    <td>${item.dateFinSej}</td>
                    <td>${item.nbPersonnes}</td>
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
