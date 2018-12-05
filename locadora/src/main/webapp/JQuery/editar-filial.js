function editarFilial(id) {

    let  url = "http://localhost:8080/locadora/filial?id=" + id;

    console.log(url)

    $.ajax({
        url: url,
        type: 'PUT',

        success: function (data) {
            console.log(data);
            $("#id").val(data.id);
            $("#nomefilial").val(data.nomefilial);
            $("#cidade").val(data.cidade);
            $("#telefonefixo").val(data.telefonefixo);
            $("#telefonecelular").val(data.telefonecelular);
            $("#endereco").val(data.endereco);
            $("#numero").val(data.numero);
            $("#cep").val(data.cep);
            $("#email").val(data.email);
            $("#butSubmit").text("Salvar");

            $("#modalFilial").text("Editar Filial");
        },
        error: function (ajaxContext) {
            console.log("error");
        }
    });

    document.getElementById('excluir').style.visibility = 'visible';

    $("#novaFilial").modal("show");

}

function resetFormularioFilial() {
    document.formEditFilial.reset();

    document.getElementById('excluir').style.visibility = 'hidden';

    $("#butSubmit").text("Cadastrar");

    $("#modalFilial").text("Cadastrar Filial");
}

function confirmarExcluir() {
    
    $("#mod-confirmar").modal("show");

}

function excluirFilial(){
    $("#mod-confirmar").modal("hide");
    let id = document.getElementById('id').value;
    let  url = "http://localhost:8080/locadora/filial?cod="+id;

    $.ajax({
        url: url,
        type: 'DELETE',

        success: function(data) {
            
            alert(data.resp);
            location.reload()
            $("#novaFilial").modal("hide");

         },
         error: function(ajaxContext) {
            alert("Erro ");
            $("#novaFilial").modal("hide");
         }
    });
    
}
    








