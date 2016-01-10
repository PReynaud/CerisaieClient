<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="header.jsp" %>
<body>
<%@include file="navbar.jsp" %>
<div class="container">
    <div class="row" id="addResult"></div>
    <div class="row">
        <!-- Trigger the modal with a button -->
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Ajouter sejour
        </button>

        <!-- Modal -->
        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Ajouter Sejour</h4>
                    </div>
                    <form id="formAddSejour" method="post" action="/sejours">
                        <div class="modal-body">
                            <p>
                                <label for="client">Client</label> :
                                <select name="client" id="client">
                                    <c:forEach items="${listClient}" var="item">
                                        <option value="${item.numCli}">${item.nomCli}</option>
                                    </c:forEach>
                                </select>
                            </p>
                            <p>
                                <label for="dateDebut">Date début</label> :
                                <input class="datepicker" data-provide="datepicker" name="dateDebut" id="dateDebut" required/>
                            </p>
                            <p>
                                <label for="dateFin">Date fin</label> :
                                <input class="datepicker" data-provide="datepicker" name="dateFin" id="dateFin" required/>
                            </p>
                            <p>
                                <label for="numEmplacement">Numéro d'emplacement</label> :
                                <select name="emplacement" id="emplacement">
                                    <c:forEach items="${listEmplacement}" var="item">
                                        <option value="${item.numEmpl}"> emplacement ${item.numEmpl}, ${item.libtypepl}, ${item.surfaceEmpl}m carre, ${item.nbPersMaxEmpl} personnes max, ${item.tariftypepl} euros par personne</option>
                                    </c:forEach>
                                </select>
                            </p>
                            <p>
                                <label for="nombrePersonne">Nombre de personnes</label> :
                                <input type="number" name="nombrePersonne" id="nombrePersonne" required/>
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
                <th>Numéro du séjour</th>
                <th>Numéro du client</th>
                <th>Numéro de l'emplacement</th>
                <th>Date début</th>
                <th>Date fin</th>
                <th>Nombre de personnes</th>
                <th>Détails</th>
                <th>Facture</th>
                <th>Modifier</th>
                <th>Supprimer</th>
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
                    <td><a href="/listeActivite/${item.numSej}"><span class="glyphicon glyphicon-eye-open"></span></a></td>
                    <td><a href="/Facture/${item.numSej}" target="_blank"><span class=" glyphicon glyphicon-credit-card"></span></a></td>
                    <td><a href="/listeSejour/update/${item.numSej}"><span class="glyphicon glyphicon-edit"></span></a></td>
                    <td><a href="/listeSejour/delete/${item.numSej}"><span class="glyphicon glyphicon-remove"></span></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<%@include file="footer.jsp" %>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/bootstrap-datepicker.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/bootstrap-datepicker.fr.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/main.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/sejourForm.js"/>" type="text/javascript"></script>
</body>
</html>
