$(document).ready(function(){
    $("#formUpdateClient").on('submit',function(event){
        event.preventDefault();
        var result = {};
        result.numCli = $("#idClient").val();
        result.nomCli = $("#nom").val();
        result.adrRueCli = $("#adresse").val();
        result.cpCli = $("#codePostal").val();
        result.villeCli = $("#ville").val();
        result.pieceCli = $("#piece").val();
        result.numPieceCli = $("#numPiece").val();
        console.log(JSON.stringify(result));
        $.ajax({
            url: 'http://localhost:8080/Clients',
            type: 'PUT',
            data: JSON.stringify(result),
            contentType: 'application/Json; charset=utf-8',
            async: true,
            xhrFields:{
                withCreditentials : true
            }
        }).done(function(msg){
            window.location.href = 'http://localhost:8081/listeClient/';
            $("#addResult").append("<div class=\"alert alert-success alert-dismissible\" role=\"alert\">" +
                "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>" +
                "<strong>Effectué</strong> Le client a bien été modifié</div>" );
        }).fail(function(msg){
            window.location.href = 'http://localhost:8081/listeClient/';
            $("#addResult").append("<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">" +
                "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>" +
                "<strong>Erreur : </strong>Le client n'a pas pu être ajouté</div>" );
        });
    });
});