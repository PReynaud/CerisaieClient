/**
 * Created by Laura on 28/12/2015.
 */
$(document).ready(function(){
    $("#formAddClient").on('submit',function(event){
        event.preventDefault();
        var result = {};
        result.numCli = $("#client").val();
        result.datedebSej = $("#dateDebut").val();
        result.dateFinSej = $("#dateFin").val();
        result.numEmpl = $("#numEmplacement").val();
        result.nbPersonnes = $("#nombrePersonne").val();

        $.ajax({
            url: 'http://localhost:8080/Sejours',
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
        });
    });
});