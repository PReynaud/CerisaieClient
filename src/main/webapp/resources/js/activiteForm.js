/**
 * Created by Pierre on 10/01/2016.
 */
$(document).ready(function(){
    $("#formAddActivite").on('submit',function(event){
        event.preventDefault();
        var result = {};

        var date = $("#date").val();
        date = date.split("/");
        result.dateJour = new Date(parseInt(date[2]), parseInt(date[1] - 1), parseInt(date[0])).getTime();

        result.numSej = $("#sejour").val();
        result.nbloc = $("#nblocs").val();
        result.codeSport = $("#sport").val();


        $.ajax({
            url: 'http://localhost:8080/Activite',
            type: 'POST',
            data: JSON.stringify(result),
            contentType: 'application/Json; charset=utf-8',
            xhrFields:{
                withCreditentials : true
            }
        }).done(function(msg){
            $("#myModal").modal('hide');
            $("#addResult").append("<div class=\"alert alert-success alert-dismissible\" role=\"alert\">" +
                "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>" +
                "<strong>Effectué</strong> L'activité a bien été ajoutée</div>" );
        }).fail(function(msg){
            $("#myModal").modal('hide');
            $("#addResult").append("<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">" +
                "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>" +
                "<strong>Erreur : </strong>L'activité n'a pas pu être ajoutée</div>" );
        });
    });
});