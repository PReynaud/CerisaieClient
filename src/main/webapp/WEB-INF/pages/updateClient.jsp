<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="header.jsp" %>
<body>
<%@include file="navbar.jsp" %>
<div class="container">
    <form id="formUpdateClient" method="put" action="/clients">
        <div class="row">
            <input type="hidden" id="idClient" value="${client.numCli}">
            <p>
                <label for="nom">Nom</label> :
                <input type="text" name="nom" id="nom" value="${client.nomCli}" required/>
            </p>
            <p>
                <label for="adresse">Adresse</label> :
                <input type="text" name="adresse" id="adresse" value="${client.adrRueCli}" required/>
            </p>
            <p>
                <label for="codePostal">Code postal</label> :
                <input type="number" name="codePostal" id="codePostal" value="${client.cpCli}" required/>
            </p>
            <p>
                <label for="ville">Ville</label> :
                <input type="text" name="ville" id="ville"value="${client.villeCli}" required/>
            </p>
            <p>
                <label for="piece">Type de pièce d'identité</label> :
                <select id="piece">
                    <option value="CI"
                        <c:if test="${client.pieceCli == \"CI\"}">selected="selected"</c:if>>
                        Carte d'identité
                    </option>
                    <option value="PS"
                            <c:if test="${client.pieceCli == \"PS\"}">selected="selected"</c:if>>
                        Passeport
                    </option>
                    <option value="PC"
                            <c:if test="${client.pieceCli == \"PC\"}">selected="selected"</c:if>>
                        Permis de conduire
                    </option>
                </select>
            </p>
            <p>
                <label for="numPiece">Numero de la pièce d'identité</label> :
                <input type="number" name="numPiece" id="numPiece" value="${client.numPieceCli}" required/>
            </p>
        </div>
        <div class="row">
            <input id="buttonUpdateClient" type="submit" class="btn btn-default" value="Envoyer"/>
        </div>
    </form>
</div>
<%@include file="footer.jsp" %>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/main.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/updateClient.js"/>" type="text/javascript"></script>
</body>
</html>