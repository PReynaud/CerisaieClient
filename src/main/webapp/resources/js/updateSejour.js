/**
 * Created by Pierre on 10/01/2016.
 */
$(document).ready(function(){
    $("#formAddSejour").on('submit',function(event){
        event.preventDefault();
        var result = {};
        result.numSej = $("#idSejour").val();

        result.numCli = $("#client").val();

        var datedebSej = $("#dateDebut").val();
        datedebSej = datedebSej.split("/");
        result.datedebSej = new Date(parseInt(datedebSej[2]), parseInt(datedebSej[1] - 1), parseInt(datedebSej[0])).getTime();

        var dateFinSej = $("#dateFin").val();
        dateFinSej = dateFinSej.split("/");$
        result.dateFinSej = new Date(parseInt(dateFinSej[2]), parseInt(dateFinSej[1] - 1), parseInt(dateFinSej[0])).getTime();

        result.numEmpl = $("#numEmplacement").val();
        result.nbPersonnes = $("#nombrePersonne").val();

        $.ajax({
            url: 'http://localhost:8080/Sejours',
            type: 'PUT',
            data: JSON.stringify(result),
            contentType: 'application/Json; charset=utf-8',
            xhrFields:{
                withCreditentials : true
            }
        }).done(function(msg){
            window.location.href = 'http://localhost:8081/listeSejour/';
            $("#addResult").append("<div class=\"alert alert-success alert-dismissible\" role=\"alert\">" +
                "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>" +
                "<strong>Effectué</strong> Le séjour a bien été ajouté</div>" );
        }).fail(function(msg){
            window.location.href = 'http://localhost:8081/listeSejour/';
            $("#addResult").append("<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">" +
                "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>" +
                "<strong>Erreur : </strong>Le séjour n'a pas pu être ajouté</div>" );
        });
    });
});