<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="header.jsp" %>
<body>
<%@include file="navbar.jsp" %>
<div class="container">
    <div class="row">
        <!-- Trigger the modal with a button -->
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Ajouter client
        </button>

        <!-- Modal -->
        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Ajouter client</h4>
                    </div>
                    <form id="formAddClient" method="post" action="/clients">
                        <div class="modal-body">
                            <p>
                                <label for="nom">Nom</label> :
                                <input type="text" name="nom" id="nom" required/>
                            </p>
                            <p>
                                <label for="adresse">Adresse</label> :
                                <input type="text" name="adresse" id="adresse" required/>
                            </p>
                            <p>
                                <label for="codePostal">Code postal</label> :
                                <input type="number" name="codePostal" id="codePostal" required/>
                            </p>
                        </div>
                        <div class="modal-footer">
                            <input id="buttonAddClient" type="submit" class="btn btn-default" value="Envoyer"/>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
                <th>Nom</th>
                <th>Adresse</th>
                <th>Code postal</th>
                <th>Ville</th>
                <th>Modifier</th>
                <th>Supprimer</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listClient}" var="item">
                <tr>
                    <td>${item.nomCli}</td>
                    <td>${item.adrRueCli}</td>
                    <td>${item.cpCli}</td>
                    <td>${item.villeCli}</td>
                    <td><a href=""><span class="glyphicon glyphicon-edit"></span></a></td>
                    <td><a href=""><span class="glyphicon glyphicon-remove"></span></a></td>
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