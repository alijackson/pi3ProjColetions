//validaçao CPF
$("#cpf").mask('000.000.000-00');

$("#rg").mask('00.000.000-00');

$("#tel").mask('(00) 0000-0000');

$("#cel").mask('(00) 0.0000-0000');

$("#idade").mask('000');

$("#id").hide();

$("#placa").mask('SSS-0000');

$("#ano").mask('0000');

$("#numerodoc").mask('00000000');

//Assim que inicia o documento ocultar as mensagens de erro
$(document).ready(function() {
    $("#erroNome").hide();
});


//Captura o evento de submit do form (caso o retorno seja FALSE nao submete o form)
// $("#form").submit(function() {
//     $("#erroNome").hide();
    
//     let valid = true;

//     let nome = $("#Nome").val();
    
//     if(nome == "") {
//         valid = false;
//         $("#erroNome").show();
//     }

//     let sobreNome = $("#SobreNome").val();

//     if(sobreNome == "") {
//         valid = false;
//     }

//     return valid;
// })