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
            console.log("error");
        }
    });

    $("#novoVeiculo").modal("show");



}


function resetFormularioVeiculo() {
    document.formEditVeiculo.reset();

    $("#butSubmit").text("Cadastrar");

    $("#exampleModalCenterTitle").text("Cadastrar Cliente");
}










