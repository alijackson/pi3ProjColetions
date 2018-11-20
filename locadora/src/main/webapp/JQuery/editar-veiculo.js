function editarVeiculo(id) {

    let  url = "http://localhost:8080/locadora/cadastrarV?id=" + id;

    console.log(url)

    $.ajax({
        url: url,
        type: 'PUT',

        success: function (data) {
            console.log(data),
            $("#idVeiculo").val(data.idVeiculo);
            $("#modelo").val(data.modelo);
            $("#ano").val(data.ano);
            $("#placa").val(data.placa);
            $("#marca").val(data.marca);
            $("#numerodedocumento").val(data.numerodedocumento);
            $("#caracteristica").val(data.caracteristica);
            $("#categoria").val(data.categoria);
            $("#butSubmit").text("Salvar");

            $("#exampleModalCenterTitle").text("Editar Veiculo");
        },
        error: function (ajaxContext) {
            alert("error");
        }
    });

    document.getElementById('excluir').style.visibility = 'visible';

    $("#novoVeiculo").modal("show");

}


function resetFormularioVeiculo() {
    document.formEditVeiculo.reset();

    document.getElementById('excluir').style.visibility = 'hidden';

    $("#butSubmit").text("Cadastrar");

    $("#exampleModalCenterTitle").text("Cadastrar Veículo");
}
function confirmeExcluir(){
    $("#mod-confirmar").modal("show");
}
function excluirVeiculo(){
    $("#mod-confirmar").modal("hide");
    let id = document.getElementById('idVeiculo').value;
    let  url = "http://localhost:8080/locadora/cadastrarV?cod="+id;

    $.ajax({
        url: url,
        type: 'DELETE',

        success: function(data) {
            
            alert(data.resp);
            location.reload()
            $("#novoVeiculo").modal("hide");

         },
         error: function(ajaxContext) {
            alert("Erro");
            $("#novoVeiculo").modal("hide");
         }
    });
}
