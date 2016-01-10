<%--
  Created by IntelliJ IDEA.
  User: Laura
  Date: 09/01/2016
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="header.jsp" %>
<body>
<%@include file="navbar.jsp" %>
    <div class="container">
        <div class="row" id="addResult"></div>
        <div class="row">
            <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Ajouter activité
            </button>

            <!-- Modal -->
            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Ajouter Activité</h4>
                        </div>
                        <form id="formAddActivite" method="post" action="/sejours">
                            <div class="modal-body">
                                <input type="hidden" value="${numSejour}" id="sejour">
                                <p>
                                    <label for="date">Date</label> :
                                    <input class="datepicker" data-provide="datepicker" name="date" id="date" required/>
                                </p>
                                <p>
                                    <label for="nblocs">Nombre de blocs</label> :
                                    <input type="number" name="nblocs" id="nblocs" required/>
                                </p>
                                <p>
                                    <label for="sport">Sport</label> :
                                    <select name="sport" id="sport">
                                        <c:forEach items="${listSport}" var="item">
                                            <option value="${item.codeSport}">${item.libelleSport}</option>
                                        </c:forEach>
                                    </select>
                                </p>
                            </div>
                            <div class="modal-footer">
                                <input id="buttonAddSejour" type="submit" class="btn btn-default" value="Envoyer"/>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <table class="table">
                <thead>
                <tr>
                    <th>Numero du séjour</th>
                    <th>Date de l'activité</th>
                    <th>Nombre de bloc</th>
                    <th>Sport</th>
                    <th>Tarif</th>
                    <th>Unité de tarif</th>
                    <th>Supprimer</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listActivite}" var="item">
                    <tr>
                        <td>${item.numSej}</td>
                        <td>${item.dateJour}</td>
                        <td>${item.nbloc}</td>
                        <td>${item.sport.libelleSport}</td>
                        <td>${item.sport.tarifUnite}</td>
                        <td>${item.sport.uniteTpsSport}</td>
                        <td><a href="/listeActivite/${numSejour}/delete/${item.sport.codeSport}/${item.calculateTimestamp()}"><span class="glyphicon glyphicon-remove"></span></a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    </div>
<%@include file="footer.jsp" %>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/bootstrap-datepicker.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/bootstrap-datepicker.fr.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/main.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/activiteForm.js"/>" type="text/javascript"></script>
</body>
</html>