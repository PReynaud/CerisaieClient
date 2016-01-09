<%--
  Created by IntelliJ IDEA.
  User: Laura
  Date: 09/01/2016
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <th>Date de l'activité</th>
                    <th>Numero du séjour</th>
                    <th>Nombre de bloc</th>
                    <th>Sport</th>
                    <th>Tarif</th>
                    <th>Unité de tarif</th>
                    <th>Modifier</th>
                    <th>Supprimer</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listActivite}" var="item">
                    <tr>
                        <td>${item.dateJour}</td>
                        <td>${item.numSej}</td>
                        <td>${item.nbloc}</td>
                        <td>${item.sport}</td>
                        <td>${item.tarif}</td>
                        <td>${item.unite}</td>
                        <td><a href="/listeClient/update/${item.numCli}"><span class="glyphicon glyphicon-edit"></span></a></td>
                        <td><a href="/listeClient/delete/${item.numCli}"><span class="glyphicon glyphicon-remove"></span></a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    </div>
<%@include file="footer.jsp" %>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/main.js"/>" type="text/javascript"></script>
</body>
</html>