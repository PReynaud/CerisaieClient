/**
 * Created by Laura on 28/12/2015.
 */
$(document).ready(function(){
    $("#formAddClient").on('submit',function(event){
        event.preventDefault();
        var result = {};
        result.nomCli = $("#nom").val();
        result.adrRueCli = $("#adresse").val();
        result.cpCli = $("#codePostal").val();
        result.villeCli = $("#ville").val();
        result.pieceCli = $("#piece").val();
        result.numPieceCli = $("#numPiece").val();

        $.ajax({
            url: 'http://localhost:8080/Clients',
            type: 'POST',
            data: JSON.stringify(result),
            contentType: 'application/Json; charset=utf-8',
            dataType: 'json',
            async: true,
            xhrFields:{
                withCreditentials : true
            },
            success: function(msg){
                alert(msg);
            }
        })
        console.log("bonjour");
    });
});